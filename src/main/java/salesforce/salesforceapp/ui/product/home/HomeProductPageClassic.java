package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import salesforce.salesforceapp.ui.product.create.CreateProductPage;
import salesforce.salesforceapp.ui.product.create.CreateProductPageClassic;

public class HomeProductPageClassic extends HomeProductPage {

    public HomeProductPageClassic() {
        super.newProduct = driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


    @Override
    public CreateProductPageClassic newProduct() {
        System.out.println("Entrooo a  Classic *******************marcoooo*********");
        newProduct.click();
        return new CreateProductPageClassic();
    }
}
