package salesforce.core.selenium;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.core.selenium.webdrivers.DriverFactory;

public class WebDriverManager {

  private Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
  private WebDriver webDriver;
  private WebDriverWait webDriverWait;

  private static WebDriverManager instance = null;

  private static final String FIREFOX = "firefox";
  private static final String CHROME = "chrome";


  protected WebDriverManager() {
  }

  public static WebDriverManager getInstance() {
    if (instance == null || instance.webDriver == null) {
      instance = new WebDriverManager();
    }
    return instance;
  }

  public void initialize() {
    log.info("WebDriverManager initialize: Initializing the web driver");
    this.webDriver = DriverFactory.getDriver();
    this.webDriver.manage().window().maximize();
    this.webDriver.manage().timeouts().implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
    webDriverWait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(), webDriverConfig.getWaitSleepTime());

  }

  /**
   * Gets the WebDriver
   */
  public WebDriver getWebDriver() {
    return webDriver;
  }

  /**
   * Gets the WebDriver Wait
   */
  public WebDriverWait getWait() {
    return webDriverWait;
  }

  /**
   * Closes all the browser instances
   */
  public void quitDriver() {
    try {
      log.info("Quit driver");
      webDriver.quit();
    } catch (Exception e) {
      log.error("Unable to quit the WebDriver", e);
    }
    webDriver = null;
  }
}
