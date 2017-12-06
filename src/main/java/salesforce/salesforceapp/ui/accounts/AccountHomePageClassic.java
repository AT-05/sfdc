package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountHomePageClassic extends AccountHomePage {

    public AccountHomePageClassic() {
        super.newBtn= driver.findElement(By.xpath("//input[contains(@name, 'new')]"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(@class, 'pageType')]")));
    }
}
