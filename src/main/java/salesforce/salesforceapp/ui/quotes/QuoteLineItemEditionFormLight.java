package salesforce.salesforceapp.ui.quotes;

import java.util.*;
import org.openqa.selenium.*;
import salesforce.salesforceapp.entities.products.*;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuoteLineItemEditionFormLight extends QuoteLineItemEditionForm {
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
    for (Product itemProduct : productList) {
      By salesPricePath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[3]//span[2]/button", itemProduct.getName()));
      if (driverTools.isElementVisibility(salesPricePath)) {
        WebElement salesPriceBtn = driver.findElement(salesPricePath);
        driverTools.clickElement(salesPriceBtn);
        By salesPriceInputPath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[3]//input", itemProduct.getName()));
        WebElement salesPriceInput = driver.findElement(salesPriceInputPath);
        driverTools.setInputField(salesPriceInput, itemProduct.getSalesPrice());
        //Todo Add missing fields quantity and discount
      }
    }
    //Todo Add missing button save
    return new QuotesContentPageLight();
  }
}
