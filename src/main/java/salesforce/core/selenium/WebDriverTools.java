package salesforce.core.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebDriverTools {

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
        element.click();
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
    selector.selectByValue(value);
  }
}
