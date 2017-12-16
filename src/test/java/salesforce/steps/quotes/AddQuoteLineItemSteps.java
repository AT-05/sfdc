package salesforce.steps.quotes;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.quotes.AddQuoteLineItemPage;
import salesforce.salesforceapp.ui.quotes.QuoteLineItemEditionForm;
import salesforce.salesforceapp.ui.quotes.QuoteLineItemsView;
import salesforce.salesforceapp.ui.quotes.QuotePriceBookSelectionPage;
import salesforce.salesforceapp.ui.quotes.QuotesContentPage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class AddQuoteLineItemSteps {
  //Pages
  private QuotesHomePage quotesHomePage;
  private QuotesContentPage quotesContentPage;
  private QuotePriceBookSelectionPage quotePriceBookSelectionPage;
  private AddQuoteLineItemPage addQuoteLineItemPage;
  private QuoteLineItemEditionForm quoteLineItemEditionForm;
  private QuoteLineItemsView quoteLineItemsView;

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
      System.out.println("*******sales price: " + itemProduct.getSalesPrice());
      System.out.println("*******quantity: " + itemProduct.getQuantity());
      System.out.println("*******discount: " + itemProduct.getDiscount());
      itemProduct.calculateSubTotal();
      System.out.println("*******sub total: " + itemProduct.getSubTotal());
      itemProduct.calculateTotalPrice();
      System.out.println("*******total price: " + itemProduct.getTotalPrice());
    }
    quotePriceBookSelectionPage = quotesContentPage.goToAddLineItem();
    addQuoteLineItemPage = quotePriceBookSelectionPage.selectPriceBook(priceBookName);
    quoteLineItemEditionForm = addQuoteLineItemPage.addQuoteLineItem(products);
    quotesContentPage = quoteLineItemEditionForm.editQuoteLineItem(products);
  }

  @Then("^A successful saved changes message should be displayed$")
  public void aSuccessfulSavedChangesMessageShouldBeDisplayed() {
    assertTrue(quotesContentPage.isQuoteLineItemCreatedMessageDisplayed());
  }

  @And("^The Quote Totals should be updated correctly$")
  public void theQuoteTotalsShouldBeUpdatedCorrectly() {
    quotesContentPage.openQuoteDetails();
    System.out.println("quote tax: " + quote.getTax());
    System.out.println("quote shipping and handling: " + quote.getShippingAndHandling());
    quote.calculateSubTotal();
    System.out.println("quote sub total: " + quote.getSubTotal());
    quote.calculateTotalPrice();
    System.out.println("quote total price: " + quote.getTotalPrice());
    quote.calculateDiscount();
    System.out.println("quote discount: " + quote.getDiscount());
    quote.calculateGrandTotal();
    System.out.println("quote grand total: " + quote.getGrandTotal());
    assertTrue(quotesContentPage.areQuoteTotalsUpdated(quote));
  }

  @And("^I should see the new Products in the Quote Line Items view$")
  public void iShouldSeeTheNewProductsInTheQuoteLineItemsView() {
//    quoteLineItemsView = quotesContentPage.goToQuoteLineItemsView();
//    assertTrue(quoteLineItemsView.isQuoteLineItemsListUpdated(products));
  }
}
