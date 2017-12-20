package salesforce.steps.quotes;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
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
//    homePage = PageFactory.getHomePage();
//    oppyHomePage = homePage.topMenu.goToOppyHomePage();
    oppy = new Oppy();
    oppy.setOppyName(opportunityName);
    oppy.setCloseDate("12/12/2018");
    oppy.setStage("Qualification");
//    oppyContentPage = oppyHomePage.selectOppy(opportunityName);
//    oppyQuotesView = oppyContentPage.goToQuotesView();
    oppy.setQuoteList(quoteCreateInfo);
    for (Quote itemQuote : quoteCreateInfo) {
      quoteName = itemQuote.getName();
    }

    //Creating oppy
    apiOppy = new APIOppy(oppy);
    apiOppy.createOppy();
    //Getting oppy id
    oppy.setId(apiOppy.getOppyId());
    System.out.println("************is oppy saved: ");
    apiOppy.isOppySaved();

    //Setting quote
    quote.setQuote(oppy.getQuote(quoteName));
    //Setting oppy api id in quote
    quote.setOpportunityId(oppy.getId());

    //Creating quote
    apiQuote = new APIQuote(quote);
    apiQuote.createQuote();
    //Setting quote api id
    apiQuote.isQuoteSaved();

//    quoteEditionForm = oppyQuotesView.goToCreateQuote();
//    quoteEditionForm.createQuote(oppy, quoteName);
//    quoteEditionForm.isQuoteCreatedMessageDisplayed(quoteName);
    //Dependency injection variable setting

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
}
