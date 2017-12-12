package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class AccountEditionForm extends BasePage {




    public abstract AccountContentPage saveNewAccount(Account account);

}
