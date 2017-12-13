package salesforce.salesforceapp.ui.quotes;

import java.util.*;
import salesforce.salesforceapp.entities.products.*;
import salesforce.salesforceapp.ui.*;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public abstract class QuoteLineItemsView extends ViewBasePage{

  /**
   * <p>This method checks if after adding quote line item(s),
   * it/they appear in the quote line items list.</p>
   *
   * @param products is an Entity object type list.
   * @return whether the quote line item(s) appear(s) in the list or not.
   */
  public abstract boolean isQuoteLineItemsListUpdated(List<Product> products);
}
