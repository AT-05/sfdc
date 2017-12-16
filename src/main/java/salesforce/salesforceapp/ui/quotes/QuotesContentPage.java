package salesforce.salesforceapp.ui.quotes;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.*;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class QuotesContentPage extends ContentBasePage {
  //Web elements
  protected By quoteNameLabel;
  protected By quoteExpirationDateLabel;
  protected By quoteStatusLabel;
  protected By quoteDescriptionLabel;
  protected By quoteTaxLabel;
  protected By quoteShippingAndHandlingLabel;
  protected By quoteSubTotalLabel;
  protected By quoteDiscountLabel;
  protected By quoteTotalPriceLabel;
  protected By quoteGrandTotalLabel;

  //Entities
  protected Quote quoteInfo;

  //utilities
  private Logger log = Logger.getLogger(getClass());

  /**
   * <p>This method sends to Quote Edition Form.</p>
   *
   * @return a QuoteEditionForm object type.
   */
  public abstract QuoteEditionForm goToEditQuote();

  /**
   * <p>This method checks if after editing a quote,
   * a successful edited quote message is displayed.</p>
   *
   * @param quoteName is the quote name given.
   * @return whether the message was displayed or not.
   */
  public abstract boolean isQuoteEditedMessageDisplayed(String quoteName);

  /**
   * <p>This method opens the quote details frame.</p>
   */
  public abstract void openQuoteDetails();

  /**
   * <p>This method checks correction of quote information.</p>
   *
   * @param quote is an Entity object type.
   * @return whether the quote info is correct or not.
   */
  public boolean isQuoteInfoCorrect(Quote quote) {
    quoteInfo = quote;
    getLocators();
    if (driverTools.isElementVisibility(quoteNameLabel)
        /*&& driverTools.isElementVisibility(quoteExpirationDateLabel)
        && driverTools.isElementVisibility(quoteStatusLabel)
        && driverTools.isElementVisibility(quoteDescriptionLabel)*/
        && driverTools.isElementVisibility(quoteTaxLabel)
        && driverTools.isElementVisibility(quoteShippingAndHandlingLabel)
        && driverTools.isElementVisibility(quoteSubTotalLabel)
        && driverTools.isElementVisibility(quoteDiscountLabel)
        && driverTools.isElementVisibility(quoteTotalPriceLabel)
        && driverTools.isElementVisibility(quoteGrandTotalLabel)) {
      return true;
    }
    return false;
  }

  /**
   * <p>This method gets locators for verifying quote information.</p>
   */
  protected abstract void getLocators();

  /**
   * <p>This method performs deletion of Quote.</p>
   */
  public abstract void deleteQuote();

  /**
   * <p>This method checks if after deleting a quote,
   * a successful deleted quote message is displayed.</p>
   *
   * @param quoteName is the quote name given.
   * @return whether the message was displayed or not.
   */
  public abstract boolean isQuoteDeletedMessageDisplayed(String quoteName);

  /**
   * <p>This method sends to Price Book Selection Page.</p>
   *
   * @return a QuotePriceBookSelectionPage object type.
   */
  public abstract QuotePriceBookSelectionPage goToAddLineItem();

  /**
   * <p>This method sends to Quote Line Items View Page.</p>
   *
   * @return a QuoteLineItemsView object type.
   */
  public abstract QuoteLineItemsView goToQuoteLineItemsView();

  /**
   * <p>This method checks if after adding quote line item(s),
   * a successful saved changes message is displayed.</p>
   *
   * @return whether the message was displayed or not.
   */
  public abstract boolean isQuoteLineItemCreatedMessageDisplayed();

  /**
   * <p>This method checks if after adding quote line item(s),
   * the quote totals are updated correctly.</p>
   *
   * @param quote is an Entity object type.
   * @return whether the quote totals were updated correctly or not.
   */
  public boolean areQuoteTotalsUpdated(Quote quote) {
    return isQuoteInfoCorrect(quote);
  }
}
