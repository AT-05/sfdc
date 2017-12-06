package salesforce.salesforceapp.ui.product.create;

import org.openqa.selenium.By;
import salesforce.salesforceapp.entities.CreateProductEntity;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageClassic;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageLightning;

import java.util.List;

public class CreateProductPageLightning extends CreateProductPage {

    public CreateProductPageLightning() {
        super.productName = driver.findElement(By.xpath("//div/div/div/div/div/div/div/div/input"));
     super.productCode = driver.findElement(By.xpath("//div[2]/div/div/div/div/input"));
          super.productDescription = driver.findElement(By.xpath("//textarea"));
        super.saveBtn = driver.findElement(By.xpath("//div/button[3]"));

    }


    @Override
    public ProductDetailPageClassic createProduct(List<CreateProductEntity> entity) {
        return null;
    }

    @Override
    public ProductDetailPageLightning createProduct() {
        waitUntilPageObjectIsLoaded();
        setProductCode("00s033022");
       setProductDescription("tigoviva entel");
        setProductName("Tarjetas");
        saveBtn.click();
        return new ProductDetailPageLightning();
    }


}
