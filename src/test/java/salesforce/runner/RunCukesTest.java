package salesforce.runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import salesforce.salesforceapp.SalesForceAppAutomation;

public class RunCukesTest extends AbstractTestNGCucumberTests {

  private Logger log = Logger.getLogger(getClass());

  /**
   * Starts the execution
   */
  @BeforeTest
  public void beforeExecution() {
    try {
      System.out.println("\n=============== BEFORE TEST ===============\n");
      SalesForceAppAutomation.getInstance().startUp();
    } catch (Exception ex) {
      log.error("Exception in before execution", ex);
    }
  }

  /**
   * Closes the execution
   */
  @AfterTest
  public void afterExecution() {
    try {
      System.out.println("\n=============== AFTER TEST ===============\n");
      SalesForceAppAutomation.getInstance().shutDown();
    } catch (Exception ex) {
      log.error("Exception in after execution", ex);
    }
  }
}
