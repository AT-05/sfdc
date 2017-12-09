package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;
import salesforce.salesforceapp.ui.product.content.ProductContentPageLightning;

import java.util.List;

public class ProductEditionFormClassic extends ProductEditionForm {


    @FindBy(id = "Name")
    WebElement input1;

    @FindBy(id = "ProductCode")
    WebElement input2;

    @FindBy(id = "Description")
    WebElement input3;

    @FindBy(name = "save")
    WebElement btn;

    public ProductEditionFormClassic() {

        super.productName = input1;
        super.productCode = input2;
        super.productDescription = input3;
       super.saveBtn = btn;

    }
    private ProductContentPageClassic clickSaveBnt()
    {
        saveBtn.click();
        return new ProductContentPageClassic();
    }
    @Override
    public ProductContentPageClassic createProduct(Product product) {
        setProductName(product.getName());
        setProductCode(product.getCode());
        setProductDescription(product.getDescription());
      return clickSaveBnt();
    }

    @Override
    public ProductContentPage editProduct(Product product) {
        setProductCode(product.getCode());
        setProductName(product.getName());
        setProductDescription(product.getDescription());
        return clickSaveBnt();
    }





}
