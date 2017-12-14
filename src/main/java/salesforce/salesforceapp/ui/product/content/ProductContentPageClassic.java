package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.product.Product;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPageClassic;

/**
 * Created by Marco Mendez.
 */
public class ProductContentPageClassic extends ProductContentPage {


    private static final String PRODUCT_DETAIL = "Product Detail";

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
     * Check is the product fields are corrects.
     *
     * @param product product.
     * @return boolean.
     */
    @Override
    public boolean validateProductFields(Product product) {
        boolean active = activeCheckBox.getAttribute("Alt").equalsIgnoreCase("Not checked") ? false : true;
        return productNameLabel.getText().equalsIgnoreCase(product.getName().toString()) == true
                && productCodeLabel.getText().equalsIgnoreCase(product.getCode()) == true
                && productDescriptionLabel.getText().equalsIgnoreCase(product.getDescription()) == true
                && active == product.getActive();
    }

    /**
     * Go to edit existing product.
     *
     * @return ProductEditionForm.
     */
    @Override
    public ProductEditionForm editProduct() {
        editBtn.click();
        return new ProductEditionFormClassic();
    }


    /**
     * Delete an existing product.
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
     * @return Home product page.
     */
    @Override
    public HomeProductPage goToHomProductPage() {
        productTab.click();
        return new HomeProductPageClassic();
    }


}
