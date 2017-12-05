package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.home.HomePage;

public class LoginPage extends BasePage {

  @FindBy(id = "username")
  private WebElement userName;

  @FindBy(id = "password")
  private WebElement password;

  @FindBy(id = "Login")
  private WebElement loginButton;

  //Message Alert
  @FindBy(id = "app_alert")
  protected WebElement alert;

  @FindBy(xpath = "//div[@id='app_alert']/div[@class='message']")
  WebElement alertMessage;

  @FindBy(id = "//div[@id='app_alert']")
  WebElement alertOkBtn;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  private void setUsername(String username) {
    this.userName.clear();
    this.userName.sendKeys(username);
  }

  private void setPassword(String password) {
    this.password.clear();
    this.password.sendKeys(password);
  }

  private HomePage clickLoginButtton() {
    loginButton.click();
    return PageFactory.getHomePage();
  }


  public HomePage login(String username, String password) {
    setUsername(username);
    setPassword(password);
    loginButton.click();
    PageTransporter.getInstance().switchSkin();
    return PageFactory.getHomePage();
//    return clickLoginButtton();
  }

//    private void handleFrames() {
//        //Sample to switch frame
//        String parentWindowHandle = driver.getWindowHandle();
//        try {
//            //Get Content Frame location
//            WebElement contentFrame = driver.findElement(By.id("frameX"));
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(contentFrame));
////            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='downloadcartframe']")));
//
//            WebElement webElement = driver.findElement(By.id("elementInsideFrame"));
//            //Todo something if needed in the framne
//
//        } finally {
//            driver.switchTo().window(parentWindowHandle);
//            //Todo something if needed in the main window
//        }
//    }
//
//    private void handleAlerts() {
//
//        //Other sample
//
//        //Delete code
//
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().dismiss();
//        driver.switchTo().alert().accept();
//        driver.switchTo().alert().getText();
//        driver.switchTo().alert().sendKeys("Text");
//
//        //Sample to handle Alerts
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        wait.until(ExpectedConditions.visibilityOf(alertMessage));
//        alertMessage.getText();
//
//        wait.until(ExpectedConditions.elementToBeClickable(alertOkBtn));
//        alertOkBtn.click();
//
//        if (alert.isDisplayed()) {
//            alertOkBtn.click();
//        }
//    }
}
