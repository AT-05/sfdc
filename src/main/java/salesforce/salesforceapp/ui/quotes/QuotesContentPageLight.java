package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageLight extends QuotesContentPage {
  //Links
  @FindBy(xpath = "//div[contains(@title, 'Edit')]")
  private WebElement editQuoteLink;

  @FindBy(xpath = "//div[contains(@title, 'Delete')]")
  private WebElement deleteQuoteLink;

  @FindBy(xpath = "//button[@title='Delete']")
  private WebElement deleteConfirmationLink;

  private WebElement quoteEditedMessage;

  @FindBy(xpath = "//div[@class='container']//div[1]//article/div[1]/div//li[1]//div")
  private WebElement addLineItemLink;

  private WebElement quoteLineItemAddedMessage;

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
    return new QuoteEditionFormLight();
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
    boolean result = false;
    quoteEditedMessage = driver.findElement(By.xpath("//span[contains(@class, 'toastMessage')]"));
    if (driverTools.isElementDisplayed(quoteEditedMessage)
        && quoteEditedMessage.getText().contains("was saved")
        && quoteEditedMessage.getText().contains(quoteName)) {
      result = true;
    }
    driverTools.waitUntilMessageDisappear(quoteEditedMessage);
    return result;
  }

  /**
   * <p>This method opens the quote details frame.</p>
   */
  @Override
  public void openQuoteDetails() {
    By quoteDetailsLink = By.xpath("//div[@id='brandBand_1']//span[text()='Details']");
    driverTools.clickElement(quoteDetailsLink);
  }

  /**
   * <p>This method gets locators for verifying quote information.</p>
   */
  @Override
  protected void getLocators() {
    super.quoteNameLabel = By.xpath(String.format("//span[text()='Quote Name']/ancestor::div[contains(@class, 'slds-form-element')]//span[text()='%s']", super.quoteInfo.getName()));
    super.quoteExpirationDateLabel = By.xpath(String.format("//span[text()='Expiration Date']/ancestor::div[contains(@class, 'slds-form-element')]//span[text()='%s']", super.quoteInfo.getExpirationDate()));
    super.quoteStatusLabel = By.xpath(String.format("//span[text()='Status']/ancestor::div[contains(@class, 'slds-form-element')]//span[text()='%s']", super.quoteInfo.getStatus()));
    super.quoteDescriptionLabel = By.xpath(String.format("//span[text()='Description']/ancestor::div[contains(@class, 'slds-form-element')]//span[text()='%s']", super.quoteInfo.getDescription()));
    super.quoteTaxLabel = By.xpath(String.format("//span[text()='Tax']/ancestor::div[contains(@class, 'slds-form-element')]//span[contains(text(), '%s')]", super.quoteInfo.getTax()));
    super.quoteShippingAndHandlingLabel = By.xpath(String.format("//span[text()='Shipping and Handling']/ancestor::div[contains(@class, 'slds-form-element')]//span[contains(text(), '%s')]", super.quoteInfo.getShippingAndHandling()));
    super.quoteSubTotalLabel = By.xpath(String.format("//span[text()='Subtotal']/ancestor::div[contains(@class, 'slds-form-element')]//span[contains(text(), '%s')]", super.quoteInfo.getSubTotal()));
    super.quoteDiscountLabel = By.xpath(String.format("//span[text()='Discount']/ancestor::div[contains(@class, 'slds-form-element')]//span[contains(text(), '%s')]", super.quoteInfo.getDiscount()));
    super.quoteTotalPriceLabel = By.xpath(String.format("//span[text()='Total Price']/ancestor::div[contains(@class, 'slds-form-element')]//span[contains(text(), '%s')]", super.quoteInfo.getTotalPrice()));
    super.quoteGrandTotalLabel = By.xpath(String.format("//span[text()='Grand Total']/ancestor::div[contains(@class, 'slds-form-element')]//span[contains(text(), '%s')]", super.quoteInfo.getGrandTotal()));
  }

  /**
   * <p>This method performs deletion of Quote.</p>
   */
  @Override
  public void deleteQuote() {
    driverTools.clickElement(deleteQuoteLink);
    driverTools.clickElement(deleteConfirmationLink);
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
    boolean result = false;
    quoteEditedMessage = driver.findElement(By.xpath("//span[contains(@class, 'toastMessage')]"));
    if (driverTools.isElementDisplayed(quoteEditedMessage)
        && quoteEditedMessage.getText().contains("was deleted")
        && quoteEditedMessage.getText().contains(quoteName)) {
      result = true;
    }
    return result;
  }

  /**
   * <p>This method sends to Price Book Selection Page.</p>
   *
   * @return a QuotePriceBookSelectionPage object type.
   */
  @Override
  public QuotePriceBookSelectionPage goToAddLineItem() {
    driverTools.clickElement(addLineItemLink);
    return new QuotePriceBookSelectionPageLight();
  }

  /**
   * <p>This method checks if after adding quote line item(s),
   * a successful saved changes message is displayed.</p>
   *
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteLineItemCreatedMessageDisplayed() {
    boolean result = false;
    quoteLineItemAddedMessage = driver.findElement(By.xpath("//span[contains(@class, 'toastMessage')]"));
    if (driverTools.isElementDisplayed(quoteLineItemAddedMessage)
        && quoteLineItemAddedMessage.getText().contains("Your changes are saved")) {
      result = true;
    }
    return result;
  }
}
