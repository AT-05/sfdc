package salesforce.steps.quotes;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

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
    assertTrue(quotesContentPage.isQuoteDeletedMessageDisplayed(quote.getName()), "'Quote was deleted' message was not displayed");
  }

  @And("^The Quote should disappear from the Quotes list$")
  public void theQuoteShouldDisappearFromTheQuotesList() {
    quotesHomePage = quotesContentPage.topMenu.goToQuotesHomePage();
    assertFalse(quotesHomePage.isQuoteElementPresent(quote.getName()), "'Quote was not deleted");
  }
}
