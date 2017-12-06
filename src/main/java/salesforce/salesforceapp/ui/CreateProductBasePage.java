package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;

public abstract class CreateProductBasePage extends BasePage {

    public WebElement productName;
    public WebElement productCode;
    public WebElement productDescription;
    public WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

}
