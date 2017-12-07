package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.BasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class AccountEditionForm extends BasePage {
    protected WebElement nameField;
    protected WebElement addressField;
    protected WebElement phoneField;
    protected WebElement saveBtn;

    public AccountContentPage saveNewAccount(Account account){

        driverTools.setInputField(nameField, account.getName());
        driverTools.setInputField(addressField, account.getAddress());
        driverTools.setInputField(phoneField, account.getPhone());
        driverTools.clickElement(saveBtn);
        return PageFactory.getAccountContentPage();
    }
}
