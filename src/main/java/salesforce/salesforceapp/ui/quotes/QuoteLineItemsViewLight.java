package salesforce.salesforceapp.ui.quotes;

import java.util.*;
import salesforce.salesforceapp.entities.products.*;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuoteLineItemsViewLight extends QuoteLineItemsView {
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method checks if after adding quote line item(s),
   * it/they appear in the quote line items list.</p>
   *
   * @param products is an Entity object type list.
   * @return whether the quote line item(s) appear(s) in the list or not.
   */
  @Override
  public boolean isQuoteLineItemsListUpdated(List<Product> products) {
    //Todo Add
    return false;
  }
}
