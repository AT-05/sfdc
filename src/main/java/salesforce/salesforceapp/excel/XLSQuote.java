package salesforce.salesforceapp.excel;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.api.methods.APIQuote;
import salesforce.salesforceapp.entities.quotes.Quote;

/**
 * Created by Franco Aldunate on 12/17/2017.
 */
public class XLSQuote {
  private static Logger log = Logger.getLogger("XLSQuote");
  private static String QUOTE_NAME;
  private static String QUOTE_EXPIRATION_DATE;
  private static String QUOTE_STATUS;
  private static String QUOTE_DESCRIPTION;
  private static String QUOTE_TAX;
  private static String QUOTE_SHIPPING_AND_HANDLING;

  /**
   * <p>Create Quotes by API from excel sheet.</p>
   *
   * @param quotesXLS is the quote xls file.
   */
  public static void createQuotes(List<Map<String, String>> quotesXLS) {
    log.info("Create Quotes");
    for (Map<String, String> quoteMap : quotesXLS) {
      Quote quote = new Quote();
      quote.setName(quoteMap.get(QUOTE_NAME));
      quote.setExpirationDate(quoteMap.get(QUOTE_EXPIRATION_DATE));
      quote.setStatus(quoteMap.get(QUOTE_STATUS));
      quote.setDescription(quoteMap.get(QUOTE_DESCRIPTION));
      quote.setTax(Double.valueOf(quoteMap.get(QUOTE_TAX)));
      quote.setShippingAndHandling(Double.valueOf(quoteMap.get(QUOTE_SHIPPING_AND_HANDLING)));

      if (!APIQuote.isQuoteSaved(quote)) {
        APIQuote.createQuote(quote);
      }
    }
  }

  public static void deleteQuotes(List<Map<String, String>> quotesXLS) {

  }
}
