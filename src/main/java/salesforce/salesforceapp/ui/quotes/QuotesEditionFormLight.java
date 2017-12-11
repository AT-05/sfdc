package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesEditionFormLight extends QuoteEditionForm {
  @FindBy(css = ".select")
  @CacheLookup
  private WebElement quoteStatusLinkLight;
  private WebElement statusLight;

  @FindBy(css = ".modal-footer button[title='Save']")
  @CacheLookup
  private WebElement buttonSaveLight;

  private WebElement quoteCreatedMessage;

  /**
   * <p>This constructor initializes selectors.</p>
   */
  public QuotesEditionFormLight() {
    super.quoteName = driver.findElement(By.xpath("//input[contains(@aria-required, 'true')]"));
    super.quoteExpirationDate = driver.findElement(By.xpath("//div[contains(@class, 'uiInput--datetime')]//input[1]"));
    super.quoteDescription = driver.findElement(By.xpath("//textarea[contains(@class, 'textarea')]"));
    super.buttonSave = buttonSaveLight;
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method sets quote status.</p>
   */
  @Override
  protected void setStatus() {
    driverTools.clickElement(quoteStatusLinkLight);
    statusLight = driver.findElement(By.xpath("//li[@class='uiMenuItem uiRadioMenuItem']/a[@title='" + super.statusInput + "']"));
    driverTools.clickElement(statusLight);
  }

  /**
   * <p>This method checks if after creating a quote,
   * a successful created quote message is displayed.</p>
   *
   * @param quoteName is the quote name input.
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteCreatedMessageDisplayed(String quoteName) {
    boolean result = false;
    quoteCreatedMessage = driver.findElement(By.xpath("//span[contains(@class, 'toastMessage')]//a[contains(@title, '" + quoteName + "')]"));
    if (driverTools.isElementDisplayed(quoteCreatedMessage)) {
      result = true;
    }
    return result;
  }

  /**
   * <p>This method opens a specific quote.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  @Override
  public QuotesContentPage openQuote(String quoteName) {
    WebElement element = driver.findElement(By.xpath("//a[contains(@title,'" + quoteName + "')]"));
    driverTools.clickElement(element);
    return new QuotesContentPageLight();
  }
}
