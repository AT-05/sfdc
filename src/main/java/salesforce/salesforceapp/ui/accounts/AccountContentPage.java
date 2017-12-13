package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.ContentBasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class AccountContentPage extends ContentBasePage {

    protected WebElement nameText;
    protected WebElement addressText;

    /**
     * Verify is show the message after of create an Acoount.
     * @return (true/false)
     */
    public abstract boolean displayedCreatedMessage();

    /**
     * Clik on delete option.
     */
    public abstract void delete();

    /**
     * Click on uptdate acount option.
     * @return new form account edition.
     */
    public abstract AccountEditionForm clickUpdateAccountBtn();

    /**
     * Clik on details of the Accounts.
     */
    public abstract void clickOnDetails();

    /**
     * Verify is contain on page a element with name.
     * @param name Option for the search en the page
     * @return (true/false) of the search.
     */
    public abstract boolean containsThisElement(String name);

    /**
     * Verify is show the message after of delete an Acoount.
     * @return (true/false)
     */
    public abstract boolean displayedErrorDeleteMessage();

}
