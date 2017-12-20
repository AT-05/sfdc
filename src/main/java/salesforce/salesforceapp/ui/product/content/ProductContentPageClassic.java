package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPageClassic;

import static org.junit.Assert.assertTrue;

/**
 * Created by Marco Mendez.
 */
public class ProductContentPageClassic extends ProductContentPage {


    @FindBy(name = "edit")
    private WebElement elementEditBtn;

    @FindBy(name = "del")
    private WebElement elementDeleteBtn;

    @FindBy(id = "Name_ileinner")
    private WebElement elementNameLabel;

    @FindBy(id = "ProductCode_ileinner")
    private WebElement elementCodeLabel;

    @FindBy(id = "Description_ileinner")
    private WebElement elementDescriptionLabel;

    @FindBy(id = "IsActive_chkbox")
    private WebElement elementCheckBox;

    @FindBy(xpath = ".//*[@id='Product2_Tab']/a")
    WebElement productTab;

    /**
     * Constructor Product content page.
     */
    public ProductContentPageClassic() {
        super.editBtn = elementEditBtn;
        super.deleteBtn = elementDeleteBtn;
        super.productNameLabel = elementNameLabel;
        super.productCodeLabel = elementCodeLabel;
        super.productDescriptionLabel = elementDescriptionLabel;
        super.activeCheckBox = elementCheckBox;

    }

    /**
     * Check is the products fields are corrects.
     *
     * @param product products.
     * @return boolean.
     */
    @Override
    public boolean validateProductFields(Product product) {
        assertTrue(productNameLabel.getText().equalsIgnoreCase(product.getName().toString()));
        assertTrue(productCodeLabel.getText().equalsIgnoreCase(product.getCode()));
        assertTrue(productDescriptionLabel.getText().equalsIgnoreCase(product.getDescription()));
        return productNameLabel.getText().equalsIgnoreCase(product.getName().toString()) == true;
    }

    /**
     * Go to edit existing products.
     *
     * @return ProductEditionForm.
     */
    @Override
    public ProductEditionForm editProduct() {
        editBtn.click();
        return new ProductEditionFormClassic();
    }

    /**
     * Delete an existing products.
     *
     * @return Home Product Page.
     */
    @Override
    public HomeProductPage deleteProduct() {
        deleteBtn.click();
        checkAlert();
        return new HomeProductPageClassic();
    }

    /**
     * Go to Home Product page.
     *
     * @return Home products page.
     */
    @Override
    public HomeProductPage goToHomProductPage() {
        productTab.click();
        return new HomeProductPageClassic();
    }

}
