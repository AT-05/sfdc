package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountContentPageClassic extends AccountContentPage {


    @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='delete']")
    private WebElement deleteBtn;
//
//    @FindBy(xpath = "//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]")
//    private WebElement deleteConfirnBtn;
//
    @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='edit']")
    private WebElement updateBtn;


    public AccountContentPageClassic() {
        super.nameText = driver.findElement(By.xpath("//*[@id='acc2_ileinner']"));
        super.addressText = driver.findElement(By.xpath("//*[@id='acc17_ileinner']"));
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
      driverTools.clickElement(deleteBtn);
        Alert alert = driver.switchTo().alert();
        alert.accept();
//        driverTools.clickElement(deleteConfirnBtn);
    }

    @Override
    public AccountEditionForm clickUpdateAccountBtn() {
        driverTools.clickElement(updateBtn);
        return PageFactory.getAccountEditionForm();
    }

    @Override
    public void clickOnDetails() {

    }

}
