package salesforce.steps.products;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.entities.product.Product;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class ProductStep {
    private Logger log = Logger.getLogger(getClass());
    private PageTransporter pageTransporter;
    // Variables
    private final String email = SalesForceAppEnvsConfig.getInstance().getUserName();
    private final String pass = SalesForceAppEnvsConfig.getInstance().getUserPassword();
    //Pages
    private LoginPage loginPage;
    private HomePage homePage;
    public HomeProductPage homeProductPage;
    private ProductEditionForm productEditionForm;
    private ProductContentPage productContentPage;
    private PriceBook priceBook;

    private Product product;

    public ProductStep() throws Exception {
        this.pageTransporter = PageTransporter.getInstance();


    }


    @Given("^I'm logged in Sales Force$")
    public void iMLoggedInSalesForce() {
      /*  if (!pageTransporter.isOnLogin()) {
            loginPage = pageTransporter.navigateToLoginPage();
            homePage = loginPage.login(email, pass);
            return;
        }
*/
        //  homeProductPage = homePage.topMenu.goToHomeProduct();

        if (pageTransporter.isOnLogin()) { //If the user is not logged
            loginPage = new LoginPage();
            final String userName = SalesForceAppEnvsConfig.getInstance().getUserName();
            final String password = SalesForceAppEnvsConfig.getInstance().getUserPassword();
            homePage = loginPage.login(userName, password);
        }
    }

    @And("^I go to Product Home page$")
    public void iGoToProductHomePage() {
        System.out.println("estoy yendo product home");
        homeProductPage = homePage.topMenu.goToHomeProduct();
    }

    @When("^I create a New Product with the following information:$")
    public void iCreateANewProductWithTheFollowingInformation(List<Product> products) {
        productEditionForm = homeProductPage.newProduct();
        product = products.get(0);
        productContentPage = productEditionForm.createProduct(product);
        System.out.println("Product creado correctamente ************");
    }


    @Then("^Product Details Page should be display with the information of the product created$")
    public void productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated() {
        System.out.println("de ida a verificar ************");
        assertTrue(productContentPage.validateProductFields(product));

    }


    @Given("^I have a New Product with the following information:$")

    public void iHaveANewProductWithTheFollowingInformation(List<Product> products) {
        productEditionForm = homeProductPage.newProduct();
        product = products.get(0);
        productContentPage = productEditionForm.createProduct(product);
        homeProductPage = productContentPage.goToHomProductPage();
    }

    @When("^I select the Product$")
    public void iSelectTheProduct() {
        homeProductPage.selectItem(product.getName());
    }

    @And("^I Edit the Product information with the following information:$")
    public void iEditTheProductInformationWithTheFollowingInformation(List<Product> productList) {
        productEditionForm = productContentPage.editProduct();
        product = productList.get(0);
        productContentPage = productEditionForm.editProduct(product);
    }

    @Then("^Product Content Page should be displayed with the information updated$")
    public void productContentPageShouldBeDisplayedWithTheInformationUpdated() {
        productContentPage.validateProductFields(product);
    }

    @And("^I delete the product$")
    public void iDeleteTheProduct() {

        homeProductPage = productContentPage.deleteProduct();


    }

    @Then("^the Product should be removed from the Product List$")
    public void theProductShouldBeRemovedFromTheProductList() throws Throwable {
        assertFalse(homeProductPage.thereIsProduct(product.getName()));
    }


    @And("^I add price book to product$")
    public void iAddPriceBookWithTheFollowingInformation() {
        productContentPage.addPriceBook(priceBook);
        System.out.println("Finished************");
    }

    @Then("^the price book should be add to the product$")
    public void theProductShouldBeAddToThePriceBoo() throws Throwable {
        assertTrue(productContentPage.validatePriceBookAdded(priceBook));
        System.out.println("Finished-------------///////************" + productContentPage.validatePriceBookAdded(priceBook));
    }

    @And("^I have a Price Book wih the following information :$")
    public void iHaveAPriceBookWihTheFollowingInformation(List<PriceBook> priceBookList) {
        System.out.println("**************++++++++++++++++++++++++*22*************");
        productEditionForm = homeProductPage.goToCreateNewPriceBook("Create New View");
        priceBook = priceBookList.get(0);
        productContentPage = productEditionForm.createPriceBook(priceBook);
        homeProductPage = productContentPage.goToHomProductPage();
    }

    @When("^I select the price book$")
    public void iSelectThePriceBook() throws Throwable {
        productContentPage = homeProductPage.selectPriceBook(priceBook);
    }
}
