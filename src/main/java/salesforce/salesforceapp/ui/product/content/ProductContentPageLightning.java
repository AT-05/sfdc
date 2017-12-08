package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.By;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

public class ProductContentPageLightning extends ProductContentPage {
    public static final String PRODUCT_DETAIL = "Product Code";

    public ProductContentPageLightning() {
        super.elementValidator = driver.findElement(By.xpath(".//*[@id='brandBand_1']/div/div/div[3]/div/div/div[1]/div/header/div[2]/ul/li[1]/p[1]"));
    }

    @Override
    public boolean IsProductDetailsPage() {
        return elementValidator.getText().equalsIgnoreCase(PRODUCT_DETAIL);
    }

    @Override
    public void goToEditProduct() {
        //return null;
    }

}
