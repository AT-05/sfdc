package salesforce.salesforceapp.ui.product.detail;

import org.openqa.selenium.By;

public class ProductDetailPageLightning extends ProductDetailsPage {
    public static final String PRODUCT_DETAIL = "Product Code";

    public ProductDetailPageLightning() {
        super.elementValidator = driver.findElement(By.xpath(".//*[@id='brandBand_1']/div/div/div[3]/div/div/div[1]/div/header/div[2]/ul/li[1]/p[1]"));
    }

    @Override
    public boolean IsProductDetailsPage() {
        return elementValidator.getText().equalsIgnoreCase(PRODUCT_DETAIL);
    }

}
