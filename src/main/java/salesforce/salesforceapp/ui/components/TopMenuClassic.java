package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.accounts.AccountHomePageClassic;
import salesforce.salesforceapp.ui.accounts.AccountHomePageLight;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;

public class TopMenuClassic extends TopMenu {
    @FindBy(css = ".oneUserProfileCardTrigger")
    private WebElement userProfile;

    @FindBy(xpath = "//a[contains(@href, 'classic')]")
    private WebElement switchSkinLink;


    private final String lacatorAccounts = "//*[@id='Account_Tab']";


    /**
     * <p>This method performs switching of web page skin
     * to classic.</p>
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.urlContains("home"));
    }

    @Override
    public void switchSkin() {

        userProfile.click();
        switchSkinLink.click();
    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageClassic();
    }

    @Override
    public OppyHomePage goToOppyHomePage() {
        return new OppyHomePageClassic();
    }

    @Override
    public AccountHomePage goToAccountsHomePage() {
        driverTools.clickElement(By.xpath(lacatorAccounts));
        return new AccountHomePageClassic();
    }


}
