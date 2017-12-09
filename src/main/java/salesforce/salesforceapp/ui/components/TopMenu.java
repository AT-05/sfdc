package salesforce.salesforceapp.ui.components;

import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.quotes.*;

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

  /**
   * <p>This method redirects to Quotes Home Page.</p>
   *
   * @return a QuotesHomePage object type.
   */
  public abstract QuotesHomePage goToQuotesHomePage();
}
