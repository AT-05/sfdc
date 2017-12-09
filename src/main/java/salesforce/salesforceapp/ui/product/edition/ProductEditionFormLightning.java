package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;
import salesforce.salesforceapp.ui.product.content.ProductContentPageLightning;

import java.util.List;

public class ProductEditionFormLightning extends ProductEditionForm {


    @FindBy(xpath = "//div/div/div/div/div/div/div/div/input")
    private WebElement input1;

    @FindBy(xpath = "//div[2]/div/div/div/div/input")
    private WebElement input2;

    @FindBy(xpath = "//textarea")
    private WebElement input3;

    @FindBy(xpath = "//div/button[3]")
    private WebElement btn;

    public ProductEditionFormLightning() {
        super.productName = input1;
        super.productCode = input2;
        super.productDescription = input3;
        super.saveBtn = btn;
    }

    private ProductContentPageLightning clickSaveBnt() {
        saveBtn.click();
        return new ProductContentPageLightning();
    }

    @Override
    public ProductContentPageLightning createProduct(Product product) {
        waitUntilPageObjectIsLoaded();
        setProductName(product.getName());
        setProductDescription(product.getDescription());
        setProductCode(product.getCode());
     return clickSaveBnt();
    }


    @Override
    public ProductContentPageLightning editProduct(Product product) {
        setProductName(product.getName());
        setProductDescription(product.getDescription());
        setProductCode(product.getCode());
        return clickSaveBnt();
    }


}
