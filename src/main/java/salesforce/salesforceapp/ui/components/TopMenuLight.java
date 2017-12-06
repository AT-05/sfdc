package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.accounts.AccountHomePageLight;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;

public class TopMenuLight extends TopMenu {
    @FindBy(xpath = "//*[@id=\"userNavLabel\"]")
    private WebElement userProfile;

    @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[4]")
    private WebElement switchSkinLink;

    private final String lacatorAccounts = "//a[contains(@class, 'slds-context-bar__label-action') and contains(@href, 'Account')]";


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
    public AccountHomePage goToAccountsHomePage() {
        driverTools.clickElement(By.xpath(lacatorAccounts));
        return new AccountHomePageLight();
    }


}
