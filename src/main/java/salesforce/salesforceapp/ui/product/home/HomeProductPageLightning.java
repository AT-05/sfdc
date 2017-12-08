package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormLightning;

public class HomeProductPageLightning extends HomeProductPage {

    public HomeProductPageLightning() {
        super.newProduct = driver.findElement(By.xpath(".//*[@id='brandBand_1']/div/div/div[2]/div/div/div[1]/div[1]/div[2]/ul/li/a"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ProductEditionFormLightning newProduct() {
        System.out.println("Create Product view Lighting *******************marcoooo*********");
        newProduct.click();
        return new ProductEditionFormLightning();
    }

    @Override
    public ProductContentPage selectProduct() {
        return null;
    }

}
