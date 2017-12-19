package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.home.HomePage;

public class LoginPage extends BasePage {

  @FindBy(id = "username")
  private WebElement userNameInput;

  @FindBy(id = "password")
  private WebElement passwordInput;

  @FindBy(id = "Login")
  private WebElement loginBtn;

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
   * @param userName is the user name given.
   */
  private void setUsername(String userName) {
    driverTools.setInputField(userNameInput, userName);
  }

  /**
   * <p>This method fills user passwordInput field value.</p>
   *
   * @param password is the user passwordInput given.
   */
  private void setPassword(String password) {
    driverTools.setInputField(passwordInput, password);
  }

  /**
   * <p>This method performs login of user into the application.</p>
   *
   * @param username is the user name given.
   * @param password is the user passwordInput given.
   * @return a HomePage object type.
   */
  public HomePage login(String username, String password) {
    setUsername(username);
    setPassword(password);
    driverTools.clickElement(loginBtn);
    wait.until(ExpectedConditions.urlContains("home"));
    PageTransporter.getInstance().switchSkin();
    return PageFactory.getHomePage();
  }
}
