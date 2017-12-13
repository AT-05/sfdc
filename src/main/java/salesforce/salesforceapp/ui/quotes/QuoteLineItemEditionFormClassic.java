package salesforce.salesforceapp.ui.quotes;

import java.util.*;
import salesforce.salesforceapp.entities.products.*;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuoteLineItemEditionFormClassic extends QuoteLineItemEditionForm {
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method performs edition of quote line item.</p>
   *
   * @param productList is an Entity object type list.
   * @return a QuotesContentPage object type.
   */
  @Override
  public QuotesContentPage editQuoteLineItem(List<Product> productList) {
    //Todo Add
    return new QuotesContentPageClassic();
  }
}
