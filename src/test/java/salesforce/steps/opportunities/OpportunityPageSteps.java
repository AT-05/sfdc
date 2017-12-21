package salesforce.steps.opportunities;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public class OpportunityPageSteps {

  /*private Logger log = Logger.getLogger(getClass());
  private PageTransporter pageTransporter;

  //Pages
  private LoginPage loginPage;
  private HomePage homePage;
  private OppyHomePage oppyHomePage;

  //Entities
  private Oppy oppy;

  public OpportunityPageSteps() {
    pageTransporter = PageTransporter.getInstance();
  }

  /*//****************************************************************
  //Login Step Definitions
  /*//****************************************************************
  @Given("^I'm logged to Salesforce$")
  public void iMLoggedToSalesforce() {
    loginPage = pageTransporter.navigateToLoginPage();
    if (pageTransporter.isOnLogin()) {
      String username = SalesForceAppEnvsConfig.getInstance().getUserName();
      String password = SalesForceAppEnvsConfig.getInstance().getUserPassword();
      homePage = loginPage.login(username, password);
    }
  }

  @Then("^the Opportunities page should be displayed$")
  public void theOpportunitiesPageShouldBeDisplayed() {
    assertTrue(oppyHomePage.isOpportunitiesHomePage(),
        "User is able to see opportunities home page.");
  }*/
}
