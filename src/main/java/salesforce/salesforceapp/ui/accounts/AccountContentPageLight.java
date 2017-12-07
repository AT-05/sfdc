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

    public AccountContentPageLight() {
        super.nameText = driver.findElement(By.xpath("//p[contains(@class, 'entityNameTitle')]"));
        super.addressText = driver.findElement(By.xpath("//a[contains(@class, 'uiOutputURL')]"));
        super.deleteBtn = driver.findElement(By.xpath("//ul[contains(@class, 'forceActionsContainer')]/li[3]"));
        super.deleteConfirnBtn = driver.findElement(By.xpath("//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]"));
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
        //wait.until(ExpectedConditions.visibilityOf(message));
        return driverTools.isElementDisplayed(message);
    }
}
