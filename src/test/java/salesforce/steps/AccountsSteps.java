package salesforce.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.Oppy;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.accounts.AccountContentPage;
import salesforce.salesforceapp.ui.accounts.AccountEditionForm;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.home.HomePage;

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

    //Entities
    private Oppy oppy;

    public AccountsSteps() throws Exception {
        homePage = PageFactory.getHomePage();
    }


    @And("^I go to Accounts home page$")
    public void iGoToAccountsHomePage()  {
        accountHomePage=homePage.topMenu.goToAccountsHomePage();
    }

    @When("^I create a New Account with the following information:$")
    public void iCreateANewAccountWithTheFollowingInformation() {

        accountHomePage.clickNewAccountBtn();
    }
}
