package salesforce.salesforceapp.ui.accounts;

import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class AccountHomePage extends HomeBasePage {


    public AccountEditionForm clickNewAccountBtn() {
        clickNewBtn();
        return PageFactory.getAccountEditionForm();
    }

    public abstract AccountContentPage goToAccountContent(Account account);

    public abstract boolean containTheAccount(Account account);

}
