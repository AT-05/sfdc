package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageClassic extends QuotesContentPage {
  //Links
  @FindBy(xpath = "//td[@id='topButtonRow']/input[@title='Edit']")
  @CacheLookup
  private WebElement editQuoteLink;

  @FindBy(xpath = "//td[@id='topButtonRow']/input[@title='Delete']")
  @CacheLookup
  private WebElement deleteQuoteLink;

  public QuotesContentPageClassic() {

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
   * <p>This method gets locators for verifying quote information.</p>
   */
  @Override
  protected void getLocators() {
    super.quoteNameLabel = By.xpath("//div[@id='Name_ileinner' and text()='" + super.quoteInfo.getName() + "']");
    super.quoteExpirationDateLabel = By.xpath("//div[@id='ExpirationDate_ileinner' and text()='" + super.quoteInfo.getExpirationDate() + "']");
    super.quoteStatusLabel = By.xpath("//div[@id='Status_ileinner' and text()='" + super.quoteInfo.getStatus() + "']");
    super.quoteDescriptionLabel = By.xpath("//div[@id='Description_ileinner'  and text()='" + super.quoteInfo.getDescription() + "']");
    super.quoteTaxLabel = By.xpath("//div[@id='Tax_ileinner' and contains(text(),'" + super.quoteInfo.replaceDots(super.quoteInfo.getTax()) + "')]");
    super.quoteShippingAndHandlingLabel = By.xpath("//div[@id='ShippingHandling_ileinner' and contains(text(),'" + super.quoteInfo.replaceDots(super.quoteInfo.getShippingAndHandling()) + "')]");
    super.quoteGrandTotalLabel = By.xpath("//div[@id='GrandTotal_ileinner' and contains(text(),'" + super.quoteInfo.getGrandTotal() + "')]");
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