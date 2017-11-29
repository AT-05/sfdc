package salesforce.core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 11/13/2017.
 */
public interface IWebDriver {

  WebDriver initDriver();

  WebDriver getDriver();

  WebDriverWait getWait();
}
