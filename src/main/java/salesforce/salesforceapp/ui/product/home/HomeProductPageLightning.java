package salesforce.salesforceapp.ui.product.home;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormLightning;

/**
 * Created By Marco Mendez.
 */
public class HomeProductPageLightning extends HomeProductPage {

    @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[2]/div/div/div[1]/div[1]/div[2]/ul/li/a")
    WebElement newBtn;

    /**
     * Go to product page light.
     */
    public HomeProductPageLightning() {
        super.newProduct = newBtn;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Create new Prodcut.
     *
     * @return products edition.
     */
    @Override
    public ProductEditionFormLightning newProduct() {
        System.out.println("Entrooo a  Lightng ****************************");
        newProduct.click();
        return new ProductEditionFormLightning();
    }

    /**
     * Check if exist a products.
     *
     * @param name string.
     * @return boolean.
     */
    @Override
    public boolean thereIsProduct(String name) {
        return exitElement(name);
    }

    @FindBy(xpath = "//one-app-launcher-header/button")
    WebElement launcherBtn;

    @FindBy(xpath = "//span[text()='Price Books']")
    WebElement priceBookTab;
}


