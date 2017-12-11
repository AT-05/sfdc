package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.entities.quotes.Quote;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.ViewBasePage;
import salesforce.salesforceapp.ui.quotes.QuoteEditionForm;
import salesforce.salesforceapp.ui.quotes.QuotesContentPage;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class OppyQuotesView extends ViewBasePage {

  /**
   * <p>This method sends to a quote's content page.</p>
   *
   * @param oppy      is an Oppy object type.
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  public QuotesContentPage selectQuote(Oppy oppy, String quoteName) {
    Quote quote = oppy.getQuote(quoteName);
    selectItem(quote.getName());
    return PageFactory.getQuotesContentPage();
  }

  /**
   * <p>This method sends to Quote Edition Form.</p>
   *
   * @return a QuoteEditionForm object type.
   */
  public QuoteEditionForm goToCreateQuote() {
    clickNewBtn();
    return PageFactory.getQuoteEditionForm();
  }
}
