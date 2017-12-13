package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class QuoteEditionForm extends HomeBasePage {
  protected WebElement quoteNameInput;
  protected WebElement quoteExpirationDateInput;
  protected String status;
  protected WebElement quoteDescriptionInput;
  protected WebElement quoteTaxInput;
  protected WebElement quoteShippingAndHandlingInput;
  protected WebElement saveBtn;

  /**
   * <p>This method sets quote status.</p>
   */
  protected abstract void setStatus();

  /**
   * <p>This method fills quote form fields.</p>
   *
   * @param quote is an Entity object type.
   */
  private void setQuoteValues(Quote quote) {
    driverTools.setInputField(quoteNameInput, quote.getName());
    driverTools.setInputField(quoteExpirationDateInput, quote.getExpirationDate());
    status = quote.getStatus();
    setStatus();
    driverTools.setInputField(quoteDescriptionInput, quote.getDescription());
    driverTools.setInputField(quoteTaxInput, quote.getTax().toString());
    driverTools.setInputField(quoteShippingAndHandlingInput, quote.getShippingAndHandling().toString());
  }

  /**
   * <p>This method performs creation of new quote.</p>
   *
   * @param oppy      is an Entity object type.
   * @param quoteName is the quote name given.
   */
  public void createQuote(Oppy oppy, String quoteName) {
    Quote quote = oppy.getQuote(quoteName);
    setQuoteValues(quote);
    driverTools.clickElement(saveBtn);
  }

  /**
   * <p>This method checks if after creating a quote,
   * a successful created quote message is displayed.</p>
   *
   * @param quoteName is the quote name input.
   * @return whether the message was displayed or not.
   */
  public abstract boolean isQuoteCreatedMessageDisplayed(String quoteName);

  /**
   * <p>This method performs edition of quote's information.</p>
   *
   * @param oppy      is an Entity object type.
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  public QuotesContentPage editQuote(Oppy oppy, String quoteName) {
    createQuote(oppy, quoteName);
    return PageFactory.getQuotesContentPage();
  }

  /**
   * <p>This method opens a specific quote.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  public abstract QuotesContentPage openQuote(String quoteName);
}
