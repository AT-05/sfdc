package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;

/**
 * Created By Marco Mendez.
 */
public class HomeProductPageClassic extends HomeProductPage {

    @FindBy(name = "new")
    WebElement productInput;

    @FindBy(xpath = "//a[contains(text(),'Create New View')]")
    WebElement priceBookLink;

    public HomeProductPageClassic() {
        super.newProduct = productInput;
        super.createPriceBook = createPriceBook;
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
    public ProductEditionFormClassic newProduct() {
        System.out.println("Entrooo a  Classic *******************marcoooo*********");
        newProduct.click();
        return new ProductEditionFormClassic();
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
        System.out.println("entro a buscar create*******************");
        waitUntilPageObjectIsLoaded();
        createPriceBook = priceBookLink.findElements(By.xpath("//a[contains(text(),'Create New View')]")).get(0);
        createPriceBook.click();
        return new ProductEditionFormClassic();
    }


}
