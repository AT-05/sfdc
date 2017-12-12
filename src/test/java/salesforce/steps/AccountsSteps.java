package salesforce.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.accounts.AccountContentPage;
import salesforce.salesforceapp.ui.accounts.AccountEditionForm;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.home.HomePage;

import java.util.List;

import static org.junit.Assert.assertFalse;
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
    private Account accountToEdit;

    //Entities

    public AccountsSteps() throws Exception {
        homePage = PageFactory.getHomePage();
    }


    @And("^I go to Accounts home page$")
    public void iGoToAccountsHomePage() {
        accountHomePage = homePage.topMenu.goToAccountsHomePage();
    }

    @When("^I create a New Account with the following information:$")
    public void createANewAccountWithTheFollowingInformation(List<Account> accountList) {
        account = accountList.get(0);
        accountEditionForm = accountHomePage.clickNewAccountBtn();
        accountContentPage = accountEditionForm.saveNewAccount(account);
    }

    @Then("^the message for the Account created is displayed$")
    public void theMessageForTheAccountCreatedIsDisplayed() {
        assertTrue(accountContentPage.displayedCreatedMessage());
    }

    @And("^the Account should be displayed in Accounts page$")
    public void theAccountShouldBeDisplayedInAccountsPage() {
        accountContentPage.clickOnDetails();
        validateAccount(account);
    }

    @Given("^I have an Acount with the following information:$")
    public void iHaveAcountWithTheFollowingInformation(List<Account> accountList) {
        createANewAccountWithTheFollowingInformation(accountList);
        accountContentPage.displayedCreatedMessage();
        //accountContentPage
    }


    @When("^I select the Account$")
    public void iSelectTheAccount() {
        iGoToAccountsHomePage();
        accountContentPage = accountHomePage.goToAccountContent(account);
    }


    @And("^I delete the Account$")
    public void deleteAnAccount() {
        accountContentPage.delete();
    }


    @Then("^I should see the Acount is removed from the Accounts page$")
    public void iShouldSeeTheAcountIsRemovedFromTheAccountsPage() {
        assertFalse(accountHomePage.containTheAccount(account));
    }

    @And("^I edit that Account with the following information:$")
    public void iEditThatAccountWithTheFollowingInformation(List<Account> accountList) {
        accountToEdit = accountList.get(0);
        accountEditionForm = accountContentPage.clickUpdateAccountBtn();
        accountContentPage = accountEditionForm.saveNewAccount(accountToEdit);
        //accountEditionForm = accountHomePage.clickNewAccountBtn();
    }

    @Then("^I should see the Account updated in the Accounts page$")
    public void iShouldSeeTheAccountUpdatedInTheAccountsPage() {
//        assertTrue(accountContentPage.verifyAccountInfo(accountToEdit));
        accountContentPage.clickOnDetails();
        validateAccount(accountToEdit);
    }

    private void validateAccount(Account myAccount){
        assertTrue(accountContentPage.containsThisElement(myAccount.getName()));
        assertTrue(accountContentPage.containsThisElement(myAccount.getDescription()));
        assertTrue(accountContentPage.containsThisElement(myAccount.getEmployees()));
        assertTrue(accountContentPage.containsThisElement(myAccount.getPhone()));
        assertTrue(accountContentPage.containsThisElement(myAccount.getSector()));
        assertTrue(accountContentPage.containsThisElement(myAccount.getType()));
        assertTrue(accountContentPage.containsThisElement(myAccount.getWeb()));
    }
}
