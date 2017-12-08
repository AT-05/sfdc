package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;


public abstract class ProductContentPage extends BasePage {
    /**
     * Check if is present the Alert and accept delete product.
     */
    public void checkAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public WebElement elementValidator;
    public WebElement elementEdit;
    public WebElement elementDelete;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract boolean IsProductDetailsPage();

    public abstract ProductEditionForm goToEditProduct();

    public abstract HomeProductPage goToDeleteProduct();
}
