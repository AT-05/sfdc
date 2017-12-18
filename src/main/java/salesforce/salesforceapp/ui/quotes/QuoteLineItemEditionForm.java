package salesforce.salesforceapp.ui.quotes;

import java.util.List;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.ui.HomeBasePage;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public abstract class QuoteLineItemEditionForm extends HomeBasePage {

  /**
   * <p>This method performs edition of quote line item.</p>
   *
   * @param productList is an Entity object type list.
   * @return a QuotesContentPage object type.
   */
  public abstract QuotesContentPage editQuoteLineItem(List<Product> productList);
}
