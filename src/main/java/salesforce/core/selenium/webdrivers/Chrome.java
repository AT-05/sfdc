package salesforce.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Chrome implements IDriver {

    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance().setup();

        //Todo Add more code here
        return new ChromeDriver();
    }
}
