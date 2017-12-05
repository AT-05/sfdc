package salesforce.salesforceapp.ui.components;

import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

public abstract class TopMenu extends BasePage {

  public void swithSkin() {
  }

  public LoginPage logout() {
    return new LoginPage();
  }

  public abstract HomePage goToHomePage();

  public abstract OppyHomePage goToOppyHomePage();

}
