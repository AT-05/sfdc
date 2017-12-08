package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;
import salesforce.salesforceapp.ui.product.home.HomeProductPage;
import salesforce.salesforceapp.ui.product.home.HomeProductPageClassic;
import salesforce.salesforceapp.ui.product.home.HomeProductPageLightning;

public class TopMenuLight extends TopMenu {

    ////*******MIoooooooooooooooooo*********


    @FindBy(xpath = "//one-app-launcher-header/button")
    WebElement launcherBtn;


    @FindBy(xpath = "html/body/div[5]/div[2]/div[5]/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[22]/a/span/span")
    WebElement productTab;

    @Override
    public HomeProductPageLightning goToHomeProduct() {
        System.out.println("ir to home product***************");
        waitUntilPageObjectIsLoaded();
        launcherBtn.click();
        waitUntilPageObjectIsLoaded();
        productTab.click();
        System.out.println("ya gui to home product***************");
        return new HomeProductPageLightning();
    }
    ///////////

    @FindBy(xpath = "//*[@id=\"userNavLabel\"]")
    private WebElement userProfile;

    @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[4]")
    private WebElement switchSkinLink;

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
}
