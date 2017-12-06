package salesforce.salesforceapp.ui.accounts;

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

}
