package salesforce.steps.products;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import salesforce.salesforceapp.entities.product.PriceBook;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.product.content.ProductContentPage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class priceBookSteps {
    public HomeProductPage homeProductPage;
    private ProductEditionForm productEditionForm;
    private ProductContentPage productContentPage;
    private PriceBook priceBook;

    public priceBookSteps() {
        homeProductPage = PageFactory.getProductHomePage();
    }


    @And("^I select Price Books option$")
    public void iSelectPriceBookOption() {
        System.out.println("**************++++++++++++++++++++++++**************");
        productEditionForm = homeProductPage.goToCreateNewPriceBook("Create New View");
    }

    @And("^I create new Price with the following information:$")
    public void iCreateNewPriceWithTheFollowingInformation(List<PriceBook> priceBookList) {
        System.out.println("**************++++++++++++++++++++++++*22*************");
        priceBook=priceBookList.get(0);
        productContentPage = productEditionForm.createPriceBook(priceBook);
    }

    @Then("^the new price book should be int Price books list$")
    public void theNewPriceBookShouldBeIntPriceBooksList() {
       assertTrue( productContentPage.validatePriceBookCreated(priceBook));
    }
}
