package salesforce.salesforceapp.ui.product.create;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.CreateProductBasePage;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageClassic;

import java.util.List;

public abstract class CreateProductPage extends CreateProductBasePage {

    String selector = "";
    FindBy (jjfl)
    WebElement productInput

    public WebElement productName;

    public WebElement productCode;
    public WebElement productDescription;
    public WebElement saveBtn;

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

    public abstract ProductDetailPageClassic createProduct(List<Product> entity);



}
