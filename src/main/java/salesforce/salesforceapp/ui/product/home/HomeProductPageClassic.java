package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;

public class HomeProductPageClassic extends HomeProductPage {

    @FindBy(name = "new")
    WebElement productInput;

    @FindBy(xpath = ".//*[@id='bodyCell']/div[6]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
    WebElement productSelect;

    public HomeProductPageClassic() {
        super.newProduct = productInput;//driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
        super.selectProduct = productSelect;
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
    public ProductContentPageClassic selectProduct() {
        selectProduct.click();
        return new ProductContentPageClassic();
    }
}
