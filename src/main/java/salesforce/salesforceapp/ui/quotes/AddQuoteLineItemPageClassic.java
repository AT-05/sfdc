package salesforce.salesforceapp.ui.quotes;

import java.util.*;
import salesforce.salesforceapp.entities.products.*;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class AddQuoteLineItemPageClassic extends AddQuoteLineItemPage {
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method performs adding of quote line item(s).</p>
   *
   * @param productList is a quote line item list.
   * @return a QuoteLineItemEditionForm object type.
   */
  @Override
  public QuoteLineItemEditionForm addQuoteLineItem(List<Product> productList) {
    //Todo Add
    return new QuoteLineItemEditionFormClassic();
  }
}
