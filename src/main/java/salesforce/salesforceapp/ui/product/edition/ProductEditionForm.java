package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;

import java.util.List;

public abstract class ProductEditionForm extends BasePage {

    public WebElement productName;
    public WebElement productCode;
    public WebElement productDescription;
    public WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

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

    public abstract ProductContentPageClassic createProduct(Product product);

    public abstract void editProduct(Product product);


}
