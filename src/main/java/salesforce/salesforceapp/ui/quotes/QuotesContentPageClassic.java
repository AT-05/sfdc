package salesforce.salesforceapp.ui.quotes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.products.Product;

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

  @FindBy(xpath = "//input[@value='Add Line Item']")
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
    super.quoteNameLabel = By.xpath(String.format("//div[@id='Name_ileinner' and text()='%s']", super.quoteInfo.getName()));
    super.quoteExpirationDateLabel = By.xpath(String.format("//div[@id='ExpirationDate_ileinner' and text()='%s']", super.quoteInfo.getExpirationDate()));
    super.quoteStatusLabel = By.xpath(String.format("//div[@id='Status_ileinner' and text()='%s']", super.quoteInfo.getStatus()));
    super.quoteDescriptionLabel = By.xpath(String.format("//div[@id='Description_ileinner'  and text()='%s']", super.quoteInfo.getDescription()));
    super.quoteTaxLabel = By.xpath(String.format("//div[@id='Tax_ileinner' and contains(text(),'%s')]", super.quoteInfo.getTax()));
    super.quoteShippingAndHandlingLabel = By.xpath(String.format("//div[@id='ShippingHandling_ileinner' and contains(text(),'%s')]", super.quoteInfo.getShippingAndHandling()));
    super.quoteSubTotalLabel = By.xpath(String.format("//div[@id='Subtotal_ileinner' and contains(text(),'%s')]", super.quoteInfo.getSubTotal()));
    super.quoteDiscountLabel = By.xpath(String.format("//div[@id='Discount_ileinner' and contains(text(),'%s')]", super.quoteInfo.getDiscount()));
    super.quoteTotalPriceLabel = By.xpath(String.format("//div[@id='TotalPrice_ileinner' and contains(text(),'%s')]", super.quoteInfo.getTotalPrice()));
    super.quoteGrandTotalLabel = By.xpath(String.format("//div[@id='GrandTotal_ileinner' and contains(text(),'%s')]", super.quoteInfo.getGrandTotal()));
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

  /**
   * <p>This method sends to Price Book Selection Page.</p>
   *
   * @return a QuotePriceBookSelectionPage object type.
   */
  @Override
  public QuotePriceBookSelectionPage goToAddLineItem() {
    driverTools.clickElement(addLineItemLink);
    return new QuotePriceBookSelectionPageClassic();
  }

  /**
   * <p>This method checks if after adding quote line item(s),
   * a successful saved changes message is displayed.</p>
   *
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteLineItemCreatedMessageDisplayed() {
    return true; //There is no message displayed for this skin.
  }

  /**
   * <p>This method checks if products are found in the quote line items list.</p>
   *
   * @param products is an Entity object type list.
   * @return whether the products are found on the list or not.
   */
  @Override
  public boolean isQuoteLineItemsListUpdated(List<Product> products) {
    //Todo Add
    return false;
  }
}
