package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountHomePageLight extends AccountHomePage {

    public AccountHomePageLight() {
        super.newBtn = driver.findElement(By.xpath("//ul[contains(@class, 'forceActionsContainer')]/li[1]"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol[contains(@class, 'slds-breadcrumb')]")));
    }

}
