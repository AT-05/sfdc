package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.By;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;

import java.util.List;

public class ProductEditionFormClassic extends ProductEditionForm {


    public ProductEditionFormClassic() {
        System.out.println("Estoy en el constructor Create product classic***************");
        super.productName = driver.findElement(By.id("Name"));
        super.productCode = driver.findElement(By.id("ProductCode"));
        super.productDescription = driver.findElement(By.id("Description"));
       super.saveBtn = driver.findElement(By.name("save"));

    }

    @Override
    public ProductContentPageClassic createProduct(Product product) {

        setProductName(product.getName());
        setProductCode(product.getCode());
        setProductDescription(product.getDescription());
        saveBtn.click();
        return new ProductContentPageClassic();
    }

    @Override
    public ProductContentPage editProduct(Product product) {
        setProductCode(product.getCode());
        setProductName(product.getName());
        setProductDescription(product.getDescription());
        saveBtn.click();
        return new ProductContentPageClassic();
    }





}
