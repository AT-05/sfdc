package salesforce.salesforceapp.ui.accounts;

import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.BasePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class AccountEditionForm extends BasePage {

    /**
     * Create an Acount and save the values.
     *
     * @param account
     * @return
     */
    public abstract AccountContentPage saveNewAccount(Account account);

}
