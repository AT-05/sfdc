package salesforce.salesforceapp;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import salesforce.core.selenium.WebDriverConfig;
import salesforce.core.selenium.WebDriverManager;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;


public class SalesForceAppAutomation {

  private Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig;
  private SalesForceAppEnvsConfig salesForceAppEnvsConfig;

  private static final String webDriverConfigFilename =
      System.getProperty("user.dir") + File.separator + "driverConfig.json";
  private static final String salesForceAppEnvsConfigFileName =
      System.getProperty("user.dir") + File.separator + "environments.json";

  private static SalesForceAppAutomation instance;

  private SalesForceAppAutomation() {
    PropertyConfigurator.configure("log.properties");
    webDriverConfig.getInstance().initialize(webDriverConfigFilename);
    salesForceAppEnvsConfig.getInstance().initialize(salesForceAppEnvsConfigFileName);
  }

  public static SalesForceAppAutomation getInstance() {
    if (instance == null) {
      instance = new SalesForceAppAutomation();
    }
    return instance;
  }

  public void startUp() throws Exception {
    WebDriverManager.getInstance().initialize(webDriverConfig);
  }

  public void shutDown() throws Exception {
    WebDriverManager.getInstance().quitDriver();
  }
}
