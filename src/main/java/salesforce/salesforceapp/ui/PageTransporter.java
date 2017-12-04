package salesforce.salesforceapp.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.core.selenium.WebDriverManager;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;

public class PageTransporter {

  private Logger log = Logger.getLogger(getClass());
  private String baseURL = SalesForceAppEnvsConfig.getInstance().getUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

  private static PageTransporter instance;

  /**
   * Constructor.
   */
  protected PageTransporter() {
    initialize();
  }

  /**
   * Return the instance or create a instance.
   *
   * @return instance.  
   */
  public static PageTransporter getInstance() {
    if (instance == null) {
      instance = new PageTransporter();
    }
    return instance;
  }

  /**
   * Display a log info.
   */
  private void initialize() {
    log.info("Initialize the page transporter");
  }

  /**
   * Go to url that pass like a parameter.
   *
   * @param url as a string.
   */
  private void goToURL(String url) {
    webDriver.navigate().to(url);
  }

  /**
   * Get the current url.
   *
   * @return as a string.
   */
  public String getCurrentURL() {
    return webDriver.getCurrentUrl();
  }

  /**
   * Check if the current url is in the base url.
   *
   * @return boolean.
   */
  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  /**
   * This method navigate to principal page.
   *
   * @return LoginPage.
   */
  public LoginPage navigateToPrincipalPage() {
    goToURL(baseURL);
    return new LoginPage();
  }
}
