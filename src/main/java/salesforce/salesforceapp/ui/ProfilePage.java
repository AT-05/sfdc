package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.ui.components.TopMenu;

/**
 * Created by AT05 team on 12/11/2017.
 */
public abstract class ProfilePage extends BasePage {
  protected WebElement userEmail;
  protected TopMenu topMenu;

  /**
   * <p>Constructor of the class.</p>
   */
  public ProfilePage() {
    this.topMenu = PageFactory.getTopMenu();
    waitUntilPageObjectIsLoaded();
  }

  /**
   * <p>This method checks if user name appears after login.</p>
   *
   * @return whether the user name appears or not.
   */
  public boolean isUserNameDisplayed() {
    return driverTools.isElementDisplayed(userEmail);
  }
}
