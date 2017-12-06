package salesforce.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.Oppy;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

public class OpportunitiesSteps {

  private Logger log = Logger.getLogger(getClass());

  //Pages
  private HomePage homePage;
  private OppyHomePage oppyHomePage;
  private OppyContentPage oppyContentPage;
  private OppyEditionForm oppyEditionForm;

  //Entities
  private Oppy oppy;

  public OpportunitiesSteps() throws Exception {
    homePage = PageFactory.getHomePage();
  }

  //****************************************************************
  //OpportunitiesSteps Step Definitions
  //****************************************************************
  @And("^I go to Opportunities home page$")
  public void iGoToAccountsHomePage() {
    oppyHomePage = homePage.topMenu.goToOppyHomePage();
  }

  @When("^I create a New Opportunity with the following information:$")
  public void iCreateANewOpportunityWithTheFollowingInformation() {
    //get data from feature file and set in Oppy object
    oppyEditionForm = oppyHomePage.clickNewOppyBtn();
    oppyContentPage = oppyEditionForm.createOppy(oppy);
  }
}
