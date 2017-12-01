package salesforce.salesforceapp.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import salesforce.salesforceapp.config.*;

/**
 * Created by AT-05 team on 11/30/2017.
 */
public class LoginPage extends BasePage {
  @FindBy(id = "username")
  private WebElement userName;

  @FindBy(id = "password")
  private WebElement password;

  @FindBy(id = "Login")
  private WebElement loginButton;

  private final HomePageFactory homePageFactory = new HomePageFactory();

  /**
   * <p>This method logs userName into the application.</p>
   *
   * @param usernameInput is the userName name value given.
   * @param passwordInput is the userName password value given.
   * @return a HomePage object type.
   */
  public HomePage login(String usernameInput, String passwordInput) {
    System.out.println("************************username");
    userName.sendKeys(usernameInput);
    password.sendKeys(passwordInput);
    loginButton.click();
    final String skin = SalesForceAppEnvsConfig.getInstance().getId();
    return homePageFactory.getHomePage(skin);
  }

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
