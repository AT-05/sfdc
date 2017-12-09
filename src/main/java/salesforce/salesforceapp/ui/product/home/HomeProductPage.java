package salesforce.salesforceapp.ui.product.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Product;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

public abstract class HomeProductPage extends BasePage {

    public WebElement newProduct;
    public WebElement selectProduct;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        waitUntilPageObjectIsLoaded();
    }

    public abstract ProductEditionForm newProduct();

    public abstract ProductContentPage selectProduct();

////


       public TopMenu topMenu;

        @FindBy(id = "new")
        @CacheLookup
        WebElement newBtn;


/*  public HomeProductPage() {
            this.topMenu = PageFactory.getTopMenu();
            waitUntilPageObjectIsLoaded();
        }*/



    private By getItemLinkBy(String linkText) {
        System.out.println("----------************//a[contains(text(),'" + linkText + "')]");
        return By.xpath("//a[contains(text(),'" + linkText + "')]");
    }

    public void selectItem(String linkText) {
        System.out.println("esperando para seleccionar producto");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("esperando para seleccionar producto");
        driverTools.clickElement(getItemLinkBy(linkText));
        System.out.println("esperando para seleccionar producto");
    }

    protected void clickNewBtn() {
        driverTools.clickElement(newBtn);
    }
}
