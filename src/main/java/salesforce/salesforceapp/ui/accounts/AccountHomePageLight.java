package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.Account;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountHomePageLight extends AccountHomePage {
    private String locatorNameLink;

    public AccountHomePageLight() {
        super.newBtn = driver.findElement(By.xpath("//ul[contains(@class, 'forceActionsContainer')]/li[1]"));

    }

    @Override
    public AccountContentPage goToAccountContent(Account account) {
        locatorNameLink = "//a[contains(@class, 'slds-truncate') and contains(@title, '" + account.getName() + "')]";
        System.out.println("************************************************************************"+locatorNameLink);
        driverTools.clickElement(By.xpath(locatorNameLink));
        return new AccountContentPageLight();
    }

    @Override
    public boolean containTheAccount(Account account) {
        locatorNameLink = "//a[contains(@class, 'slds-truncate') and contains(@title, '" + account.getName() + "')]";
        return driverTools.isElementDisplayed(By.xpath(locatorNameLink));
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol[contains(@class, 'slds-breadcrumb')]")));
    }

}
