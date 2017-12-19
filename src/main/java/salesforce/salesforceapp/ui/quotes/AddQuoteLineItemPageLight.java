package salesforce.salesforceapp.ui.quotes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.products.Product;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class AddQuoteLineItemPageLight extends AddQuoteLineItemPage {
  @FindBy(xpath = "//div[contains(@class, 'footerAction')]/button[contains(@class, 'uiButton--default')]")
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
      By productInputPath = By.xpath("//div[@class='autocompleteWrapper']");
      By elementPath = By.xpath(String.format("//div[@class='autocompleteWrapper']//mark[text()='%s']", itemProduct.getName()));
      WebElement productInput = driver.findElement(productInputPath);
      Actions actions = new Actions(driver);
      actions.moveToElement(productInput);
      actions.click();
      actions.sendKeys(itemProduct.getName());
      actions.build().perform();
      if (driverTools.isElementVisibility(elementPath)) {
        WebElement element = driver.findElement(elementPath);
        driverTools.clickElement(element);
      }
    }
    driverTools.clickElement(selectBtn);
    return new QuoteLineItemEditionFormLight();
  }
}
