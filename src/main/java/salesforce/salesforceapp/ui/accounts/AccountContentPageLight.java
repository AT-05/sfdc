package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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



    public AccountContentPageLight() {
        super.nameText = driver.findElement(By.xpath("//p[contains(@class, 'entityNameTitle')]"));
        super.addressText = driver.findElement(By.xpath("//a[contains(@class, 'uiOutputURL')]"));
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
//        deleteBtn = driver.findElement(By.xpath("//ul[contains(@class, 'forceActionsContainer')]/li[3]"));
        driverTools.clickElement(deleteBtn);

//        deleteConfirnBtn = driver.findElement(By.xpath("//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]"));
        driverTools.clickElement(deleteConfirnBtn);
    }
}
