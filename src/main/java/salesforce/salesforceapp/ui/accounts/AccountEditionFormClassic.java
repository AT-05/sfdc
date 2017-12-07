package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountEditionFormClassic extends AccountEditionForm {

    public AccountEditionFormClassic() {
        super.nameField = driver.findElement(By.xpath("//input[contains(@name, 'name')]"));
        super.addressField = driver.findElement(By.xpath("//input[contains(@name, 'addres')]"));
        super.phoneField = driver.findElement(By.xpath("//input[contains(@name, 'home')]"));
        super.saveBtn = driver.findElement(By.xpath("//input[contains(@name, 'save')]"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
