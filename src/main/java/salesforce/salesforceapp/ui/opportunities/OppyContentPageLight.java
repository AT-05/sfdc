package salesforce.salesforceapp.ui.opportunities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.PageFactory;

public class OppyContentPageLight extends OppyContentPage {
  @FindBy(xpath = "(//h2[@id='header']/a/span)[5]")
  private WebElement quoteViewLink;

  @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
  private WebElement createOppyMessage;

  @FindBy(xpath = "//a[@title='Details']//span[@class='title']")
  private WebElement detailsBtn;

  @FindBy(xpath = "//div[contains(@class,' itemBody')]//span[@class='uiOutputText']")
  private List<WebElement> oppyNameLabel;

  @FindBy(xpath = "//span[@class='uiOutputDate'")
  private List<WebElement> oppyCloseDateLabel;

  @FindBy(xpath = "//button[contains(@class,' active ')]//span")
  private WebElement confirmStageBtn;

  @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
  private WebElement confirmMessage;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * Verify if display a message after when create an opportunity.
   *
   * @return a boolean.
   */
  @Override
  public boolean displayedCreateMessage() {
    boolean flag = driverTools.isElementDisplayed(createOppyMessage);
    //wait = new WebDriverWait(driver, 2);
    driverTools.waitUntilMessageDisappear(createOppyMessage);
    return flag;
  }

  /**
   * Made a click in delete button and confirm the action.
   *
   * @return OppyContentPage,
   */
  @Override
  public OppyContentPage clickDeleteOppyBtn() {
    driverTools.clickElement(deleteBtn);
    WebElement confirmDelete = driver.findElement(By.xpath("//button[@title='Delete']"));
    driverTools.clickElement(confirmDelete);
    return PageFactory.getOppyContentPage();
  }

  /**
   * This method move and made a click in details tab.
   */
  @Override
  public void clickDetailsOppyBtn() {
    WebElement ele = driver
        .findElement(By.xpath(".//*[@id='activityPanelContainer']/div[1]/div/ul"));
    Actions actions = new Actions(driver).moveToElement(ele);
    actions.perform();
    driverTools.waitUntilAvailable(detailsBtn);
    driverTools.clickElement(detailsBtn);
  }

  /**
   * Verify if exist some content in details with div type.
   *
   * @param value to find.
   * @return as a boolean.
   */
  @Override
  public boolean containsSpanElement(String value) {
    String xpath = String
        .format("//div[contains(@class,'__record-')]//span[contains(text(),'%s')]", value);
    return driverTools.isElementDisplayed(By.xpath(xpath));
  }

  /**
   * Verify if exist some content in details with link type.
   *
   * @param value to find.
   */
  @Override
  public boolean containsLinkElement(String value) {
    String xpath = String
        .format("//div[contains(@class,'__record-')]//a[contains(text(),'%s')]", value);
    return driverTools.isElementDisplayed(By.xpath(xpath));
  }

  /**
   * Verify if exist checkbox is checked.
   *
   * @param value to find.
   * @return as a boolean.
   */
  @Override
  public boolean containsCheckbox(String value) {
    String xpath = String.format("//div[contains(@class,'__record-')]//img[@alt='%s']", value);
    return driverTools.isElementDisplayed(By.xpath(xpath));
  }

  /**
   * <p>This method sends to Opportunity Quotes View.</p>
   *
   * @return a OppyQuotesView object type.
   */
  @Override
  public OppyQuotesView goToQuotesView() {
    Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
    if (capabilities.getBrowserName().equals("chrome")) {
      try {
        ((JavascriptExecutor) driver).executeScript(
          "arguments[0].scrollIntoView(true);", quoteViewLink);
      } catch (Exception e) {

      }
    }
    driverTools.clickElement(quoteViewLink);
    return new OppyQuotesViewLight();
  }

  /**
   * This method change the stage of an Opportunity
   *
   * @param stageName as a string.
   */
  @Override
  public OppyContentPage changeStage(String stageName) {
    String xpath = String.format("//a[@class='tabHeader']//span[contains(text(), '%s')]", stageName);
    WebElement element = driver.findElement(By.xpath(xpath));
    System.out.println("======= Click in: " + stageName);
    driverTools.clickElement(element);
    driverTools.clickElement(confirmStageBtn);
    return new OppyContentPageLight();
  }
}
