package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuoteEditionFormLight extends QuoteEditionForm {
  @FindBy(css = ".select")
  @CacheLookup
  private WebElement quoteStatusLinkLight;
  private WebElement statusBtnLight;

  @FindBy(css = ".modal-footer button[title='Save']")
  @CacheLookup
  private WebElement saveBtnLight;

  private WebElement quoteCreatedMessage;

  /**
   * <p>This constructor initializes selectors.</p>
   */
  public QuoteEditionFormLight() {
    super.quoteNameInput = driver.findElement(By.xpath("//input[contains(@aria-required, 'true')]"));
    super.quoteExpirationDateInput = driver.findElement(By.xpath("//div[contains(@class, 'uiInput--datetime')]//input[1]"));
    super.quoteDescriptionInput = driver.findElement(By.xpath("//textarea[contains(@class, 'textarea')]"));
    super.saveBtn = saveBtnLight;
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
    statusBtnLight = driver.findElement(By.xpath("//li[@class='uiMenuItem uiRadioMenuItem']/a[@title='" + super.status + "']"));
    driverTools.clickElement(statusBtnLight);
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
    quoteCreatedMessage = driver.findElement(By.xpath("//span[contains(@class, 'toastMessage')]"));
    if (driverTools.isElementDisplayed(quoteCreatedMessage)
      && quoteCreatedMessage.getText().contains("was created")
      && quoteCreatedMessage.getText().contains(quoteName)) {
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
    WebElement element = driver.findElement(By.xpath("//a[@title='" + quoteName + "']"));
    driverTools.clickElement(element);
    return new QuotesContentPageLight();
  }
}
