package salesforce.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.HomePage;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;

/**
 * Created by AT-05 team on 12/1/2017.
 */
public class LoginSteps {
  private final PageTransporter pageTransporter;
  private LoginPage loginPage;
  private HomePage homePage;

  /**
   * <p>This constructor gets page transporter instance.</p>
   */
  public LoginSteps() {
    pageTransporter = PageTransporter.getInstance();
  }

  /**
   * <p>This step performs navigation to main page.</p>
   */
  @Given("^I navigate to Main Page$")
  public void iNavigateToMainPage() {
    loginPage = pageTransporter.navigateToMainPage();
  }

  /**
   * <p>This step performs login of user into the application.</p>
   */
  @When("^I login to salesforce$")
  public void iLoginToSalesforce() {
    homePage = loginPage.login(SalesForceAppEnvsConfig.getInstance().getUserName(),
      SalesForceAppEnvsConfig.getInstance().getUserPassword());
  }

  /**
   * <p>This step performs checked of successful user login.</p>
   */
  @Then("^I should be redirected to home page$")
  public void iShouldBeRedirectedToHomePage() {
    assertTrue(homePage.isHomePage());
  }
}
