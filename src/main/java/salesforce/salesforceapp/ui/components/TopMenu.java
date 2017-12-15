package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.ProfilePage;
import salesforce.salesforceapp.ui.contacts.ContactHomePage;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;

/**
 * Created by AT05 team on 12/11/2017.
 */
public abstract class TopMenu extends BasePage {

  /**
   * <p>This method performs switching of web page skin.</p>
   */
  public abstract void switchSkin();

  @Override
  public void waitUntilPageObjectIsLoaded() {
    //wait.until(ExpectedConditions.urlContains("home"));
  }

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

  /**
   * <p>This method sends to user profile page.</p>
   *
   * @return a ProfilePage object type.
   */
  public abstract ProfilePage goToProfilePage();

  /**
   * This method go to Home Product.
   *
   * @return homeProduct.
   */
  public abstract HomeProductPage goToHomeProduct();

  /**
   * This method go to Home Contact.
   *
   * @return ContactHomePage object type.
   */
  public abstract ContactHomePage goToContactHomePage();
}
