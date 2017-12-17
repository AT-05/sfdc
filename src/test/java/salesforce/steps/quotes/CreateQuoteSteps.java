package salesforce.steps.quotes;

import cucumber.api.java.After;
import org.apache.log4j.Logger;
import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import salesforce.salesforceapp.api.methods.APIQuote;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyQuotesView;
import salesforce.salesforceapp.ui.quotes.QuoteEditionForm;
import salesforce.salesforceapp.ui.quotes.QuotesContentPage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class CreateQuoteSteps {
  private Logger log = Logger.getLogger(getClass());

  //Pages
  private HomePage homePage;
  private OppyHomePage oppyHomePage;
  private OppyContentPage oppyContentPage;
  private OppyQuotesView oppyQuotesView;
  private QuoteEditionForm quoteEditionForm;
  private QuotesContentPage quotesContentPage;

  //Entities
  private Oppy oppy;

  //Auxiliary variables
  private String quoteName;

  @Given("^I go to Opportunities Home Page$")
  public void iGoToOpportunitiesHomePage() {
    homePage = PageFactory.getHomePage();
    oppyHomePage = homePage.topMenu.goToOppyHomePage();
  }

  @And("^I select the Opportunity created \"([^\"]*)\"$")
  public void iSelectTheOpportunityCreated(String opportunityName) {
    oppy = new Oppy();
    oppy.setOppyName(opportunityName);
    oppyContentPage = oppyHomePage.selectOppy(oppy.getOppyName());
  }

  @And("^I go to Opportunity Quotes view$")
  public void iGoToOpportunityQuotesView() {
    oppyQuotesView = oppyContentPage.goToQuotesView();
  }

  @When("^I create a Quote with the following information$")
  public void iCreateAQuoteWithTheFollowingInformation(List<Quote> quoteCreateInfo) {
    oppy.setQuoteList(quoteCreateInfo);
    for (Quote itemQuote : quoteCreateInfo) {
      quoteName = itemQuote.getName();
    }
    quoteEditionForm = oppyQuotesView.goToCreateQuote();
    quoteEditionForm.createQuote(oppy, quoteName);
  }

  @Then("^A Quote successful creation message should be displayed$")
  public void aQuoteSuccessfulCreationMessageShouldBeDisplayed() {
    assertTrue(quoteEditionForm.isQuoteCreatedMessageDisplayed(quoteName), "'Quote was created' message was not displayed");
  }

  @And("^The Quote should be created with the correct information$")
  public void theQuoteShouldBeCreatedWithTheCorrectInformation() {
    quotesContentPage = quoteEditionForm.openQuote(quoteName);
    quotesContentPage.openQuoteDetails();
    oppy.getQuote(quoteName).calculateGrandTotal();
    assertTrue(quotesContentPage.isQuoteInfoCorrect(oppy.getQuote(quoteName)), "The quote information after creating is not correct");
  }

  //****************************************************************
  //Hooks for @Quote scenarios
  //****************************************************************
  @After(value = "@Quote", order = 999)
  public void afterCreateQuote() {
    log.info("After hook @Quote");
    if (!APIQuote.isQuoteSaved(oppy.getQuote(quoteName))) {
      //TODO
      APIQuote.deleteQuote(oppy.getQuote(quoteName));
    }
  }
}
