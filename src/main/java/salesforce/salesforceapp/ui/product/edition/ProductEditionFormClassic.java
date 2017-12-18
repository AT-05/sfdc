package salesforce.salesforceapp.ui.product.edition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.entities.product.Product;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.content.ProductContentPageClassic;

/**
 * Created by Marco Mendez.
 */
public class ProductEditionFormClassic extends ProductEditionForm {


    @FindBy(id = "Name")
    private WebElement elementNameInput;

    @FindBy(id = "ProductCode")
    private WebElement elementCodeInput;

    @FindBy(id = "Description")
    private WebElement elementDescriptionInput;

    @FindBy(id = "IsActive")
    private WebElement elementCheckBox;

    @FindBy(name = "save")
    private WebElement elementBtn;

    ////

    @FindBy(id = "fname")
    private WebElement elementNamePrice;

    @FindBy(id = "devname")
    private WebElement elementUniqueNamePriceBook;

    @FindBy(name = "save")
    WebElement elementSavePriceBook;

    /**
     * Constructor product form.
     */
    public ProductEditionFormClassic() {
        super.productNameInput = elementNameInput;
        super.productCodeInput = elementCodeInput;
        super.productDescriptionInput = elementDescriptionInput;
        super.saveBtn = elementBtn;
        super.activeCheckBox = elementCheckBox;

        super.namePriceBookInput = elementNamePrice;
        super.uniqueNamePriceBookInput = elementUniqueNamePriceBook;
        super.savePriceBookBnt = elementSavePriceBook;
    }

    /**
     * Click save products data.
     *
     * @return product content.
     */
    private ProductContentPageClassic clickSaveBnt() {
        saveBtn.click();
        return new ProductContentPageClassic();
    }


    /**
     * Create a new product.
     *
     * @param product product.
     * @return ProductContent.
     */
    @Override
    public ProductContentPageClassic createProduct(Product product) {
        setProductNameInput(product.getName());
        setProductCodeInput(product.getCode());
        setProductDescriptionInput(product.getDescription());
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
    public ProductContentPage editProduct(Product product) {
        setProductCodeInput(product.getCode());
        setProductNameInput(product.getName());
        setProductDescriptionInput(product.getDescription());
        setActiveCheckBox(product.getActive());
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
        namePriceBookInput.clear();
        namePriceBookInput.sendKeys(priceBook.getName());
        uniqueNamePriceBookInput.clear();
        uniqueNamePriceBookInput.sendKeys(priceBook.getUniqueName());
        savePriceBookBnt.click();
        return new ProductContentPageClassic();
    }


}
