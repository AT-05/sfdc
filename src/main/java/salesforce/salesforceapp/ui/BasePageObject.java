package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.core.selenium.WebDriverManager;

/**
 * Created by Administrator on 11/15/2017.
 */
public abstract class BasePageObject {

  protected WebDriver driver;
  protected WebDriverWait wait;

  /**
   * Constructor.
   */
  public BasePageObject() {
    driver = WebDriverManager.getInstance().getWebDriver();
    wait = WebDriverManager.getInstance().getWait();
    PageFactory.initElements(driver, this);
  }

  public abstract void waitUntilPageObjectIsLoaded() throws WebDriverException;
}
