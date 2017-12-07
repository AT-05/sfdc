package salesforce.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.entities.Oppy;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.accounts.AccountContentPage;
import salesforce.salesforceapp.ui.accounts.AccountEditionForm;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.accounts.AccountHomePageClassic;
import salesforce.salesforceapp.ui.home.HomePage;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountsSteps {
    private Logger log = Logger.getLogger(getClass());

    //Pages
    private HomePage homePage;
    private AccountHomePage accountHomePage;
    private AccountContentPage accountContentPage;
    private AccountEditionForm accountEditionForm;
    private Account account;

    //Entities

    public AccountsSteps() throws Exception {
        homePage = PageFactory.getHomePage();
    }


    @And("^I go to Accounts home page$")
    public void iGoToAccountsHomePage() {
        accountHomePage = homePage.topMenu.goToAccountsHomePage();
    }

    @When("^I create a New Account with the following information:$")
    public void iCreateANewAccountWithTheFollowingInformation(List<Account> acc) {
        this.account = acc.get(0);
        accountEditionForm = accountHomePage.clickNewAccountBtn();
        accountContentPage = accountEditionForm.saveNewAccount(account);
    }

    @Then("^the message for the Account created is displayed$")
    public void theMessageForTheAccountCreatedIsDisplayed() {
        boolean a = accountContentPage.displayedCreatedMessage();
        assertTrue(a);
    }

    @And("^the Account should be displayed in Accounts page$")
    public void theAccountShouldBeDisplayedInAccountsPage(){
        accountContentPage.verifyIsAccountIsSame(account);
    }



    @Given("^I have Acount with the following information:$")
    public void iHaveAcountWithTheFollowingInformation(List<Account> acc){
        iCreateANewAccountWithTheFollowingInformation(acc);
        //accountContentPage
    }


    @When("^I select the Account$")
    public void iSelectTheAccount()  {
        iGoToAccountsHomePage();
        accountContentPage=accountHomePage.goToAccountContent(account);
    }


    @And("^Delete an Account$")
    public void deleteAnAccount()  {
        accountContentPage.delete();

    }

}
