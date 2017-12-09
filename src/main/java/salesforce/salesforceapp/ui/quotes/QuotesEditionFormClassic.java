package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import salesforce.salesforceapp.entities.quotes.Quote;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesEditionFormClassic extends QuoteEditionForm {

  /**
   * <p>This constructor initializes selectors.</p>
   */
  public QuotesEditionFormClassic() {
    super.quoteName = driver.findElement(By.id("Name"));
    super.quoteExpirationDate = driver.findElement(By.id("ExpirationDate"));
    super.quoteStatusLink = driver.findElement(By.id("Status"));
    super.quoteDescription = driver.findElement(By.id("Description"));
    super.buttonSave = driver.findElement(By.xpath("//input[contains(@class, 'btn') and contains(@name, 'save')]"));
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method checks if after creating a quote,
   * a successful created quote message is displayed.</p>
   *
   * @param quoteName is the quote name input.
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteCreatedMessageDisplayed(String quoteName) {
    return true; //In this skin there is no message displayed.
  }

  /**
   * <p>This method performs edition of quote's information.</p>
   *
   * @param quote is an entity object type.
   */
  @Override
  public QuotesContentPage editQuote(Quote quote) {
    //edit quote
    return new QuotesContentPageClassic();
  }

  /**
   * <p>This method opens a specific quote.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  @Override
  public QuotesContentPage openQuote(String quoteName) {
    return new QuotesContentPageClassic();
  }
}
