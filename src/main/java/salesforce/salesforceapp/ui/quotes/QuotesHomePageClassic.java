package salesforce.salesforceapp.ui.quotes;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesHomePageClassic extends QuotesHomePage {

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method sends to a quote's content page.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  @Override
  public QuotesContentPage selectQuote(String quoteName) {
    selectItem(quoteName);
    return new QuotesContentPageClassic();
  }
}
