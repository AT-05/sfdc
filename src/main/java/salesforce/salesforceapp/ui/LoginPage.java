package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.home.HomePage;

public class LoginPage extends BasePage {

  @FindBy(id = "username")
  private WebElement userName;

  @FindBy(id = "password")
  private WebElement password;

  @FindBy(id = "Login")
  private WebElement loginButton;

  /**
   * <p>This method implements wait time for login url direction.</p>
   */
  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.urlContains("login"));
  }

  /**
   * <p>This method fills user name field value.</p>
   *
   * @param userNameInput is the user name given.
   */
  private void setUsername(String userNameInput) {
    driverTools.setInputField(userName, userNameInput);
  }

  /**
   * <p>This method fills user password field value.</p>
   *
   * @param passwordInput is the user password given.
   */
  private void setPassword(String passwordInput) {
    driverTools.setInputField(password, passwordInput);
  }

  /**
   * <p>This method performs login of user into the application.</p>
   *
   * @param username is the user name given.
   * @param password is the user password given.
   * @return a HomePage object type.
   */
  public HomePage login(String username, String password) {
    setUsername(username);
    setPassword(password);
    driverTools.clickElement(loginButton);
    //wait.until(ExpectedConditions.urlContains("home"));
    PageTransporter.getInstance().switchSkin();
    HomePage homePage = PageFactory.getHomePage();
    homePage = homePage.topMenu.goToHomePage();
    return homePage;
  }
}
