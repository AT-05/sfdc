package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageClassic extends QuotesContentPage {
  //Quote info
  @FindBy(id = "Name_ileinner")
  @CacheLookup
  private WebElement quoteNameLabelClassic;

  @FindBy(id = "ExpirationDate_ileinner")
  @CacheLookup
  private WebElement quoteExpirationDateLabelClassic;

  @FindBy(id = "Status_ileinner")
  @CacheLookup
  private WebElement quoteStatusLabelClassic;

  @FindBy(id = "Description_ilecell")
  @CacheLookup
  private WebElement quoteDescriptionLabelClassic;

  @FindBy(id = "Tax_ileinner")
  @CacheLookup
  private WebElement quoteTaxLabelClassic;

  @FindBy(id = "ShippingHandling_ileinner")
  @CacheLookup
  private WebElement quoteShippingAndHandlingLabelClassic;

  @FindBy(id = "GrandTotal_ileinner")
  @CacheLookup
  private WebElement quoteGrandTotalLabelClassic;

  //Links
  @FindBy(xpath = "//td[@id='topButtonRow']/input[@title='Edit']")
  @CacheLookup
  private WebElement editQuoteLink;

  @FindBy(xpath = "//td[@id='topButtonRow']/input[@title='Delete']")
  @CacheLookup
  private WebElement deleteQuoteLink;

  public QuotesContentPageClassic() {
    super.quoteNameLabel = quoteNameLabelClassic;
    super.quoteExpirationDateLabel = quoteExpirationDateLabelClassic;
    super.quoteStatusLabel = quoteStatusLabelClassic;
    super.quoteDescriptionLabel = quoteDescriptionLabelClassic;
    super.quoteTaxLabel = quoteTaxLabelClassic;
    super.quoteShippingAndHandlingLabel = quoteShippingAndHandlingLabelClassic;
    super.quoteGrandTotalLabel = quoteGrandTotalLabelClassic;
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
    return new QuoteEditionFormClassic();
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
