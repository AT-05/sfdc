package salesforce.salesforceapp.ui;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.core.selenium.WebDriverManager;
import salesforce.salesforceapp.SalesforceEnums.Skin;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.components.TopMenu;

public class PageTransporter {

  private Logger log = Logger.getLogger(getClass());
  private String baseURL = SalesForceAppEnvsConfig.getInstance().getUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

  private static PageTransporter instance;

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
    return (webDriver.getCurrentUrl().contains("Login"));
  }

  public LoginPage navigateToLoginPage() {
    System.out.println("URL " + baseURL);
    goToURL(baseURL);
    return new LoginPage();
  }

  public Skin getCurrentSkin() {
    System.out.println("*********** contains: " + Skin.LIGHT.getSkinName());
    if (getCurrentURL().contains(Skin.LIGHT.getSkinName())) {
      System.out.println("*********** current url: " + getCurrentURL());
      return Skin.LIGHT;
    }
    return Skin.CLASSIC;
  }

  public void switchSkin() {
    TopMenu topMenu = PageFactory.getTopMenu();
    System.out.println("*********** get current skin: " + getCurrentSkin());
    topMenu.waitUntilPageObjectIsLoaded();
    if (!getCurrentSkin().equals(SalesForceAppEnvsConfig.getInstance().getSkin())) {
      System.out.println("************** switching skin to: " + SalesForceAppEnvsConfig.getInstance().getSkin());
      topMenu.switchSkin();
    }
  }
}
