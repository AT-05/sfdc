package salesforce.salesforceapp.ui.opportunities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.PageFactory;

public class OppyContentPageLight extends OppyContentPage {

  @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
  private WebElement createOppyMessage;

  @FindBy(xpath = "//a[@title='Details']//span[@class='title']")
  private WebElement detailsBtn;

  @FindBy(xpath = "//div[contains(@class,' itemBody')]//span[@class='uiOutputText']")
  private List<WebElement> oppyNameLabel;

  //div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow']//span[@class='uiOutputDate']
  @FindBy(xpath = "//span[@class='uiOutputDate'")
  private List<WebElement> oppyCloseDateLabel;

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

  @Override
  public void clickDetailsOppyBtn() {
    WebElement ele = driver.findElement(By.xpath(".//*[@id='activityPanelContainer']/div[1]/div/ul"));
    Actions actions = new Actions(driver).moveToElement(ele);
    actions.perform();
    driverTools.clickElement(detailsBtn);
  }

  @Override
  public String getOppyName() {
    return oppyNameLabel.get(0).getText();
  }

  @Override
  public String getCloseDate() {
    return oppyCloseDateLabel.get(0).getText();
  }

}
