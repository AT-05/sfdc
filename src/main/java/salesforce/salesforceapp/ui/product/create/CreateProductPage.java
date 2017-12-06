package salesforce.salesforceapp.ui.product.create;

import salesforce.salesforceapp.entities.CreateProductEntity;
import salesforce.salesforceapp.ui.CreateProductBasePage;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageClassic;
import salesforce.salesforceapp.ui.product.detail.ProductDetailsPage;

import java.util.List;

public abstract class CreateProductPage extends CreateProductBasePage {

    public void setProductName(String name) {
        productName.clear();
        productName.sendKeys(name);
    }

    public void setProductCode(String code) {
        productCode.clear();
        productCode.sendKeys(code);
    }

    public void setProductDescription(String description) {
        productDescription.clear();
        productDescription.sendKeys(description);
    }

    public abstract ProductDetailPageClassic createProduct(List<CreateProductEntity> entity);

    public abstract ProductDetailsPage createProduct();


}
