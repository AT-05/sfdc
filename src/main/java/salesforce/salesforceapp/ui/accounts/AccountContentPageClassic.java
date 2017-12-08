package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountContentPageClassic extends AccountContentPage {

    public AccountContentPageClassic() {
        super.nameText = driver.findElement(By.xpath(""));
        super.addressText = driver.findElement(By.xpath(""));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /***
     * In this skin dont have the message
     * @return
     */
    @Override
    public boolean displayedCreatedMessage() {
        return true;
    }

    @Override
    public void delete() {

    }

}
