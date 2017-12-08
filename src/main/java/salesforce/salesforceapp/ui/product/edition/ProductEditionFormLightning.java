package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.By;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;

import java.util.List;

public class ProductEditionFormLightning extends ProductEditionForm {

    public ProductEditionFormLightning() {
        super.productName = driver.findElement(By.xpath("//div/div/div/div/div/div/div/div/input"));
     super.productCode = driver.findElement(By.xpath("//div[2]/div/div/div/div/input"));
          super.productDescription = driver.findElement(By.xpath("//textarea"));
        super.saveBtn = driver.findElement(By.xpath("//div/button[3]"));

    }


    @Override
    public ProductContentPageClassic createProduct(Product product) {
        waitUntilPageObjectIsLoaded();
        setProductName(product.getName());
        setProductDescription(product.getDescription());
        setProductCode(product.getCode());
        saveBtn.click();
        return new ProductContentPageClassic();
    }



    @Override
    public void editProduct(Product product) {

    }


}
