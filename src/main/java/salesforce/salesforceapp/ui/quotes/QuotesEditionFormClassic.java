package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesEditionFormClassic extends QuoteEditionForm {
  @FindBy(id = "Status")
  @CacheLookup
  private WebElement quoteStatusClassic;

  @FindBy(xpath = "//td[@id='topButtonRow']/input[@value=' Save ']")
  @CacheLookup
  private WebElement buttonSaveClassic;

  /**
   * <p>This constructor initializes selectors.</p>
   */
  public QuotesEditionFormClassic() {
    super.quoteName = driver.findElement(By.id("Name"));
    super.quoteExpirationDate = driver.findElement(By.id("ExpirationDate"));
    super.quoteDescription = driver.findElement(By.id("Description"));
    super.buttonSave = buttonSaveClassic;
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method sets quote status.</p>
   */
  @Override
  protected void setStatus() {
    driverTools.selectDropDownValue(quoteStatusClassic, super.statusInput);
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
    return true; //In this skin there is no message displayed.
  }

  /**
   * <p>This method opens a specific quote.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  @Override
  public QuotesContentPage openQuote(String quoteName) {
    return new QuotesContentPageClassic(); //In this skin it isn't necessary to open quote.
  }
}
