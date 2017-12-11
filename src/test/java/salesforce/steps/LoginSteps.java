package salesforce.steps;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.ProfilePage;
import salesforce.salesforceapp.ui.home.HomePage;

/**
 * Created by AT05 team on 12/11/2017.
 */
public class LoginSteps {
  private Logger log = Logger.getLogger(getClass());
  private PageTransporter pageTransporter;

  //Pages
  private LoginPage loginPage;
  private HomePage homePage;
  private ProfilePage profilePage;

  public LoginSteps() throws Exception {
    this.pageTransporter = PageTransporter.getInstance();
  }

  //****************************************************************
  //Login Step Definitions
  //****************************************************************
  @Given("^I navigate to Login page$")
  public void navigateToLoginPage() {
    loginPage = new LoginPage();
  }

  @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
  public void login(String username, String password) {
    homePage = loginPage.login(username, password);
  }

  @Then("^I should login successfully$")
  public void verifyMainPageIsDisplayed() {
    profilePage = homePage.topMenu.goToProfilePage();
    assertTrue(profilePage.isUserNameDisplayed(), "User email displayed in Web");
  }

  @Given("^I am logged to Salesforce")
  public void iAmLoggedToMyApplication() {
    if (pageTransporter.isOnLogin()) { //If the user is not logged
      loginPage = new LoginPage();
      final String userName = SalesForceAppEnvsConfig.getInstance().getUserName();
      final String password = SalesForceAppEnvsConfig.getInstance().getUserPassword();
      login(userName, password);
    }
  }

  //****************************************************************
  //Hooks for @Login scenarios
  //****************************************************************
  @After(value = "@Login", order = 999)
  public void afterLoginScenario() {
    log.info("After hook @Login");
    homePage.topMenu.logout();
  }
}
