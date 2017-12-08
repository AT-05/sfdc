package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.ContentBasePage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;


public abstract class ProductContentPage extends BasePage {

    public WebElement elementValidator;
    public WebElement elementEdit;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract boolean IsProductDetailsPage();

    public abstract void goToEditProduct();

}
