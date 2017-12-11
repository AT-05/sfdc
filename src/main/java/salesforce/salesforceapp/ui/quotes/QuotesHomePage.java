package salesforce.salesforceapp.ui.quotes;

import salesforce.salesforceapp.ui.HomeBasePage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class QuotesHomePage extends HomeBasePage {
  /**
   * <p>This method sends to a quote's content page.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  public abstract QuotesContentPage selectQuote(String quoteName);

  /**
   * <p>This method checks existence of Quote element
   * in the quote's list.</p>
   *
   * @param quoteName is the given quote name.
   * @return whether the quote exists in the list or not.
   */
  public abstract boolean isQuoteElementPresent(String quoteName);
}
