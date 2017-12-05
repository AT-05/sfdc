package salesforce.steps;

import cucumber.api.java.en.And;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.Oppy;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountsSteps {
    private Logger log = Logger.getLogger(getClass());

    //Pages
    private HomePage homePage;
    private OppyHomePage oppyHomePage;
    private OppyContentPage oppyContentPage;
    private OppyEditionForm oppyEditionForm;

    //Entities
    private Oppy oppy;

    public AccountsSteps() throws Exception {
        homePage = PageFactory.getHomePage();
    }




    @And("^I go to Accounts home page$")
    public void iGoToAccountsHomePage()  {
        homePage.topMenu.goToAccountsHomePage();
    }
}
