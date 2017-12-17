package salesforce.salesforceapp.ui.quotes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.products.Product;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuoteLineItemEditionFormLight extends QuoteLineItemEditionForm {
  @FindBy(xpath = "//div[contains(@class, 'modal-footer')]//button[contains(@class, 'uiButton--default')]")
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
      By salesPricePath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[3]//span[2]/button", itemProduct.getName()));
      By quantityPricePath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[4]//span[2]/button", itemProduct.getName()));
      By discountPricePath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[5]//span[2]/button", itemProduct.getName()));
      if (driverTools.isElementVisibility(salesPricePath)
          && driverTools.isElementVisibility(quantityPricePath)
          && driverTools.isElementVisibility(discountPricePath)) {
        //sales price
        WebElement salesPriceBtn = driver.findElement(salesPricePath);
        driverTools.clickElement(salesPriceBtn);
        By salesPriceInputPath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[3]//input", itemProduct.getName()));
        WebElement salesPriceInput = driver.findElement(salesPriceInputPath);
        driverTools.setInputField(salesPriceInput, itemProduct.getSalesPrice());
        //quantity
        WebElement quantityBtn = driver.findElement(quantityPricePath);
        driverTools.clickElement(quantityBtn);
        By quantityInputPath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[4]//input", itemProduct.getName()));
        WebElement quantityInput = driver.findElement(quantityInputPath);
        driverTools.setInputField(quantityInput, itemProduct.getQuantity());
        //discount
        WebElement discountBtn = driver.findElement(discountPricePath);
        driverTools.clickElement(discountBtn);
        By discountInputPath = By.xpath(String.format("//span[contains(@class, 'forceInlineEditCell')]/a[text()='%s']/ancestor::tr/td[5]//input", itemProduct.getName()));
        WebElement discountInput = driver.findElement(discountInputPath);
        driverTools.setInputField(discountInput, itemProduct.getDiscount());
      }
    }
    driverTools.clickElement(saveBtn);
    return new QuotesContentPageLight();
  }
}
