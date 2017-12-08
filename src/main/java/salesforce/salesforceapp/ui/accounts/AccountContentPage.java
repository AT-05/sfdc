package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.ContentBasePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class AccountContentPage extends ContentBasePage {

    protected WebElement nameText;
    protected WebElement addressText;
//    protected WebElement deleteBtn;
//    protected WebElement deleteConfirnBtn;

    public abstract boolean displayedCreatedMessage();

    public abstract void delete();

    public boolean verifyAccountInfo(Account account) {
        return account.isSame(driverTools.getTextElement(nameText),
                driverTools.getTextElement(addressText));
    }
}
