package salesforce.steps.quotes;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.quotes.QuotesContentPage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class DeleteQuoteSteps {
  private QuotesContentPage quotesContentPage;
  private QuotesHomePage quotesHomePage;

  //Entities
  private final Quote quote;

  //Auxiliary variables
  private String quoteName;

  public DeleteQuoteSteps(Quote quote){
    this.quote = quote;
  }

  @When("^I delete the Quote$")
  public void iDeleteTheQuote() {
    quotesContentPage = PageFactory.getQuotesContentPage();
    quotesContentPage.deleteQuote();
  }

  @Then("^A Quote successful deleting message should be displayed$")
  public void aQuoteSuccessfulDeletingMessageShouldBeDisplayed() {
    assertTrue(quotesContentPage.isQuoteDeletedMessageDisplayed(quote.getName()));
    System.out.println("message result: " + quotesContentPage.isQuoteDeletedMessageDisplayed(quote.getName()));
  }

  @And("^The Quote should disappear from the Quotes list$")
  public void theQuoteShouldDisappearFromTheQuotesList() {
    quotesHomePage = quotesContentPage.topMenu.goToQuotesHomePage();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertFalse(quotesHomePage.isQuoteElementPresent(quote.getName()));
    System.out.println("verification result: " + quotesHomePage.isQuoteElementPresent(quote.getName()));
  }
}
