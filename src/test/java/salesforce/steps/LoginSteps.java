package salesforce.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;


public class LoginSteps {

  private Logger log = Logger.getLogger(getClass());
  private PageTransporter pageTransporter;

  //Pages
  private LoginPage loginPage;
  private HomePage homePage;
  private OppyHomePage oppyHomePage;
  private OppyContentPage oppyContentPage;
  private OppyEditionForm oppyEditionForm;

  //Entities
  private Oppy oppy;

  public LoginSteps() throws Exception {
    this.pageTransporter = PageTransporter.getInstance();
  }

  //****************************************************************
  //Login Step Definitions
  //****************************************************************
  @Given("^I navigate to Login page$")
  public void navigateToLoginPage() {
    loginPage = pageTransporter.navigateToLoginPage();
  }

  @When("^I login with enviroments params$")
  public void iLoginWithEnviromentsParams() {
    homePage = loginPage.login(SalesForceAppEnvsConfig.getInstance().getUserName(),
      SalesForceAppEnvsConfig.getInstance().getUserPassword());
  }

  @Then("^I should login successfully$")
  public void verifyMainPageIsDisplayed() {
//        assertTrue(homePage.isUserNameDisplayed(), "User name displayed in Web);
  }

  @Given("^I am logged to Salesforce")
  public void iAmLoggedToMyApplication() {
    loginPage = pageTransporter.navigateToLoginPage();//fix
    if (pageTransporter.isOnLogin()) {      //if the user is not logged
      final String userName = SalesForceAppEnvsConfig.getInstance().getUserName();
      final String password = SalesForceAppEnvsConfig.getInstance().getUserPassword();
      homePage = loginPage.login(userName, password);
    }
  }


  //****************************************************************
  //Hooks for @Login scenarios
  //****************************************************************
  @After(value = "@Login", order = 999)
  public void afterLoginScenario() {
    log.info("After hook @Login");
//        logOut();
  }


}