package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageLight extends QuotesContentPage {
  //Links
  @FindBy(xpath = "//a[contains(@title, 'Show 3 more actions')]")
  @CacheLookup
  private WebElement showMoreActionsLink;

  @FindBy(xpath = "//div/ul/li[2]/a[contains(@title, 'Edit')]")
  @CacheLookup
  private WebElement editLink;

  @FindBy(xpath = "//div/ul/li[3]/a[@title='Delete']")
  @CacheLookup
  private WebElement deleteQuoteLink;

  @FindBy(xpath = "//button[@title='Delete']")
  @CacheLookup
  private WebElement deleteConfirmationLinkLight;

  @FindBy(xpath = "//div[5]/div/div/div[3]/div[1]/div/div/div/ul/li[@class='tabs__item uiTabItem']/a[@title='Details']/span[2]")
  @CacheLookup
  private WebElement quoteDetailsLink;
  private WebElement quoteEditedMessage;

  @FindBy(xpath = "")
  @CacheLookup
  private WebElement addLineItemLink;

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
    showMoreActionsLink.click();
    editLink.click();
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
    return result;
  }

  /**
   * <p>This method opens the quote details frame.</p>
   */
  @Override
  public void openQuoteDetails() {
    driverTools.clickElement(quoteDetailsLink);
  }

  /**
   * <p>This method gets locators for verifying quote information.</p>
   */
  @Override
  protected void getLocators() {
    super.quoteNameLabel = By.xpath("//div[@class='center oneCenterStage forceContentManager']/div[5]//span/span[text()='" + super.quoteInfo.getName() + "']");
    super.quoteExpirationDateLabel = By.xpath("//div[@class='center oneCenterStage forceContentManager']/div[5]//span/span[text()='" + super.quoteInfo.getExpirationDate() + "']");
    super.quoteStatusLabel = By.xpath("//div[@class='slds-template__container']//div[5]//div[3]/div[2]//div[2]//span[text()='" + super.quoteInfo.getStatus() + "']");
    super.quoteDescriptionLabel = By.xpath("//div[@class='center oneCenterStage forceContentManager']/div[5]//span[text()='" + super.quoteInfo.getDescription() + "']");
    super.quoteTaxLabel = By.xpath("//div[@class='center oneCenterStage forceContentManager']/div[5]//div[@class='full forcePageBlock forceRecordLayout']//div" +
      "[@class='slds-form']/div[1]//span[contains(text(), '" + super.quoteInfo.getTax() + "')]");
    super.quoteShippingAndHandlingLabel = By.xpath("//div[@class='center oneCenterStage forceContentManager']/div[5]//div[@class='full forcePageBlock forceRecordLayout']//div'" +
      "[@class='slds-form']/div[2]//span[contains(text(), '" + super.quoteInfo.getShippingAndHandling() + "')]");
    super.quoteGrandTotalLabel = By.xpath("//div[@class='center oneCenterStage forceContentManager']/div[5]//div[@class='full forcePageBlock forceRecordLayout']//div" +
      "[@class='slds-form']/div[3]//span[contains(text(), '" + super.quoteInfo.getGrandTotal() + "')]");
  }

  /**
   * <p>This method performs deletion of Quote.</p>
   */
  @Override
  public void deleteQuote() {
    driverTools.clickElement(showMoreActionsLink);
    driverTools.clickElement(deleteQuoteLink);
    driverTools.clickElement(deleteConfirmationLinkLight);
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
   * <p>This method sends to Quote Line Items View Page.</p>
   *
   * @return a QuoteLineItemsView object type.
   */
  @Override
  public QuoteLineItemsView goToQuoteLineItemsView() {
    //Todo Add
    return new QuoteLineItemsViewLight();
  }

  /**
   * <p>This method checks if after adding quote line item(s),
   * a successful saved changes message is displayed.</p>
   *
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteLineItemCreatedMessageDisplayed() {
    //Todo Add
    return false;
  }
}
