package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

public abstract class HomeProductPage extends BasePage {

    public WebElement newProduct;
    public WebElement selectProduct;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        waitUntilPageObjectIsLoaded();
    }

    public abstract ProductEditionForm newProduct();

    public abstract ProductContentPage selectProduct();
}
