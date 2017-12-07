package salesforce.salesforceapp.ui.product.create;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageClassic;

import java.util.List;

public class CreateProductPageClassic extends CreateProductPage {

    FindBy ()
    WebElement productInput

    public CreateProductPageClassic() {
        System.out.println("Estoy en el constructor Create product classic***************");
        super.productName = driver.findElement(By.id("Name"));
        super.productName = productInput;
        super.productCode = driver.findElement(By.id("ProductCode"));
        super.productDescription = driver.findElement(By.id("Description"));
       super.saveBtn = driver.findElement(By.name("save"));

    }

    @Override
    public ProductDetailPageClassic createProduct(List<Product> entity) {

        setProductName(entity.get(0).getName());
        setProductCode(entity.get(0).getCode());
        setProductDescription(entity.get(0).getDescription());
        saveBtn.click();
        return new ProductDetailPageClassic();
    }





}
