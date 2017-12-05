package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;

/**
 * Created by Administrator on 11/17/2017.
 */
public class LoginPage extends BasePageObject {

  @FindBy(id = "username")
  private WebElement userName;

  @FindBy(id = "password")
  private WebElement password;

  @FindBy(id = "Login")
  private WebElement loginBtn;

  /**
   * Constructor
   */
  public LoginPage() {
    super();
  }

  public HomeAbstract login(String usernameInput, String passwordInput) {
    userName.sendKeys(usernameInput);
    password.sendKeys(passwordInput);
    loginBtn.click();


    //final String skin = "lighting";  //que vista usara!
    final String skin = "classic";  //que vista usara!
    return PageFactory.getInstance().getHome(skin);
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {
  }
}
