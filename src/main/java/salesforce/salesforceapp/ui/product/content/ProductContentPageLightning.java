package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormLightning;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPageLightning;

/**
 * Created by Marco Mendez.
 */
public class ProductContentPageLightning extends ProductContentPage {


    @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[3]/div/div/div[1]/div/header/div[2]/div/div[2]/ul/li[1]/a")
    private WebElement editBtn;

    @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[3]/div/div/div[1]/div/header/div[2]/div/div[2]/ul/li[2]/a/div")
    private WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]")
    private WebElement deleteConfirnBtn;

    @FindBy(xpath = "//one-app-launcher-header/button")
    WebElement launcherBtn;

    @FindBy(xpath = "html/body/div[5]/div[2]/div[5]/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[22]/a/span/span")
    WebElement productTab;

    private WebElement nameLabel;

    private WebElement codeLabel;

    private WebElement descriptionLabel;
    /**
     * Constructor.
     */
    public ProductContentPageLightning() {
        super.editBtn = editBtn;
        super.deleteBtn = deleteBtn;
        super.productNameLabel = nameLabel;
        super.productCodeLabel = codeLabel;
        super.productDescriptionLabel = descriptionLabel;
    }

    /**
     * Search a WebElement as span.
     * @param linkText string.
     * @return BY.
     */
    private By getItemLinkBy(String linkText) {
        return By.xpath("//span[text()='" + linkText + "']");
    }



    @Override
    public ProductEditionForm editProduct() {
        this.editBtn.click();
        return new ProductEditionFormLightning();
    }

    @Override
    public HomeProductPage deleteProduct() {
        driverTools.clickElement(this.deleteBtn);
        waitUntilPageObjectIsLoaded();
        driverTools.clickElement(deleteConfirnBtn);
        return new HomeProductPageLightning();
    }

    @Override
    public HomeProductPageLightning goToHomProductPage() {
        waitUntilPageObjectIsLoaded();
        launcherBtn.click();
        waitUntilPageObjectIsLoaded();
        productTab.click();
        return new HomeProductPageLightning();
    }

    @Override
    public boolean validateProductFields(Product product) {
        productNameLabel = nameLabel.findElements(getItemLinkBy(product.getName())).get(0);
        productCodeLabel = nameLabel.findElements(getItemLinkBy(product.getCode())).get(0);
        productDescriptionLabel = nameLabel.findElements(getItemLinkBy(product.getDescription())).get(0);
        return productNameLabel.getText().equalsIgnoreCase(product.getName()) == true
                && productCodeLabel.getText().equalsIgnoreCase(product.getCode()) == true
                && productDescriptionLabel.getText().equalsIgnoreCase(product.getDescription()) == true;
    }
}

