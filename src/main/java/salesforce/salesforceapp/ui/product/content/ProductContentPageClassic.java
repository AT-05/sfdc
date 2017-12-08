package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;

public class ProductContentPageClassic extends ProductContentPage {
    public static final String PRODUCT_DETAIL = "Product Detail";
    @FindBy(name = "edit")
   private WebElement edit;

    public ProductContentPageClassic() {
        //super.elementValidator = driver.findElement(By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2"));
        super.elementEdit = driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[3]"));
    }

    @Override
    public boolean IsProductDetailsPage() {
        return elementValidator.getText().equalsIgnoreCase(PRODUCT_DETAIL);
    }

    @Override
    public void goToEditProduct() {
        elementEdit.click();
        //return new ProductEditionFormClassic();
    }

}
