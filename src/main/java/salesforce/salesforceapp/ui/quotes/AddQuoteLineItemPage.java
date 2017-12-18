package salesforce.salesforceapp.ui.quotes;

import java.util.List;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.ui.HomeBasePage;

/**
 * Created by Administrator on 12/13/2017.
 */
public abstract class AddQuoteLineItemPage extends HomeBasePage {

  /**
   * <p>This method performs adding of quote line item(s).</p>
   *
   * @param productList is a quote line item list.
   * @return a QuoteLineItemEditionForm object type.
   */
  public abstract QuoteLineItemEditionForm addQuoteLineItem(List<Product> productList);
}
