package salesforce.salesforceapp.ui.quotes;

import com.android.dx.rop.code.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.entities.quotes.Quote;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageLight extends QuotesContentPage {
  @FindBy(xpath = "//a[contains(@title, 'Edit')]")
  @CacheLookup
  private WebElement editLink;

  @FindBy(xpath = "//a[contains(@title, 'Details')]")
  @CacheLookup
  private WebElement quoteDetailsLink;

  public QuotesContentPageLight() {
    /*super.quoteName = driver.findElements(By.xpath("//span/span[contains(@class, 'uiOutputText')]"));
    super.quoteExpirationDate = driver.findElement(By.xpath("//span/span"));
    super.quoteStatus = driver.findElement(By.xpath("//h1"));
    super.quoteDescription = driver.findElement(By.xpath("//h1"));*/
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method sends to Quote Edition Form.</p>
   *
   * @return a QuoteEditionForm object type.
   */
  @Override
  public QuoteEditionForm goToEditQuote() {
    WebElement message = driver.findElement(By.xpath("//button[contains(@class, 'slds-button toastClose')]"));
    message.click();
    System.out.println("***********clicking edit button");
    WebElement other = driver.findElement(By.xpath("//a[contains(@title, 'Show 3 more actions')]"));
    other.click();
    editLink.click();
    return new QuotesEditionFormLight();
  }

  /**
   * <p>This method checks if after editing a quote,
   * a successful edited quote message is displayed.</p>
   *
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteEditedMessageDisplayed() {
    boolean result = false;
    //get message
    return result;
  }

  /**
   * <p>This method opens the quote details frame.</p>
   */
  @Override
  public void openQuoteDetails() {
    System.out.println("****clicking details");
    WebElement message = driver.findElement(By.xpath("//button[contains(@class, 'slds-button toastClose')]"));
    message.click();
    WebElement other = driver.findElement(By.xpath(".//*[@id='brandBand_1']/div/div/div[3]/div/div/div[3]/div[1]/div/div"));
    other.click();
    quoteDetailsLink.click();
    /*if (driverTools.isElementDisplayed(quoteDetailsLink)) {
      System.out.println("*****element is visible");
      driverTools.clickElement(quoteDetailsLink);
    }*/
  }

  /**
   * <p>This method checks if the quote's information
   * was updated correctly.</p>
   *
   * @param quote is an entity object type.
   * @return whether the quote's information was updated correctly or not.
   */
  @Override
  public boolean isUpdated(Quote quote) {
    //Check quote updated
    return false;
  }
}
