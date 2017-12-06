package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;
import salesforce.salesforceapp.ui.product.home.HomeProductPageClassic;

public class TopMenuClassic extends TopMenu {
    @FindBy(css = ".oneUserProfileCardTrigger")
    private WebElement userProfile;

    @FindBy(xpath = "//a[contains(@href, 'classic')]")
    private WebElement switchSkinLink;

    ////*******MIoooooooooooooooooo*********


    @FindBy(xpath = ".//*[@id='Product2_Tab']/a")
    WebElement productTab;

    @Override
    public HomeProductPageClassic goToHomeProduct() {
        productTab.click();
        return new HomeProductPageClassic();
    }
    ///////////


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


}
