package salesforce.steps.quotes;

import cucumber.api.java.*;
import org.apache.log4j.*;
import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

import salesforce.core.utils.*;
import salesforce.salesforceapp.api.methods.*;
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
  private Logger log = Logger.getLogger(getClass());

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

  //Api
  private APIOppy apiOppy;
  private APIQuote apiQuote;

  public EditQuoteSteps(Quote quote) {
    this.quote = quote;
  }

  @Given("^I have a Quote created in opportunity \"([^\"]*)\" with the following information$")
  public void iHaveAQuoteCreatedInOpportunityWithTheFollowingInformation(String opportunityName, List<Quote> quoteCreateInfo) {
    oppy = new Oppy();
    oppy.setOppyName(opportunityName);
    oppy.addQuote(quoteCreateInfo.get(0));
    quoteName = quoteCreateInfo.get(0).getName();
    //Dependency injection variable setting
    quote.setQuote(quoteCreateInfo.get(0));
    quote.setOpportunityId(oppy.getId());
    apiQuote = new APIQuote(quote);
    apiQuote.createSObjectRecord();
    apiQuote.isSObjectRecordSaved();
  }

  @And("^I go to Quotes Home Page$")
  public void iGoToQuotesHomePage() {
    homePage = PageFactory.getHomePage();
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
    assertTrue(quotesContentPage.isQuoteEditedMessageDisplayed(quoteName), "'Quote was saved' message was not displayed");
  }

  @And("^The Quote information should be updated correctly$")
  public void theQuoteInformationShouldBeUpdatedCorrectly() {
    quotesContentPage.openQuoteDetails();
    oppy.getQuote(quoteName).calculateGrandTotal();
    assertTrue(quotesContentPage.isQuoteInfoCorrect(oppy.getQuote(quoteName)), "The quote information after editing is not correct");
  }

  //****************************************************************
  //Hooks for @Quote scenarios
  //****************************************************************
  @After(value = "@EditQuote", order = 999)
  public void afterEditQuote() {
    log.info("After hook @EditQuote");
    if (!apiQuote.isSObjectRecordSaved()){
      apiQuote.deleteSObjectRecord();
    }
  }
}
