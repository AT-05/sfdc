package salesforce.salesforceapp.ui.quotes;

import java.util.List;
import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.ContentBasePage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class QuotesContentPage extends ContentBasePage {
  protected List<WebElement> quoteName;
  protected WebElement quoteExpirationDate;
  protected WebElement quoteStatus;
  protected WebElement quoteDescription;

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
   * @return whether the message was displayed or not.
   */
  public abstract boolean isQuoteEditedMessageDisplayed();

  /**
   * <p>This method opens the quote details frame.</p>
   */
  public abstract void openQuoteDetails();

  /**
   * <p>This method checks if the quote's information
   * was updated correctly.</p>
   *
   * @param quote is an entity object type.
   * @return whether the quote's information was updated correctly or not.
   */
  public abstract boolean isUpdated(Quote quote);

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
    /*if (driverTools.getTextElement(quoteName.get(0)).equalsIgnoreCase(quote.getName())
      && driverTools.getTextElement(quoteExpirationDate).equalsIgnoreCase(quote.getExpirationDate())
      && driverTools.getTextElement(quoteStatus).equalsIgnoreCase(quote.getStatus())
      && driverTools.getTextElement(quoteDescription).equalsIgnoreCase(quote.getDescription())){
      result = true;
    }*/
    return result;
  }
}
