package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormLightning;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPageLightning;

public class ProductContentPageLightning extends ProductContentPage {


    @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[3]/div/div/div[1]/div/header/div[2]/ul/li[1]/p[1]")
    private WebElement validator;

    @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[3]/div/div/div[1]/div/header/div[2]/div/div[2]/ul/li[1]/a")
    private WebElement edit;

    @FindBy(name = "del")
    private WebElement delete;

    public static final String PRODUCT_DETAIL = "Product Code";

    public ProductContentPageLightning() {
        super.elementValidator = validator;
        super.elementEdit = edit;
    }

    @Override
    public boolean IsProductDetailsPage() {
        return elementValidator.getText().equalsIgnoreCase(PRODUCT_DETAIL);
    }

    @Override
    public ProductEditionForm goToEditProduct() {
        elementEdit.click();
        return new ProductEditionFormLightning();
    }

    @Override
    public HomeProductPage goToDeleteProduct() {
        elementDelete.click();
        checkAlert();
        return new HomeProductPageLightning();
    }
}
