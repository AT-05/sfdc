package salesforce.hooks;

import static salesforce.core.CoreEnums.FAILED;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import salesforce.core.selenium.WebDriverManager;

public class ScenarioHooks {
    private Logger log = Logger.getLogger(getClass());
    //****************************************************************
    // After Hooks
    //****************************************************************

    /**
     * Takes the screenshot and embeds into the cucumber.json
     *
     * @param scenario
     */
    public void embedScreenshot(Scenario scenario) {
        log.info("Take Screenshot for scenario: " + scenario.getName());

        WebDriver driver = WebDriverManager.getInstance().getWebDriver();
        String parentWindowHandle = "";
        try {
            parentWindowHandle = driver.getWindowHandle();

            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);

                //Take screenshot of each browser window open
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                //Embeds screenshot to cucumber.json
                scenario.embed(screenshot, "image/jpeg");
            }
        } catch (WebDriverException e) {
            log.info("Failed to take a browser screenshot.", e);
        } finally {

            //To switch back to parent window
            driver.switchTo().window(parentWindowHandle);
        }
    }

    @After(order = 1000)        //order by default is 10000, after hooks run the higher first
    public void afterScenarioTakeScreenshot(Scenario scenario) {
        if (scenario.getStatus().equals(FAILED)) {
            embedScreenshot(scenario);
        }
    }
}
