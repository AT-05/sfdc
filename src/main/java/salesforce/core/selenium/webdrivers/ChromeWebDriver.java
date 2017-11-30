package salesforce.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 11/13/2017.
 */
public class ChromeWebDriver implements IWebDriver {

  private static ChromeWebDriver instance = null;
  private WebDriver driver;
  private WebDriverWait wait;

  /**
   * Static method for instance a ChromeWebDriver.
   *
   * @return the instance.
   */
  public static ChromeWebDriver getInstance() {
    if (instance == null || instance.driver == null) {
      instance = new ChromeWebDriver();
    }
    return instance;
  }

  /**
   * Instance the driver for chrome using the plugin.
   *
   * @return the WebDriver.
   */
  @Override
  public WebDriver initDriver() {
    ChromeDriverManager.getInstance().setup();
    driver = new ChromeDriver();
    //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    //wait = new WebDriverWait(driver, 30, 500);
    return driver;
  }

  /**
   * Return the driver.
   *
   * @return WebDriver.
   */
  @Override
  public WebDriver getDriver() {
    return driver;
  }

  /**
   * Return the wait.
   *
   * @return WebDriverWait.
   */
  @Override
  public WebDriverWait getWait() {
    return wait;
  }
}
