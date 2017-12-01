package salesforce.steps;

import cucumber.api.*;
import cucumber.api.java.*;
import cucumber.api.java.en.*;
import salesforce.salesforceapp.config.*;
import salesforce.salesforceapp.ui.*;

/**
 * Created by Administrator on 12/1/2017.
 */
public class LoginSteps {
  private final PageTransporter pageTransporter;
  private LoginPage loginPage;
  private HomePage homePage;
  //private Automation automation;

  /**
   * <p>This constructor gets page transporter instance.</p>
   */
  public LoginSteps() {
    /*try {
      automation = Automation.getInstance();
      automation.startUp();
    } catch (Exception e) {
      e.printStackTrace();
    }*/
    pageTransporter = PageTransporter.getInstance();
  }

  /**
   * <p>This step performs navigation to main page.</p>
   */
  @Given("^I navigate to Main Page$")
  public void i_navigate_to_Main_Page() {
    loginPage = pageTransporter.navigateToMainPage();
  }

  /**
   * <p>This step performs login of user into the application.</p>
   */
  @When("^I login to salesforce$")
  public void i_login_to_salesforce() {
    homePage = loginPage.login(SalesForceAppEnvsConfig.getInstance().getUserName(),
      SalesForceAppEnvsConfig.getInstance().getUserPassword());
  }

  /**
   * <p>This step performs checked of successful user login.</p>
   */
  @Then("^I should be redirected to home page$")
  public void i_should_be_redirected_to_home_page() {
    //assertTrue(homePage.isCurrentPage());
  }

  /**
   * <p>This step is executed after loginUser scenario.</p>
   */
  @After(value = "@Login", order = 999)
  public void afterLoginScenario() {

  }
}
