package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.entities.product.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageLightning;

/**
 * Created by Marco Mendez.
 */
public class ProductEditionFormLightning extends ProductEditionForm {

    @FindBy(xpath = "//div/div/div/div/div/div/div/div/input")
    private WebElement elementNameInput;

    @FindBy(xpath = "//div[2]/div/div/div/div/input")
    private WebElement elementCodeInput;

    @FindBy(xpath = "//textarea")
    private WebElement elementDescriptionInput;

    @FindBy(xpath = "//div[2]/div/div/div/input")
    private WebElement elementCheckBox;

    @FindBy(xpath = "//div/button[3]")
    private WebElement elementSaveBtn;


    /////////////////


    @FindBy(xpath = "//div/div/div/div/div/div/div/div/input")
    private WebElement elementNamePrice;

    @FindBy(xpath = "//div[2]/div/div/div/div/input]")
    private WebElement elementUniqueNamePriceBook;

    @FindBy(xpath = "//div[2]/div/div/div/input")
    private WebElement elementUniqueNamePriceBookCheck;

    @FindBy(xpath = "//div/button[3]")
    WebElement elementSavePriceBook;
    ///////////////

    /**
     * Constructor ProductEditionLightning.
     */
    public ProductEditionFormLightning() {
        super.productNameInput = elementNameInput;
        super.productCodeInput = elementCodeInput;
        super.productDescriptionInput = elementDescriptionInput;
        super.activeCheckBox = elementCheckBox;
        super.saveBtn = elementSaveBtn;
    }

    /**
     * Click products data save btn.
     *
     * @return product content.
     */
    private ProductContentPageLightning clickSaveBnt() {
        saveBtn.click();
        return new ProductContentPageLightning();
    }


    /**
     * Create a new product.
     *
     * @param product product.
     * @return ProductContent.
     */
    @Override
    public ProductContentPageLightning createProduct(Product product) {
        waitUntilPageObjectIsLoaded();
        setProductNameInput(product.getName());
        setProductDescriptionInput(product.getDescription());
        setProductCodeInput(product.getCode());
        setActiveCheckBox(product.getActive());
        return clickSaveBnt();
    }

    /**
     * Edit an existing product.
     *
     * @param product product.
     * @return product content.
     */

    @Override
    public ProductContentPageLightning editProduct(Product product) {
        setProductNameInput(product.getName());
        setProductDescriptionInput(product.getDescription());
        setProductCodeInput(product.getCode());
        return clickSaveBnt();
    }

    /**
     * After create a price book go to content page.
     *
     * @param priceBook price book class.
     * @return product content page.
     */
    @Override
    public ProductContentPage createPriceBook(PriceBook priceBook) {

        System.out.println("element name*********");
        elementNamePrice.clear();
        elementNamePrice.sendKeys(priceBook.getName());
        System.out.println("element name********* :" + priceBook.getName());
        elementUniqueNamePriceBook.clear();
        elementUniqueNamePriceBook.sendKeys(priceBook.getUniqueName());
        elementUniqueNamePriceBookCheck.click();
        elementSavePriceBook.click();
        return new ProductContentPageLightning();
    }


}
