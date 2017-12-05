package salesforce.salesforceapp.ui.components;

import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

public abstract class TopMenu extends BasePage {

  /**
   * <p>This method performs switching of web page skin.</p>
   */
  public abstract void switchSkin();

  public LoginPage logout() {
    return new LoginPage();
  }

  public abstract HomePage goToHomePage();

  public abstract OppyHomePage goToOppyHomePage();

  public abstract AccountHomePage goToAccountsHomePage();
}
