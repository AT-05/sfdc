package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.products.Product;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;

/**
 * Created by Marco Mendez.
 */
public abstract class ProductContentPage extends BasePage {


    public TopMenu topMenu;

    public WebElement editBtn;
    public WebElement deleteBtn;
    public WebElement productNameLabel;
    public WebElement productCodeLabel;
    public WebElement productDescriptionLabel;
    public WebElement activeCheckBox;


    /**
     * Check if is present the Alert and accept delete products.
     */
    public void checkAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Check is the products fields are corrects.
     *
     * @param product products.
     * @return boolean.
     */
    public abstract boolean validateProductFields(Product product);

    /**
     * Go to edit existing products.
     *
     * @return ProductEditionForm.
     */
    public abstract ProductEditionForm editProduct();

    /**
     * Delete an existing products.
     *
     * @return Home Product Page.
     */
    public abstract HomeProductPage deleteProduct();

    /**
     * Go to Home Product page.
     *
     * @return Home products page.
     */
    public abstract HomeProductPage goToHomProductPage();
}
