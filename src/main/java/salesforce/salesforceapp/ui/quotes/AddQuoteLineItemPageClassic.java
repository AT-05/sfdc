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
public class AddQuoteLineItemPageClassic extends AddQuoteLineItemPage {
  @FindBy(xpath = "//input[contains(@onclick,'verifyChecked')]")
  @CacheLookup
  private WebElement selectBtn;

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
    for (Product itemProduct : productList) {
      final By path = By.xpath(String.format("//span[text()='%s']/ancestor::tr/td[1]//input[@class='checkbox']", itemProduct.getName()));
      final WebElement elementCheckBox = driver.findElement(path);
      driverTools.selectCheckBox(elementCheckBox);
    }
    driverTools.clickElement(selectBtn);
    return new QuoteLineItemEditionFormClassic();
  }
}
