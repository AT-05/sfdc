package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPageClassic;

public class ProductContentPageClassic extends ProductContentPage {
    public static final String PRODUCT_DETAIL = "Product Detail";
    @FindBy(xpath = ".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2")
    private WebElement validator;

    @FindBy(name = "edit")
    private WebElement edit;

    @FindBy(name = "del")
    private WebElement delete;

    public ProductContentPageClassic() {
        super.elementValidator = validator;
        super.elementEdit = edit;
        super.elementDelete = delete;
    }

    @Override
    public boolean IsProductDetailsPage() {
        return elementValidator.getText().equalsIgnoreCase(PRODUCT_DETAIL);
    }

    @Override
    public ProductEditionForm goToEditProduct() {
        elementEdit.click();
        return new ProductEditionFormClassic();
    }

    @Override
    public HomeProductPage goToDeleteProduct() {
        elementDelete.click();
        checkAlert();
        return new HomeProductPageClassic();
    }


}
