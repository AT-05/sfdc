package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.entities.product.Product;
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

    @FindBy(className = " checked")
    private WebElement elementCheckBox;

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
        super.activeCheckBox=elementCheckBox;
    }

    /**
     * Search a WebElement as span.
     *
     * @param linkText string.
     * @return BY.
     */
    private By getItemLinkBy(String linkText) {
        return By.xpath("//span[text()='" + linkText + "']");
    }


    /**
     * Check is the product fields are corrects.
     *
     * @param product product.
     * @return boolean.
     */
    @Override
    public boolean validateProductFields(Product product) {
        System.out.println("veriicando ************");
        boolean active = elementCheckBox.getAttribute("Alt").equalsIgnoreCase("True") ? true : false;
        productNameLabel = driver.findElements(getItemLinkBy(product.getName())).get(0);
        productCodeLabel = driver.findElements(getItemLinkBy(product.getCode())).get(0);
        productDescriptionLabel = driver.findElements(getItemLinkBy(product.getDescription())).get(0);
        return productNameLabel.getText().equalsIgnoreCase(product.getName()) == true
                && productCodeLabel.getText().equalsIgnoreCase(product.getCode()) == true
                && productDescriptionLabel.getText().equalsIgnoreCase(product.getDescription()) == true
                && active==product.getActive();
    }

    /**
     * Go to edit existing product.
     *
     * @return ProductEditionForm.
     */
    @Override
    public ProductEditionForm editProduct() {
        this.editBtn.click();
        return new ProductEditionFormLightning();
    }


    /**
     * Delete an existing product.
     *
     * @return Home Product Page.
     */
    @Override
    public HomeProductPage deleteProduct() {
        driverTools.clickElement(this.deleteBtn);
        waitUntilPageObjectIsLoaded();
        driverTools.clickElement(deleteConfirnBtn);
        return new HomeProductPageLightning();
    }


    /**
     * Go to Home Product page.
     *
     * @return Home product page.
     */
    @Override
    public HomeProductPageLightning goToHomProductPage() {
        wait=new WebDriverWait(driver,30);
        waitUntilPageObjectIsLoaded();
        launcherBtn.click();
        waitUntilPageObjectIsLoaded();
        productTab.click();
        return new HomeProductPageLightning();
    }

    @Override
    public boolean validatePriceBookCreated(PriceBook priceBook) {
        return false;
    }

    @Override
    public void addPriceBook(PriceBook priceBook) {

    }

    @Override
    public boolean validatePriceBookAdded(PriceBook priceBook) {
        return false;
    }

    @Override
    public void editPriceBook(PriceBook priceBook) {

    }


}

