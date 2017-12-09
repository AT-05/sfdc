package salesforce.salesforceapp.ui.quotes;

import salesforce.salesforceapp.entities.quotes.Quote;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesContentPageClassic extends QuotesContentPage {
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
    //click
    return new QuotesEditionFormClassic();
  }

  /**
   * <p>This method checks if after editing a quote,
   * a successful edited quote message is displayed.</p>
   *
   * @return whether the message was displayed or not.
   */
  @Override
  public boolean isQuoteEditedMessageDisplayed() {
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
   * <p>This method checks if the quote's information
   * was updated correctly.</p>
   *
   * @param quote is an entity object type.
   * @return whether the quote's information was updated correctly or not.
   */
  @Override
  public boolean isUpdated(Quote quote) {
    //Check quote updated
    return false;
  }
}
