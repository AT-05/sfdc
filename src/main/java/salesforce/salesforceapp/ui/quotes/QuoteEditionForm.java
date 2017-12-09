package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.HomeBasePage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class QuoteEditionForm extends HomeBasePage {
  protected WebElement quoteName;
  protected WebElement quoteExpirationDate;
  protected WebElement quoteStatusLink;
  protected WebElement status;
  protected String statusInput;
  protected WebElement quoteDescription;
  protected WebElement buttonSave;

  /**
   * <p>This method fills quote form fields.</p>
   *
   * @param quote is an Entity object type.
   */
  private void setQuoteValues(Quote quote) {
    driverTools.setInputField(quoteName, quote.getName());
    driverTools.setInputField(quoteExpirationDate, quote.getExpirationDate());
    driverTools.clickElement(quoteStatusLink);
    statusInput = quote.getStatus();
    status = driver.findElement(By.xpath("//a[contains(@title, '" + statusInput + "')]"));
    driverTools.clickElement(status);
    driverTools.setInputField(quoteDescription, quote.getDescription());
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
    driverTools.clickElement(buttonSave);
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
   * @param quote is an entity object type.
   * @return a QuotesContentPage object type.
   */
  public abstract QuotesContentPage editQuote(Quote quote);

  /**
   * <p>This method opens a specific quote.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  public abstract QuotesContentPage openQuote(String quoteName);
}
