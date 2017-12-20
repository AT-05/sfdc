package salesforce.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class FireFox implements IDriver {

    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();

        //Todo Add more code here
        return new FirefoxDriver();
    }
}
