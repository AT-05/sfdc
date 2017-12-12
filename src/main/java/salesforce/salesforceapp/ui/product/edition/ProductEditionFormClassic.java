package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;

/**
 * Created by Marco Mendez.
 */
public class ProductEditionFormClassic extends ProductEditionForm {


    @FindBy(id = "Name")
    private WebElement elementNameInput;

    @FindBy(id = "ProductCode")
    private WebElement elementCodeInput;

    @FindBy(id = "Description")
    private WebElement elementDescriptionInput;

    @FindBy(id = "IsActive")
    private WebElement elementCheckBox;

    @FindBy(name = "save")
    private WebElement elementBtn;

    /**
     * Constructor product form.
     */
    public ProductEditionFormClassic() {
        super.productNameInput = elementNameInput;
        super.productCodeInput = elementCodeInput;
        super.productDescriptionInput = elementDescriptionInput;
        super.saveBtn = elementBtn;
        super.activeCheckBox = elementCheckBox;
    }

    /**
     * Click save products data.
     *
     * @return product content.
     */
    private ProductContentPageClassic clickSaveBnt() {
        saveBtn.click();
        return new ProductContentPageClassic();
    }

    @Override
    public ProductContentPageClassic createProduct(Product product) {
        setProductNameInput(product.getName());
        setProductCodeInput(product.getCode());
        setProductDescriptionInput(product.getDescription());
        setActiveCheckBox(product.getActive());
        return clickSaveBnt();
    }

    @Override
    public ProductContentPage editProduct(Product product) {
        setProductCodeInput(product.getCode());
        setProductNameInput(product.getName());
        setProductDescriptionInput(product.getDescription());
        setActiveCheckBox(product.getActive());
        return clickSaveBnt();
    }

}
