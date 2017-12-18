package salesforce.salesforceapp.ui.product.home;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormLightning;

/**
 * Created By Marco Mendez.
 */
public class HomeProductPageLightning extends HomeProductPage {

    @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[2]/div/div/div[1]/div[1]/div[2]/ul/li/a")
    WebElement newBtn;


    public HomeProductPageLightning() {
        super.newProduct = newBtn;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Create new Prodcut.
     *
     * @return product edition.
     */
    @Override
    public ProductEditionFormLightning newProduct() {
        System.out.println("Entrooo a  Lightng ****************************");
        newProduct.click();
        return new ProductEditionFormLightning();
    }


    /**
     * Check if exist a product.
     *
     * @param name string.
     * @return boolean.
     */
    @Override
    public boolean thereIsProduct(String name) {
        return exitElement(name);
    }

    /**
     * This Method create go to create new price book page.
     *
     * @param create_new_view selection create price.
     */
    @Override
    public ProductEditionForm goToCreateNewPriceBook(String create_new_view) {
        selectItem(create_new_view);
        return new ProductEditionFormLightning();
    }
}


