package salesforce.salesforceapp.ui.product.create;

import org.openqa.selenium.By;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageClassic;

import java.util.List;

public class CreateProductPageLightning extends CreateProductPage {

    public CreateProductPageLightning() {
        super.productName = driver.findElement(By.xpath("//div/div/div/div/div/div/div/div/input"));
     super.productCode = driver.findElement(By.xpath("//div[2]/div/div/div/div/input"));
          super.productDescription = driver.findElement(By.xpath("//textarea"));
        super.saveBtn = driver.findElement(By.xpath("//div/button[3]"));

    }


    @Override
    public ProductDetailPageClassic createProduct(List<Product> entity) {
        waitUntilPageObjectIsLoaded();
        setProductName(entity.get(0).getName());
        setProductDescription(entity.get(0).getDescription());
        setProductCode(entity.get(0).getCode());
        saveBtn.click();
        return new ProductDetailPageClassic();
    }



}
