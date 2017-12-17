package salesforce.steps.quotes;

import cucumber.api.java.After;
import org.apache.log4j.Logger;
import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import salesforce.salesforceapp.api.methods.APIQuote;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.quotes.AddQuoteLineItemPage;
import salesforce.salesforceapp.ui.quotes.QuoteLineItemEditionForm;
import salesforce.salesforceapp.ui.quotes.QuotePriceBookSelectionPage;
import salesforce.salesforceapp.ui.quotes.QuotesContentPage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class AddQuoteLineItemSteps {
  private Logger log = Logger.getLogger(getClass());

  //Pages
  private QuotesHomePage quotesHomePage;
  private QuotesContentPage quotesContentPage;
  private QuotePriceBookSelectionPage quotePriceBookSelectionPage;
  private AddQuoteLineItemPage addQuoteLineItemPage;
  private QuoteLineItemEditionForm quoteLineItemEditionForm;

  //Entities
  private List<Product> products;
  private Quote quote;
  //Auxiliary variables

  @And("^I select the Quote created with name \"([^\"]*)\", expiration date \"([^\"]*)\", status \"([^\"]*)\", description, \"([^\"]*)\", tax \"([^\"]*)\" and shipping and handling \"([^\"]*)\"$")
  public void iSelectTheQuoteCreatedWithNameExpirationDateStatusDescriptionTaxAndShippingAndHandling(String quoteName, String quoteExpDate, String quoteStatus, String quoteDescription, double quoteTax, double quoteShippingAndHandling) {
    quote = new Quote();
    quote.setName(quoteName);
    quote.setExpirationDate(quoteExpDate);
    quote.setStatus(quoteStatus);
    quote.setDescription(quoteDescription);
    quote.setTax(quoteTax);
    quote.setShippingAndHandling(quoteShippingAndHandling);
    quotesHomePage = PageFactory.getQuotesHomePage();
    quotesContentPage = quotesHomePage.selectQuote(quoteName);
  }

  @When("^I add the following Products related to PriceBook \"([^\"]*)\" to the Quote$")
  public void iAddTheFollowingProductsRelatedToPriceBookToTheQuote(String priceBookName, List<Product> productList) {
    products = productList;
    for (Product itemProduct : products) {
      quote.addQuoteLineItem(itemProduct);
      itemProduct.calculateSubTotal();
      itemProduct.calculateTotalPrice();
    }
    quotePriceBookSelectionPage = quotesContentPage.goToAddLineItem();
    addQuoteLineItemPage = quotePriceBookSelectionPage.selectPriceBook(priceBookName);
    quoteLineItemEditionForm = addQuoteLineItemPage.addQuoteLineItem(products);
    quotesContentPage = quoteLineItemEditionForm.editQuoteLineItem(products);
  }

  @Then("^A successful saved changes message should be displayed$")
  public void aSuccessfulSavedChangesMessageShouldBeDisplayed() {
    assertTrue(quotesContentPage.isQuoteLineItemCreatedMessageDisplayed(), "'Quote was created' message was not displayed");
  }

  @And("^I should see the new Products in the Quote Line Items list$")
  public void iShouldSeeTheNewProductsInTheQuoteLineItemsView() {
    assertTrue(quotesContentPage.isQuoteLineItemsListUpdated(products), "The quote line items were not found on the list");
  }

  @And("^The Quote Totals should be updated correctly$")
  public void theQuoteTotalsShouldBeUpdatedCorrectly() {
    quotesContentPage.openQuoteDetails();
    quote.calculateSubTotal();
    quote.calculateTotalPrice();
    quote.calculateDiscount();
    quote.calculateGrandTotal();
    assertTrue(quotesContentPage.areQuoteTotalsUpdated(quote), "The quote totals were not updated correctly");
  }

  //****************************************************************
  //Hooks for @@QuoteLineItem scenarios
  //****************************************************************
  @After(value = "@@QuoteLineItem", order = 999)
  public void afterAddQuoteLineItem() {
    log.info("After hook @@QuoteLineItem");
    if (!APIQuote.isQuoteLineItemSaved(quote)) {
      //TODO
      APIQuote.deleteQuoteLineItem(quote);
    }
  }
}
