package salesforce.salesforceapp.ui;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.core.selenium.*;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public abstract class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  /**
   * <p>This constructor initializes driver and wait and web elements.</p>
   */
  public BasePage() {
    driver = WebDriverManager.getInstance().getWebDriver();
    wait = WebDriverManager.getInstance().getWait();
    PageFactory.initElements(driver, this);
  }

  /**
   * <p>This pages returns the driver instance.</p>
   *
   * @return the instance of WebDriver.
   */
  public WebDriver getDriver() {
    return driver;
  }

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  public abstract void waitUntilPageObjectIsLoaded() throws WebDriverException;

  /**
   * <p>This method performs selection of element of a list.</p>
   *
   * @param webElements is a lis of WebElement elements.
   * @param keyWord is the value to compare element attribute with.
   */
  protected void selectElementInList(List<WebElement> webElements, String keyWord) {
    for (WebElement element : webElements) {
      String value = element.getAttribute("value");
      if (value.contains(keyWord)) {
        element.click();
        break;
      }
    }
  }

  /**
   * <p>This method performs selection of element of a list.</p>
   *
   * @param webElements is a lis of WebElement elements.
   * @param index is the integer value to compare element attribute with.
   */
  protected void selectElementInList(List<WebElement> webElements, int index) {
    WebElement element = webElements.get(index);
    element.click();
  }
}
