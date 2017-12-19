package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;

/**
 * Created by Marco Mendez.
 */
public abstract class ProductEditionForm extends BasePage {

    public WebElement productNameInput;
    public WebElement productCodeInput;
    public WebElement productDescriptionInput;
    public WebElement activeCheckBox;
    public WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Set the field products name input.
     *
     * @param name string.
     */
    public void setProductNameInput(String name) {
        productNameInput.clear();
        productNameInput.sendKeys(name);
    }

    /**
     * Set the field products code input.
     *
     * @param code string.
     */
    public void setProductCodeInput(String code) {
        productCodeInput.clear();
        productCodeInput.sendKeys(code);
    }

    /**
     * Set the field products description input.
     *
     * @param description string.
     */
    public void setProductDescriptionInput(String description) {
        productDescriptionInput.clear();
        productDescriptionInput.sendKeys(description);
    }

    /**
     * Selection the field Active checkBox.
     *
     * @param checkBox
     */
    public void setActiveCheckBox(boolean checkBox) {
        if (!activeCheckBox.isSelected() == checkBox) {
            activeCheckBox.click();
        }
    }

    /**
     * Create a new products.
     *
     * @param product products.
     * @return ProductContent.
     */
    public abstract ProductContentPage createProduct(Product product);

    /**
     * Edit an existing products.
     *
     * @param product products.
     * @return products content.
     */
    public abstract ProductContentPage editProduct(Product product);

}
