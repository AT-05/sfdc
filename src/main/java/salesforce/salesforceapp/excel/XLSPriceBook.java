package salesforce.salesforceapp.excel;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.api.methods.APIPriceBook;
import salesforce.salesforceapp.entities.pricebooks.PriceBook;

/**
 * Created by Administrator on 12/17/2017.
 */
public class XLSPriceBook {
  private static Logger log = Logger.getLogger("XLSPriceBook");
  private static  String PRICE_BOOK_NAME;
  private static  String PRICE_BOOK_ACTIVE;

  /**
   * <p>Create Price Books by API from excel sheet.</p>
   *
   * @param priceBooksXLS is the price book xls file.
   */
  public static void createPriceBook(List<Map<String, String>> priceBooksXLS) {
    log.info("Create Quotes");
    for (Map<String, String> quoteMap : priceBooksXLS) {
      PriceBook priceBook = new PriceBook();
      priceBook.setName(quoteMap.get(PRICE_BOOK_NAME));
      priceBook.setActive(quoteMap.get(PRICE_BOOK_ACTIVE));

      if (!APIPriceBook.isPriceBookSaved(priceBook)) {
        APIPriceBook.createPriceBook(priceBook);
      }
    }
  }

  public static void deletePriceBook(List<Map<String, String>> priceBooksXLS) {

  }

  public static void addProductaToPriceBook(List<Map<String, String>> priceBookProductXLS) {

  }
}
