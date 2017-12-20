package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;
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

    @FindBy(xpath = ".//*[@id='fcf_pricebook']")
    WebElement elementSelectPriceBook;

    public HomeProductPageClassic() {
        super.newProduct = productInput;
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
    public ProductEditionFormClassic newProduct() {
        newProduct.click();
        return new ProductEditionFormClassic();
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




}
