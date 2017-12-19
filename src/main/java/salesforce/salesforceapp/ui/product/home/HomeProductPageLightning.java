package salesforce.salesforceapp.ui.product.home;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
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
        System.out.println("CLick launcher 1");
        try {
            Thread.sleep(30000);
            System.out.println("CLick launcher 2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait=new WebDriverWait(driver,30);
        waitUntilPageObjectIsLoaded();
        launcherBtn.click();

        System.out.println("CLick launcher 2");
        wait=new WebDriverWait(driver,30);
        waitUntilPageObjectIsLoaded();
        priceBookTab= driver.findElements(By.xpath("//span[text()='Price Books']")).get(0);
        priceBookTab.click();

        System.out.println("CLick launcher 3");
        wait=new WebDriverWait(driver,30);
        waitUntilPageObjectIsLoaded();
        newProduct.click();
        System.out.println("CLick launcher 4");
        return new ProductEditionFormLightning();
    }

    @Override
    public ProductContentPage selectPriceBook(PriceBook priceBook) {
        return null;
    }


    @FindBy(xpath = "//one-app-launcher-header/button")
    WebElement launcherBtn;

    @FindBy(xpath = "//span[text()='Price Books']")
    WebElement priceBookTab;
}


