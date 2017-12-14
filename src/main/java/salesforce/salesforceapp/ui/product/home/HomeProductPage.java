package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

/**
 * Created By Marco Mendez.
 */
public abstract class HomeProductPage extends BasePage {

    public WebElement newProduct;

    public TopMenu topMenu;

    @FindBy(id = "new")
    @CacheLookup
    WebElement newBtn;

    /**
     * Check if exist an WebElement.
     *
     * @param name string.
     * @return boolean.
     */
    public boolean exitElement(String name) {
        boolean present;
        try {
            wait = new WebDriverWait(driver, 30);
            selectItem(name);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        return present;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        waitUntilPageObjectIsLoaded();
    }

    /**
     * Create new Prodcut.
     *
     * @return product edition.
     */
    public abstract ProductEditionForm newProduct();

    /**
     * Get Item link.
     *
     * @param linkText string.
     * @return by.
     */
    private By getItemLinkBy(String linkText) {
        return By.xpath("//a[contains(text(),'" + linkText + "')]");
    }

    /**
     * Select a Product Item.
     *
     * @param linkText string.
     */
    public void selectItem(String linkText) {
        driverTools.clickElement(getItemLinkBy(linkText));
    }

    /**
     * Click New product.
     */
    protected void clickNewBtn() {
        driverTools.clickElement(newBtn);
    }

    /**
     * Check if exist a product.
     *
     * @param name string.
     * @return boolean.
     */
    public abstract boolean thereIsProduct(String name);
}

