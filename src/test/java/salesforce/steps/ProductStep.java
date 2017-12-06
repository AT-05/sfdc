package salesforce.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.entities.Oppy;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.product.create.CreateProductPage;
import salesforce.salesforceapp.ui.product.detail.ProductDetailsPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.detail.ProductDetailPageClassic;

import static org.testng.Assert.assertTrue;

public class ProductStep {
    private Logger log = Logger.getLogger(getClass());
    private PageTransporter pageTransporter;
    // Variables
    private final String email = SalesForceAppEnvsConfig.getInstance().getUserName();
    private final String pass = SalesForceAppEnvsConfig.getInstance().getUserPassword();
    //Pages
    private LoginPage loginPage;
    private HomePage homePage;
    private OppyHomePage oppyHomePage;
    private OppyContentPage oppyContentPage;
    private OppyEditionForm oppyEditionForm;

    private HomeProductPage homeProduct;
    private CreateProductPage createProductPage;
    private ProductDetailsPage productDetail;

    //Entities
    private Oppy oppy;

    public ProductStep() throws Exception {
        this.pageTransporter = PageTransporter.getInstance();
    }


    @Given("^I'm logged in Sales Force$")
    public void iMLoggedInSalesForce() {
        loginPage = pageTransporter.navigateToLoginPage();
        homePage = loginPage.login(email, pass);
    }

    @And("^I go to Product Home page$")
    public void iGoToProductHomePage() {
        homeProduct = homePage.topMenu.goToHomeProduct();
    }

   /* @When("^I create a New Product with the following information:$")
    public void iCreateANewProductWithTheFollowingInformation(List<CreateProductEntity> entity) {
        createProductPage = homeProduct.newProduct();
        productDetail = createProductPage.createProduct(entity);
    }*/

    @When("^I create a New Product with the following information:$")
    public void iCreateANewProductWithTheFollowingInformation() {
        createProductPage = homeProduct.newProduct();
        productDetail = createProductPage.createProduct();
    }

    @Then("^Product Details Page should be display with the information of the product created$")
    public void productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated() {
        assertTrue(productDetail.IsProductDetailsPage());
    }


}
