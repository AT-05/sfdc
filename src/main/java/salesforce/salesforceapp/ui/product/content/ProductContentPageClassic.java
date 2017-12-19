package salesforce.salesforceapp.ui.product.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.entities.product.Product;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.edition.ProductEditionFormClassic;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPageClassic;

import static org.junit.Assert.assertTrue;

/**
 * Created by Marco Mendez.
 */
public class ProductContentPageClassic extends ProductContentPage {


    private static final String PRODUCT_DETAIL = "Product Detail";

    @FindBy(name = "edit")
    private WebElement elementEditBtn;

    @FindBy(name = "del")
    private WebElement elementDeleteBtn;

    @FindBy(id = "Name_ileinner")
    private WebElement elementNameLabel;

    @FindBy(id = "ProductCode_ileinner")
    private WebElement elementCodeLabel;

    @FindBy(id = "Description_ileinner")
    private WebElement elementDescriptionLabel;

    @FindBy(id = "IsActive_chkbox")
    private WebElement elementCheckBox;

    @FindBy(xpath = ".//*[@id='Product2_Tab']/a")
    WebElement productTab;

    @FindBy(xpath = ".//*[@id='Product2_Tab']/a")
    WebElement priceBookdropDown;
    //////////////
    @FindBy(name = "add")
    WebElement addBtn;

    @FindBy(name = "td0_2")
    WebElement standardPriceInput;

    @FindBy(name = "save")
    WebElement saveStandardPriceBtn;

    @FindBy(id = "save_filter_Pricebook2")
    WebElement searchPriceBook;

    @FindBy(id = "ids0")
    WebElement checkPriceBook;

    @FindBy(name = "edit")
    WebElement selectPriceBook;


    @FindBy(id = "td0_8")
    WebElement priceBookValueInput;

    @FindBy(xpath = "")
    WebElement elementPriceBookAdd;
    ///////////////


    /**
     * Constructor Product content page.
     */
    public ProductContentPageClassic() {
        super.editBtn = elementEditBtn;
        super.deleteBtn = elementDeleteBtn;
        super.productNameLabel = elementNameLabel;
        super.productCodeLabel = elementCodeLabel;
        super.productDescriptionLabel = elementDescriptionLabel;
        super.activeCheckBox = elementCheckBox;


    }


    /**
     * Check is the product fields are corrects.
     *
     * @param product product.
     * @return boolean.
     */
    @Override
    public boolean validateProductFields(Product product) {
        boolean active = activeCheckBox.getAttribute("Alt").equalsIgnoreCase("Not checked") ? false : true;
        assertTrue( productNameLabel.getText().equalsIgnoreCase(product.getName().toString()));
        assertTrue( productCodeLabel.getText().equalsIgnoreCase(product.getCode()));
        assertTrue(productDescriptionLabel.getText().equalsIgnoreCase(product.getDescription()));
        return active == product.getActive();
    }

    /**
     * Go to edit existing product.
     *
     * @return ProductEditionForm.
     */
    @Override
    public ProductEditionForm editProduct() {
        editBtn.click();
        return new ProductEditionFormClassic();
    }


    /**
     * Delete an existing product.
     *
     * @return Home Product Page.
     */
    @Override
    public HomeProductPage deleteProduct() {
        deleteBtn.click();
        checkAlert();
        return new HomeProductPageClassic();
    }


    /**
     * Go to Home Product page.
     *
     * @return Home product page.
     */
    @Override
    public HomeProductPage goToHomProductPage() {
        productTab.click();
        return new HomeProductPageClassic();
    }

    @Override
    public boolean validatePriceBookCreated(PriceBook priceBook) {
        //   selectPriceBookDropDown == new Select(priceBookdropDown.findElement(By.id("years")));
        //dropdownYear.selectByValue(year);
        return true;
    }

    @Override
    public void addPriceBook(PriceBook priceBook) {

        addBtn.click();
        //      System.out.println("clicked to btn standard price book");
        waitUntilPageObjectIsLoaded();
        standardPriceInput.sendKeys("0");
        //   System.out.println("put 0 in standard price book");
        saveStandardPriceBtn.click();
        //   System.out.println("Save data of standard price");

        waitUntilPageObjectIsLoaded();
        addBtn.click();
        //   System.out.println("clicked to btn add price book");
        // searchPriceBook.click();
        //  System.out.println("clicked search btn price book");
        checkPriceBook.click();
        //System.out.println("checked first price book red");

        selectPriceBook.click();
        // System.out.println("save price book");
        priceBookValueInput.sendKeys("10");
        //  System.out.println("put value in price book ");
        saveStandardPriceBtn.click();
        //   System.out.println("save data price book");
    }

    @Override
    public boolean validatePriceBookAdded(PriceBook priceBook) {
        elementPriceBookAdd=driver.findElement(By.xpath("//a[contains(text(),'Red')]"));
        return elementPriceBookAdd.getText().trim().equalsIgnoreCase("Red");
    }

    @Override
    public void editPriceBook(PriceBook priceBook) {

    }


}
