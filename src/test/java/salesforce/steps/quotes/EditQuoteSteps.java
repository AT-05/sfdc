package salesforce.steps.quotes;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyQuotesView;
import salesforce.salesforceapp.ui.quotes.QuoteEditionForm;
import salesforce.salesforceapp.ui.quotes.QuotesContentPage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class EditQuoteSteps {
  private HomePage homePage;
  private OppyHomePage oppyHomePage;
  private OppyQuotesView oppyQuotesView;
  private QuotesHomePage quotesHomePage;
  private QuotesContentPage quotesContentPage;
  private OppyContentPage oppyContentPage;
  private QuoteEditionForm quoteEditionForm;

  //Entities
  private Oppy oppy;
  private final Quote quote; //Dependency injection variable

  //Auxiliary variables
  private String quoteName;

  public EditQuoteSteps(Quote quote) {
    this.quote = quote;
  }

  @Given("^I have a Quote created in opportunity \"([^\"]*)\" with the following information$")
  public void iHaveAQuoteCreatedInOpportunityWithTheFollowingInformation(String opportunityName, List<Quote> quoteCreateInfo) {
    homePage = PageFactory.getHomePage();
    oppyHomePage = homePage.topMenu.goToOppyHomePage();
    oppy = new Oppy();
    oppy.setOppyName(opportunityName);
    oppyContentPage = oppyHomePage.selectOppy(oppy.getOppyName());
    oppyQuotesView = oppyContentPage.goToQuotesView();
    oppy.setQuoteList(quoteCreateInfo);
    for (Quote itemQuote : quoteCreateInfo) {
      quoteName = itemQuote.getName();
    }
    quoteEditionForm = oppyQuotesView.goToCreateQuote();
    quoteEditionForm.createQuote(oppy, quoteName);
    quoteEditionForm.isQuoteCreatedMessageDisplayed(quoteName);
    //Dependency injection variable setting
    quote.setQuote(oppy.getQuote(quoteName));
  }

  @And("^I go to Quotes Home Page$")
  public void iGoToQuotesHomePage() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    homePage = quoteEditionForm.topMenu.goToHomePage();
    quotesHomePage = homePage.topMenu.goToQuotesHomePage();
  }

  @And("^I select the Quote created$")
  public void iSelectTheQuoteCreated() {
    quotesContentPage = quotesHomePage.selectQuote(quoteName);
  }

  @When("^I edit the Quote with the following information$")
  public void iEditTheQuoteWithTheFollowingInformation(List<Quote> quoteEditInfo) {
    oppy.updateQuote(quoteEditInfo, quoteName);
    quoteEditionForm = quotesContentPage.goToEditQuote();
    quotesContentPage = quoteEditionForm.editQuote(oppy, quoteName);
  }

  @Then("^A Quote successful editing message should be displayed$")
  public void aQuoteSuccessfulEditingMessageShouldBeDisplayed() {
    assertTrue(quotesContentPage.isQuoteEditedMessageDisplayed(quoteName));
    System.out.println("message result: " + quotesContentPage.isQuoteEditedMessageDisplayed(quoteName));
  }

  @And("^I should see the Quote information updated in the Quote details view$")
  public void iShouldSeeTheQuoteInformationUpdatedInTheQuoteDetailsView() {
    quotesContentPage.openQuoteDetails();
    assertTrue(quotesContentPage.isQuoteInfoCorrect(oppy, quoteName));
    System.out.println("verification result: " + quotesContentPage.isQuoteInfoCorrect(oppy, quoteName));
  }
}
