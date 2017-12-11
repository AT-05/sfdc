package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountEditionFormClassic extends AccountEditionForm {

    public AccountEditionFormClassic() {
        super.nameField = driver.findElement(By.xpath("//input[@id='acc2']"));
        super.addressField = driver.findElement(By.xpath("//textarea[@id='acc17street']"));
        super.phoneField = driver.findElement(By.xpath("//input[@id='acc10']"));
        super.saveBtn = driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[@name='save']"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
