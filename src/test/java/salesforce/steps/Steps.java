package salesforce.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.HomeAbstract;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;

/**
 * Created by Administrator on 12/1/2017.
 */
public class Steps {

  LoginPage loginPage;
  HomeAbstract homeAbstract;

  @Given("^I'm logged to Salesforce$")
  public void iMLoggedToSalesforce() {
    loginPage = PageTransporter.getInstance().navigateToLoginPage();

    homeAbstract = loginPage.login(SalesForceAppEnvsConfig.getInstance().getUserName(),
        SalesForceAppEnvsConfig.getInstance().getUserPassword());

  }

  @When("^I go to Opportunities page$")
  public void iGoToOpportunitiesPage() {

  }
}
