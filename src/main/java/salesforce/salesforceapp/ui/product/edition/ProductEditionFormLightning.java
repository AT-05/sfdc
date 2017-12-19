package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPageLightning;

/**
 * Created by Marco Mendez.
 */
public class ProductEditionFormLightning extends ProductEditionForm {

    @FindBy(xpath = "//div/div/div/div/div/div/div/div/input")
    private WebElement elementNameInput;

    @FindBy(xpath = "//div[2]/div/div/div/div/input")
    private WebElement elementCodeInput;

    @FindBy(xpath = "//textarea")
    private WebElement elementDescriptionInput;

    @FindBy(xpath = "//div[2]/div/div/div/input")
    private WebElement elementCheckBox;

    @FindBy(xpath = "//div/button[3]")
    private WebElement elementSaveBtn;

    /**
     * Constructor ProductEditionLightning.
     */
    public ProductEditionFormLightning() {
        super.productNameInput = elementNameInput;
        super.productCodeInput = elementCodeInput;
        super.productDescriptionInput = elementDescriptionInput;
        super.activeCheckBox = elementCheckBox;
        super.saveBtn = elementSaveBtn;
    }

    /**
     * Click products data save btn.
     *
     * @return products content.
     */
    private ProductContentPageLightning clickSaveBnt() {
        saveBtn.click();
        return new ProductContentPageLightning();
    }


    /**
     * Create a new products.
     *
     * @param product products.
     * @return ProductContent.
     */
    @Override
    public ProductContentPageLightning createProduct(Product product) {
        waitUntilPageObjectIsLoaded();
        setProductNameInput(product.getName());
        setProductDescriptionInput(product.getDescription());
        setProductCodeInput(product.getCode());
        setActiveCheckBox(product.getActive());
        return clickSaveBnt();
    }

    /**
     * Edit an existing products.
     *
     * @param product products.
     * @return products content.
     */

    @Override
    public ProductContentPageLightning editProduct(Product product) {
        setProductNameInput(product.getName());
        setProductDescriptionInput(product.getDescription());
        setProductCodeInput(product.getCode());
        return clickSaveBnt();
    }


}
