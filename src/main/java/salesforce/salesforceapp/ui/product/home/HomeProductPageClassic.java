package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;

/**
 * Created By Marco Mendez.
 */
public class HomeProductPageClassic extends HomeProductPage {

    @FindBy(name = "new")
    WebElement productInput;


    public HomeProductPageClassic() {
        super.newProduct = productInput;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


    @Override
    public ProductEditionFormClassic newProduct() {
        System.out.println("Entrooo a  Classic *******************marcoooo*********");
        newProduct.click();
        return new ProductEditionFormClassic();
    }

    @Override
    public boolean thereIsProduct(String name) {
        return exitElement(name);
    }
}
