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

    public abstract boolean displayedCreatedMessage();

    public abstract void delete();

    public abstract AccountEditionForm clickUpdateAccountBtn();

    public abstract void clickOnDetails();

    public boolean containsThisElement(String name) {

        String path=String.format("%s%s%s%s%s","//span[contains(@class,'slds-form-element__static')]//span//a[text()='"
                , name, "'] | //span[contains(@class,'slds-form-element__static')]//span[text()='", name, "']");
        return driverTools.isElementVisibility(By.xpath(path));
    }
}
