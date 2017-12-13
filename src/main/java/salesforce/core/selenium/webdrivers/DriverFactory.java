package salesforce.core.selenium.webdrivers;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import salesforce.core.selenium.WebDriverConfig;

public final class DriverFactory {

  private static final String FIREFOX = "firefox";
  private static final String CHROME = "chrome";

  private DriverFactory() {
  }

  /**
   * <p>This method return the instance of the web driver that is using.</p>
   *
   * @return WebDriver.
   */
  public static WebDriver getDriver() {
    Map<String, IWebDriver> strategyBrowser = new HashMap<>();
    strategyBrowser.put(FIREFOX, new FirefoxWebDriver());
    strategyBrowser.put(CHROME, new ChromeWebDriver());
    return strategyBrowser.get(WebDriverConfig.getInstance().getBrowser().toLowerCase()).initDriver();
  }
}
