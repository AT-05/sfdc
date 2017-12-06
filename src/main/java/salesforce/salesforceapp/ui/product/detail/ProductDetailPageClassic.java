package salesforce.salesforceapp.ui.product.detail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.BasePage;

public class ProductDetailPageClassic extends ProductDetailsPage {
    public static final String PRODUCT_DETAIL = "Product Detail";
    public ProductDetailPageClassic()
    {
        super.elementValidator=driver.findElement(By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2"));
    }

    @Override
    public boolean IsProductDetailsPage() {
        return elementValidator.getText().equalsIgnoreCase(PRODUCT_DETAIL);
    }

}
