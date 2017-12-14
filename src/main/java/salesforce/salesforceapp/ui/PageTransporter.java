package salesforce.salesforceapp.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.core.selenium.WebDriverManager;
import salesforce.salesforceapp.SalesforceEnums.Skin;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.components.*;

import java.net.MalformedURLException;
import java.net.URL;

public class PageTransporter {

  private static PageTransporter instance;
  private Logger log = Logger.getLogger(getClass());
  private String baseURL = SalesForceAppEnvsConfig.getInstance().getUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

  protected PageTransporter() {
    initialize();
  }

  public static PageTransporter getInstance() {
    if (instance == null) {
      instance = new PageTransporter();
    }
    return instance;
  }

  private void initialize() {
    log.info("Initialize the page transporter");
  }

  private void goToURL(String url) {
    try {
      webDriver.navigate().to(new URL(url));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public String getCurrentURL() {
    return webDriver.getCurrentUrl();
  }
  
  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  public Boolean isOnLogin() {
    return (webDriver.getCurrentUrl().contains("login"));
  }

  public LoginPage navigateToLoginPage() {
    goToURL(baseURL);
    return new LoginPage();
  }

  /**
   * <p>This method gets current web page skin.</p>
   *
   * @return the current sking based on current url.
   */
  public Skin getCurrentSkin() {
    if (getCurrentURL().contains(Skin.LIGHT.getSkinName())) {
      return Skin.LIGHT;
    }
    return Skin.CLASSIC;
  }

  /**
   * <p>This method performs switching of web page skin.</p>
   */
  public void switchSkin() {
    if (!getCurrentSkin().equals(SalesForceAppEnvsConfig.getInstance().getSkin())) {
      TopMenu topMenu = PageFactory.getTopMenu(getCurrentSkin());
      topMenu.switchSkin();
    }
  }
}
