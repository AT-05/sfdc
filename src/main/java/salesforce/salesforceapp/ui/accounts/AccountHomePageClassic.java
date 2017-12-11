package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.Account;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountHomePageClassic extends AccountHomePage {
    private String locatorNameLink;

    public AccountHomePageClassic() {
        super.newBtn= driver.findElement(By.xpath("//input[contains(@name, 'new')]"));
    }

    @Override
    public AccountContentPage goToAccountContent(Account account) {
        locatorNameLink = "//a[text()='"+account.getName()+"']";
        driverTools.clickElement(By.xpath(locatorNameLink));
        return new AccountContentPageClassic();
    }

    @Override
    public boolean containTheAccount(Account account) {
        locatorNameLink = "//a[text()='"+account.getName()+"']";
        return driverTools.isElementVisibility(By.xpath(locatorNameLink));
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(@class, 'pageType')]")));
    }


}
