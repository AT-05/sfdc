package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountEditionFormLight extends AccountEditionForm {

    public AccountEditionFormLight() {

        super.nameField = driver.findElement(By.xpath("//input[contains(@class, 'input uiInput uiInputText uiInput--default uiInput--input')]"));
        super.addressField = driver.findElement(By.xpath("//input[contains(@type, 'url')]"));
        super.phoneField = driver.findElement(By.xpath("//input[contains(@type, 'tel')]"));
        super.saveBtn = driver.findElement(By.xpath("//button[contains(@class, 'uiButton--brand uiButton forceActionButton')]"));
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
       // wait.until(ExpectedConditions.visibilityOf(nameField));
    }
}
