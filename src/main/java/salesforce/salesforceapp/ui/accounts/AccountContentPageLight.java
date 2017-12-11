package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountContentPageLight extends AccountContentPage {
    @FindBy(xpath = "//div[contains(@class, 'slds-notify--toast forceToastMessage')]")
    private WebElement message;

    @FindBy(xpath = "//ul[contains(@class, 'forceActionsContainer')]/li[3]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]")
    private WebElement deleteConfirnBtn;

    @FindBy(xpath = "//div[contains(@class, 'slds-truncate') and (contains(@title, 'Modificar') or contains(@title, 'Modify'))]")
    private WebElement updateBtn;



    public AccountContentPageLight() {
        super.nameText = driver.findElement(By.xpath("//h1[contains(@class, 'slds-page-header__title slds-m-right--small')]/span[contains(@class, 'uiOutputText')]"));
        super.addressText = driver.findElement(By.xpath("//a[contains(@class, 'uiOutputURL')]"));
//        super.updateBtn=driver.findElement(By.xpath("//div[contains(@class, 'slds-truncate') and (contains(@title, 'Modificar') or contains(@title, 'Modify'))]"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Verify is displayed the message.
     * @return
     */
    @Override
    public boolean displayedCreatedMessage() {
        return driverTools.isElementDisplayed(message);
    }

    @Override
    public void delete() {
        driverTools.clickElement(deleteBtn);
        driverTools.clickElement(deleteConfirnBtn);
    }

    @Override
    public AccountEditionForm clickUpdateAccountBtn(){
        driverTools.clickElement(updateBtn);
        return PageFactory.getAccountEditionForm();
    }
}
