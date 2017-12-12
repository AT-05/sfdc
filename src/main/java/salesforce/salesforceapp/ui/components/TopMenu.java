package salesforce.salesforceapp.ui.components;

import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.ProfilePage;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;

/**
 * Created by AT05 team on 12/11/2017.
 */
public abstract class TopMenu extends BasePage {

  /**
   * <p>This method performs switching of web page skin.</p>
   */
  public abstract void switchSkin();

  /**
   * <p>This mehtod logs out user from the application.</p>
   *
   * @return a LoginPage object type.
   */
  public abstract LoginPage logout();

  public abstract HomePage goToHomePage();

  public abstract OppyHomePage goToOppyHomePage();

  /**
   * <p>This method redirects to Quotes Home Page.</p>
   *
   * @return a QuotesHomePage object type.
   */
  public abstract QuotesHomePage goToQuotesHomePage();

  public boolean isUserNameDisplayed() {
    //Missing
    return false;
  }

  /**
   * <p>This method sends to user profile page.</p>
   *
   * @return a ProfilePage object type.
   */
  public abstract ProfilePage goToProfilePage();
}
