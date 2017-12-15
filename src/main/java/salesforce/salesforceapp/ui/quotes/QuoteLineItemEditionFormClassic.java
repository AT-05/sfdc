package salesforce.salesforceapp.ui.quotes;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import salesforce.salesforceapp.entities.products.*;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuoteLineItemEditionFormClassic extends QuoteLineItemEditionForm {
  @FindBy(xpath = "//form[@id='editPage']//tr[1]//input[@value=' Save ']")
  @CacheLookup
  private WebElement saveBtn;

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
      final String productName = itemProduct.getName();
      final By salesPricePath = By.xpath(String.format("//th[contains(text(), '%s')]/ancestor::tr/td[2]/input", productName));
      final WebElement salesPriceInput = driver.findElement(salesPricePath);
      driverTools.setInputField(salesPriceInput, String.valueOf(itemProduct.getSalesPrice()));
      final By quantityPath = By.xpath(String.format("//th[contains(text(), '%s')]/ancestor::tr/td[3]/input", productName));
      final WebElement quantityInput = driver.findElement(quantityPath);
      driverTools.setInputField(quantityInput, String.valueOf(itemProduct.getQuantity()));
      final By discountPath = By.xpath(String.format("//th[contains(text(), '%s')]/ancestor::tr/td[5]/input", productName));
      final WebElement discountInput = driver.findElement(discountPath);
      driverTools.setInputField(discountInput, String.valueOf(itemProduct.getDiscount()));
    }
    driverTools.clickElement(saveBtn);
    return new QuotesContentPageClassic();
  }
}
