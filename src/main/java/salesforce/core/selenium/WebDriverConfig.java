package salesforce.core.selenium;

import org.apache.log4j.Logger;
import salesforce.core.utils.JsonReader;

public class WebDriverConfig {
    private Logger log = Logger.getLogger(getClass());

    private static final String BROWSER = "browser";
    private static final String DRIVER = "web driver";
    private static final String IMPLICIT_WAIT_TIME = "implicit wait time";
    private static final String EXPLICIT_WAIT_TIME = "explicit wait time";
    private static final String WAIT_SLEEP_TIME = "wait sleep time";

    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;

    private static WebDriverConfig instance;

    public static WebDriverConfig getInstance() {
        if(instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    public void initialize(String webDriverConfigFilename) {
        log.info("WebDriverConfig initialize: Read the driver configuration settings");
        JsonReader configReader = new JsonReader(webDriverConfigFilename);

        browser = System.getProperty(BROWSER);  //Get the browser system property
        log.info("Browser name --> " + browser);
        implicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, IMPLICIT_WAIT_TIME));
        explicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, EXPLICIT_WAIT_TIME));
        waitSleepTime = Integer.valueOf(configReader.getKeyValue(DRIVER, WAIT_SLEEP_TIME));
    }

    /**
     *
     * @return
     */
    public String getBrowser() {
        return browser;
    }

    /**
     *
     * @return
     */
    public int getImplicitWaitTime() {
        return  implicitWaitTime;
    }

    /**
     *
     * @return
     */
    public int getExplicitWaitTime() {
        return  explicitWaitTime;
    }

    /**
     *
     * @return
     */
    public int getWaitSleepTime() {
        return  waitSleepTime;
    }
}
