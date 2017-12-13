package salesforce.salesforceapp.ui.quotes;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuotePriceBookSelectionPageLight extends QuotePriceBookSelectionPage {

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method performs selection of price book.</p>
   *
   * @return a AddQuoteLineItemPage object type.
   * @param priceBookName is the price book name given.
   */
  @Override
  public AddQuoteLineItemPage selectPriceBook(String priceBookName) {
    //Todo Add
    //Must check for locators, if not, just send to new page
    return new AddQuoteLineItemPageLight();
  }
}
