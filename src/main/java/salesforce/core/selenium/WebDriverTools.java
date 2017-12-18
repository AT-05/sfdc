package salesforce.core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverTools {

  private final String JS_SCRIPT = "document.querySelector(\"a[title='%s']\").click();";
  private WebDriver driver;
  private WebDriverWait wait;

  public WebDriverTools() {
    this.driver = WebDriverManager.getInstance().getWebDriver();
    this.wait = WebDriverManager.getInstance().getWait();
  }

  /**
   * Waits and clear the WebElement
   *
   * @param webElement WebElement to wait and clear
   */
  public void clearTextField(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
    webElement.clear();
  }

  /**
   * Sets an Input Field.
   *
   * @param webElement Input WebElement
   * @param text       Text to fill
   */
  public void setInputField(WebElement webElement, String text) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
    clearTextField(webElement);
    webElement.sendKeys(text);
  }

  /**
   * Waits and click on the webElement.
   *
   * @param webElement WebElement to wait and click
   */
  public void clickElement(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
    webElement.click();
  }

  /**
   * Waits and click on the webElement.
   *
   * @param by By to wait and click
   */
  public void clickElement(By by) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    driver.findElement(by).click();
  }

  /**
   * Wits and gets the text of a WebElement
   *
   * @param webElement WebElement to wait and get the text
   * @return Text of the WebElement
   */
  public String getTextElement(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
    return webElement.getText();
  }

  /**
   * Verifies if the WebElement is displayed
   *
   * @param webElement WebElement
   * @return True if the WebElement is displayed
   */
  public boolean isElementDisplayed(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
    return webElement.isDisplayed();
  }

  /**
   * Verifies if the WebElement is selected
   *
   * @param element WebElement
   * @return True if the WebElement is selected
   */
  public boolean isElementSelected(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    return element.isSelected();
  }

  /**
   * Selects the checkBox
   *
   * @param element WebElement
   */
  public void selectCheckBox(WebElement element) {
    if (!isElementSelected(element)) {
      clickElement(element);
    }
  }

  /**
   * Clears the checkBox
   *
   * @param element WebElement
   */
  public void clearCheckBox(WebElement element) {
    if (isElementSelected(element)) {
      clickElement(element);
    }
  }

  /**
   * <p>This method performs selection of element of a list.</p>
   *
   * @param webElements is a lis of WebElement elements.
   * @param keyWord     is the value to compare element attribute with.
   */
  public void selectElementInList(List<WebElement> webElements, String keyWord) {
    for (WebElement element : webElements) {
      String value = element.getText();
      if (value.contains(keyWord)) {
        clickElement(element);
        break;
      }
    }
  }

  /**
   * <p>This method performs selection of value inside a dropdown list.</p>
   *
   * @param dropDown is the dropdown web element given.
   * @param value    is the value to select.
   */
  public void selectDropDownValue(WebElement dropDown, String value) {
    Select selector = new Select(dropDown);
    wait.until(ExpectedConditions.visibilityOf(dropDown));
    selector.selectByValue(value);
  }

  /**
   * <p>This method performs selection of text inside a dropdown list.</p>
   *
   * @param dropDown is the dropdown web element given.
   * @param text     is the text to select.
   */
  public void selectDropDownLinkText(WebElement dropDown, String text) {
    Select selector = new Select(dropDown);
    wait.until(ExpectedConditions.visibilityOf(dropDown));
    selector.selectByVisibleText(text);
  }

  /**
   * Wait until the item is no longer visible.
   *
   * @param element WebElement.
   */
  public void waitUntilMessageDisappear(WebElement element) {
    try {
      while (element.isDisplayed()) {
      }
    } catch (Exception e) {
    }
  }

  /**
   * Check when an element is displayed.
   *
   * @param by is the xpath.
   * @return as a boolean.
   */
  public boolean isElementDisplayed(By by) {
    WebElement webElement = driver.findElement(by);
    return isElementDisplayed(webElement);
  }

  /**
   * Check when an element is visible.
   *
   * @param by is the path.
   * @return as a boolean.
   */
  public boolean isElementVisibility(By by) {
    try {
      return isElementDisplayed(by);
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Wait until an element is available by xpath.
   *
   * @param by is the xpath.
   */
  public void waitUntilAvailable(By by) {
    WebElement webElement = driver.findElement(by);
    waitAvailable(webElement);
  }

  /**
   * Wait until an element is available by element.
   *
   * @param element is the element.
   */
  public void waitUntilAvailable(WebElement element) {
    waitAvailable(element);
  }

  /**
   * Wait until a element is visible and clickable.
   *
   * @param element is the element.
   */
  public void waitAvailable(WebElement element) {
    boolean flag = true;
    while (flag) {
      try {
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println("==== Elem is visible");
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("==== Elem is clickable");
        flag = false;
      } catch (Exception ex) {
      }
    }
  }

  /**
   * This method perform a click in a non visible element in the UI using class locator.
   *
   * @param webElement the WebElement non visible in the UI.
   */
  public void jsClickClassButton(WebElement webElement) {
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", webElement);
  }
}
