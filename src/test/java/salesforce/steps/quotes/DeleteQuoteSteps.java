package salesforce.steps.quotes;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import salesforce.salesforceapp.entities.opportunities.Oppy;
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
  private final Oppy oppy;

  //Auxiliary variables
  private final String quoteName;

  public DeleteQuoteSteps(Oppy oppy, String quoteName){
    this.oppy = oppy;
    this.quoteName = quoteName;
  }

  @When("^I delete the Quote$")
  public void iDeleteTheQuote() {
    quotesContentPage = PageFactory.getQuotesContentPage();
    //quotesContentPage.deleteQuote(quoteName);
  }

  @Then("^A Quote successful deleting message should be displayed$")
  public void aQuoteSuccessfulDeletingMessageShouldBeDisplayed() {
    //assertTrue(quotesContentPage.isQuoteDeletedMessageDisplayed());
  }

  @And("^The Quote should disappear from the Quotes list$")
  public void theQuoteShouldDisappearFromTheQuotesList() {
    /*quotesHomePage = quotesContentPage.topMenu.goToQuotesHomePage();
    assertFalse(quotesHomePage.isQuoteElementPresent());*/
  }
}
