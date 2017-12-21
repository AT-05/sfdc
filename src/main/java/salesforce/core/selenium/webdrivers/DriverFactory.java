package salesforce.core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;
import salesforce.core.selenium.WebDriverConfig;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";


    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        Map<String, IDriver> strategyBrowser = new HashMap<>();
        strategyBrowser.put(FIREFOX, new FireFox());
        strategyBrowser.put(CHROME, new Chrome());

        return strategyBrowser.get(WebDriverConfig.getInstance().getBrowser().toLowerCase()).initDriver();
    }
}
