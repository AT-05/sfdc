package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.ui.contacts.ContactHomePage;
import salesforce.salesforceapp.ui.contacts.ContactHomePageLight;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;

public class TopMenuLight extends TopMenu {
    @FindBy(className = "slds-icon-waffle")
    private WebElement appLauncherButton;

    @FindBy(xpath = "//*[@id=\"userNavLabel\"]")
    private WebElement userProfile;

    @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[4]")
    private WebElement switchSkinLink;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Contacts']")
    private WebElement contactsTextLink;

    @FindBy(css = ".salesforceIdentityAppLauncherDesktopInternal .uiButton")
    private WebElement openAllAppsButton;

    @FindBy(css = ".modal-header")
    private WebElement windowModal;
    @FindBy(css = "a[href*='Contact']")
    private WebElement contactBtn;
    //By.cssSelector("a[href*='Contact']") or driver.findElement(By.linkText("App Configuration")).click();



    /**
     * Waits for the modal is displayed.
     */
    private void waitModal() {
        driverTools.isElementDisplayed(windowModal);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.urlContains("home"));
    }

    @Override
    public void switchSkin() {
        System.out.println("******user profile of light********");
        userProfile.click();
        switchSkinLink.click();
    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }

    @Override
    public OppyHomePage goToOppyHomePage() {
        return new OppyHomePageLight();
    }

    @Override
    public ContactHomePage goToContactHomePage() {
       // waitModal();
        //driverTools.clickElement(openAllAppsButton);
        driverTools.clickElement(contactBtn);
        //wait.until(ExpectedConditions.visibilityOf(openAllAppsButton));
        //openAllAppsButton.click();

        return new ContactHomePageLight();
    }


}
