package salesforce.salesforceapp.ui.product.create;

import org.openqa.selenium.By;
import salesforce.salesforceapp.entities.CreateProductEntity;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageClassic;

import java.util.List;

public class CreateProductPageClassic extends CreateProductPage {

    public CreateProductPageClassic() {
        System.out.println("Estoy en el constructor Create product classic***************");
        super.productName = driver.findElement(By.id("Name"));
        super.productCode = driver.findElement(By.id("ProductCode"));
        super.productDescription = driver.findElement(By.id("Description"));
       super.saveBtn = driver.findElement(By.name("save"));

    }

    @Override
    public ProductDetailPageClassic createProduct(List<CreateProductEntity> entity) {
        return null;
    }

    @Override
    public ProductDetailPageClassic createProduct() {
        waitUntilPageObjectIsLoaded();
        setProductName("Tarjetas");
        setProductCode("00021112");
        setProductDescription("tigo viva entel");
        saveBtn.click();
        return new ProductDetailPageClassic();
    }
/*





    @Override
    public ProductDetailPageClassic createProduct(List<CreateProductEntity> entity) {
        productName.clear();
        productName.sendKeys("Carajoooooooooooo");
       */
/* setProductCode(entity.get(0).getCode());
        setProductDescription(entity.get(0).getDescription());
        saveBtn.click();*//*

        return new ProductDetailPageClassic();
    }

    @Override
    public ProductDetailPageClassic createProduct() {
        waitUntilPageObjectIsLoaded();
        System.out.println("Creando productooooooooooo***********************************classic");
        productName.clear();
        productName.sendKeys("Carajoooooooooooo");
      */
/*  setProductCode(entity.get(0).getCode());
        setProductDescription(entity.get(0).getDescription());
        saveBtn.click();*//*

        return new ProductDetailPageClassic();
    }
*/


}
