package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.core.selenium.WebDriverManager;
import salesforce.core.selenium.WebDriverTools;

public abstract class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected WebDriverTools driverTools;

  /**
   * Initializes the web driver, wait and web elements
   */
  public BasePage() {
    this.driver = WebDriverManager.getInstance().getWebDriver();
    this.wait = WebDriverManager.getInstance().getWait();
    this.driverTools = new WebDriverTools();
    PageFactory.initElements(driver, this);
    waitUntilPageObjectIsLoaded();
  }

  public abstract void waitUntilPageObjectIsLoaded();
}
