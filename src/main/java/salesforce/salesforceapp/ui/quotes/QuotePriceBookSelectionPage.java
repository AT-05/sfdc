package salesforce.salesforceapp.ui.quotes;

import salesforce.salesforceapp.ui.HomeBasePage;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public abstract class QuotePriceBookSelectionPage extends HomeBasePage{

  /**
   * <p>This method performs selection of price book.</p>
   *
   * @return a AddQuoteLineItemPage object type.
   * @param priceBookName is the price book name given.
   */
  public abstract AddQuoteLineItemPage selectPriceBook(String priceBookName);
}
