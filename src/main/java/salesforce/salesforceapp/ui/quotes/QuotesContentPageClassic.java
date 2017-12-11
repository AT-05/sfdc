package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageClassic extends QuotesContentPage {
  @FindBy(id = "Name_ileinner")
  @CacheLookup
  private WebElement quoteNameClassic;

  @FindBy(id = "ExpirationDate_ileinner")
  @CacheLookup
  private WebElement quoteExpirationDateClassic;

  @FindBy(id = "Status_ileinner")
  @CacheLookup
  private WebElement quoteStatusClassic;

  @FindBy(id = "Description_ilecell")
  @CacheLookup
  private WebElement quoteDescriptionClassic;

  @FindBy(xpath = "//td[@id='topButtonRow']/input[@title='Edit']")
  @CacheLookup
  private WebElement editQuoteLink;

  @FindBy(xpath = "//td[@id='topButtonRow']/input[@title='Delete']")
  @CacheLookup
  private WebElement deleteQuoteLink;

  public QuotesContentPageClassic() {
    super.quoteName = quoteNameClassic;
    super.quoteExpirationDate = quoteExpirationDateClassic;
    super.quoteStatus = quoteStatusClassic;
    super.quoteDescription = quoteDescriptionClassic;
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
    driverTools.clickElement(editQuoteLink);
    return new QuotesEditionFormClassic();
  }

  /**
   * <p>This method checks if after editing a quote,
   * a successful edited quote message is displayed.</p>
   *
   * @param quoteName is the quote name given.
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteEditedMessageDisplayed(String quoteName) {
    return true;
  }

  /**
   * <p>This method opens the quote details frame.</p>
   */
  @Override
  public void openQuoteDetails() {
    //Is not necessary to open quote details
  }

  /**
   * <p>This method performs deletion of Quote.</p>
   */
  @Override
  public void deleteQuote() {
    driverTools.clickElement(deleteQuoteLink);
    driver.switchTo().alert().accept();
  }

  /**
   * <p>This method checks if after deleting a quote,
   * a successful deleted quote message is displayed.</p>
   *
   * @param quoteName is the quote name given.
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteDeletedMessageDisplayed(String quoteName) {
    return true; //There is no message displayed for this skin.
  }
}
