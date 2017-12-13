package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.product.Product;
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
     * Check if is present the Alert and accept delete product.
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
     * Check is the product fields are corrects.
     *
     * @param product product.
     * @return boolean.
     */
    public abstract boolean validateProductFields(Product product);

    /**
     * Go to edit existing product.
     *
     * @return ProductEditionForm.
     */
    public abstract ProductEditionForm editProduct();

    /**
     * Delete an existing product.
     *
     * @return Home Product Page.
     */
    public abstract HomeProductPage deleteProduct();

    /**
     * Go to Home Product page.
     *
     * @return Home product page.
     */
    public abstract HomeProductPage goToHomProductPage();
}
