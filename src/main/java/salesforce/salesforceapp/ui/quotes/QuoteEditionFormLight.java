package salesforce.salesforceapp.ui.quotes;

import java.util.concurrent.TimeUnit;
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
  private WebElement quoteStatusLink;
  private WebElement statusBtn;

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
    super.quoteTaxInput = driver.findElement(By.xpath("//div[1]/div[2]/div/div/div/input[@min='-99999999999999']"));
    super.quoteShippingAndHandlingInput = driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/input[@min='-99999999999999']"));
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
    driverTools.clickElement(quoteStatusLink);
    statusBtn = driver.findElement(By.xpath("//li[@class='uiMenuItem uiRadioMenuItem']/a[@title='" + super.status + "']"));
    driverTools.clickElement(statusBtn);
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
    driverTools.waitUntilMessageDisappear(quoteCreatedMessage);
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
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    WebElement element = driver.findElement(By.xpath("//a[@title='" + quoteName + "']"));
    driverTools.clickElement(element);
    return new QuotesContentPageLight();
  }
}
