package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;
import salesforce.salesforceapp.ui.product.content.ProductContentPageLightning;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormLightning;

public class HomeProductPageLightning extends HomeProductPage {

    @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[2]/div/div/div[1]/div[1]/div[2]/ul/li/a")
    WebElement newBtn;


    @FindBy(xpath = "//a[contains(text(),'asas')]")
    WebElement productSelect;

    public HomeProductPageLightning() {
        super.newProduct = newBtn;//driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
        super.selectProduct = productSelect;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


    @Override
    public ProductEditionFormLightning newProduct() {
        System.out.println("Entrooo a  Lightng *******************marcoooo*********");
        newProduct.click();
        return new ProductEditionFormLightning();
    }

    @Override
    public ProductContentPage selectProduct() {

        System.out.println("carajooooooooooooooooooooooo");
        productSelect.click();
        return new ProductContentPageLightning();
    }

    @Override
    public void thereIsProduct(String name) { }
}


