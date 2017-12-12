package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageLight extends QuotesContentPage {
  @FindBy(xpath = "//div[@class='test-id__section-content slds-section__content section__content slds-p-top--none']//div[2]/div[1]/div/div[2]/span/span")
  @CacheLookup
  private WebElement quoteNameLight;

  @FindBy(xpath = "//div[@class='test-id__section-content slds-section__content section__content slds-p-top--none']//div[1]/div[2]/div/div[2]/span/span")
  @CacheLookup
  private WebElement quoteExpirationDateLight;

  @FindBy(xpath = "//div[@class='test-id__section-content slds-section__content section__content slds-p-top--none']/div/div[3]/div[2]/div/div[2]/span/span")
  @CacheLookup
  private WebElement quoteStatusLabelLight;

  @FindBy(xpath = "//div[@class='test-id__section-content slds-section__content section__content slds-p-top--none']/div/div[4]/div[2]/div/div[2]/span/span")
  @CacheLookup
  private WebElement quoteDescriptionLabelLight;

  @FindBy(xpath = "//div[1]/div[2]/div/div[2]/span/span[@class='forceOutputCurrency']")
  @CacheLookup
  private WebElement quoteTaxLabelLight;

  @FindBy(xpath = "")
  @CacheLookup
  private WebElement quoteShippingAndHandlingLabelLight;

  //Links
  @FindBy(xpath = "//a[contains(@title, 'Show 3 more actions')]")
  @CacheLookup
  private WebElement showMoreActionsLink;

  @FindBy(xpath = "//div/ul/li[2]/a[contains(@title, 'Edit')]")
  @CacheLookup
  private WebElement editLink;

  @FindBy(xpath = "//div/ul/li[3]/a[@title='Delete']")
  @CacheLookup
  private WebElement deleteLinkLight;

  @FindBy(xpath = "//button[@title='Delete']")
  @CacheLookup
  private WebElement deleteConfirmationLinkLight;

  @FindBy(xpath = "//div[5]/div/div/div[3]/div[1]/div/div/div/ul/li[@class='tabs__item uiTabItem']/a[@title='Details']/span[2]")
  @CacheLookup
  private WebElement quoteDetailsLink;

  private WebElement quoteEditedMessage;

  public QuotesContentPageLight() {
    super.quoteNameLabel = quoteNameLight;
    super.quoteExpirationDateLabel = quoteExpirationDateLight;
    super.quoteStatusLabel = quoteStatusLabelLight;
    super.quoteDescriptionLabel = quoteDescriptionLabelLight;
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
   * <p>This method performs deletion of Quote.</p>
   */
  @Override
  public void deleteQuote() {
    driverTools.clickElement(showMoreActionsLink);
    driverTools.clickElement(deleteLinkLight);
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
}
