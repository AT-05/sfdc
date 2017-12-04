package salesforce.steps;

import cucumber.api.java.en.Given;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;

/**
 * Created by Administrator on 12/1/2017.
 */
public class Steps {

  LoginPage loginPage;
  HomePageAbstract homePageAbstract;

  @Given("^I'm logged to Salesforce$")
  public void iMLoggedToSalesforce() {
    loginPage = PageTransporter.getInstance().navigateToPrincipalPage();
    homePageAbstract = loginPage.login(SalesForceAppEnvsConfig.getInstance().getUserName(),
        SalesForceAppEnvsConfig.getInstance().getUserPassword());

  }
}
