package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.ContentBasePage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class QuotesContentPage extends ContentBasePage {
  protected WebElement quoteNameLabel;
  protected WebElement quoteExpirationDateLabel;
  protected WebElement quoteStatusLabel;
  protected WebElement quoteDescriptionLabel;
  protected WebElement quoteTaxLabel;
  protected WebElement quoteShippingAndHandlingLabel;
  protected WebElement quoteGrandTotalLabel;
  protected Quote quoteInfo;

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
   * @param oppy           is an Entity object type.
   * @param quoteNameInput is the quote name given.
   * @return whether the quote info is correct or not.
   */
  public boolean isQuoteInfoCorrect(Oppy oppy, String quoteNameInput) {
    boolean result = false;
    Quote quote = oppy.getQuote(quoteNameInput);
    quoteInfo = quote;
    if (/*driverTools.getTextElement(quoteNameInput).equalsIgnoreCase(quote.getName())
      && driverTools.getTextElement(quoteExpirationDateInput).equalsIgnoreCase(quote.getExpirationDate())
      &&*/ driverTools.getTextElement(quoteStatusLabel).equalsIgnoreCase(quote.getStatus())
      && driverTools.getTextElement(quoteDescriptionLabel).equalsIgnoreCase(quote.getDescription())
      && driverTools.getTextElement(quoteTaxLabel).contains(quote.getTax())
      && driverTools.getTextElement(quoteShippingAndHandlingLabel).contains(quote.getShippingAndHandling())
      && driverTools.getTextElement(quoteGrandTotalLabel).contains(quote.getGrandTotal())) {
      result = true;
    }
    return result;
  }

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
}
