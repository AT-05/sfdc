package salesforce.salesforceapp.ui;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import salesforce.core.selenium.*;
import salesforce.salesforceapp.config.*;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public class PageTransporter {
  private Logger log = Logger.getLogger(getClass());
  private String baseURL = SalesForceAppEnvsConfig.getInstance().getUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

  private static PageTransporter instance;

  /**
   * <p>This constructor shows transporter initialization.</p>
   */
  protected PageTransporter() {
    initialize();
  }

  /**
   * <p>This method returns the instance of the class.</p>
   *
   * @return a unique instance of this class.
   */
  public static PageTransporter getInstance() {
    if (instance == null) {
      instance = new PageTransporter();
    }
    return instance;
  }

  /**
   * <p>This constructor shows log of transporter initialization.</p>
   */
  private void initialize() {
    log.info("Initialize the page transporter");
  }

  /**
   * <p>This method sends the web driver to url.</p>
   *
   * @param url is the target url.
   */
  private void goToURL(String url) {
    System.out.println(url);
    webDriver.navigate().to(url);
  }

  /**
   * <p>This method returns the web driver current url.</p>
   *
   * @return is the url direction.
   */
  public String getCurrentURL() {
    return webDriver.getCurrentUrl();
  }

  /**
   * <p>This method returns if the web driver is on a certain url.</p>
   *
   * @return is the specific url.
   */
  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  /**
   * <p>This method sends to Main Page.</p>
   *
   * @return a MainPage object type.
   */
  public LoginPage navigateToMainPage() {
    goToURL(baseURL);
    return new LoginPage();
  }
}
