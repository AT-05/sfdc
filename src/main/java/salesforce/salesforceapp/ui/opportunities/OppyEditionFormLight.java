package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyEditionFormLight extends OppyEditionForm {

  @FindBy(xpath = "//input[@class=' input']")
  private WebElement oppyName;

  @FindBy(xpath = "//input[@title='Search Accounts']")
  private WebElement accountField;

  @FindBy(xpath = "//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
  private WebElement accountSelected;

  //@FindBy(xpath = "//a[@class='datePicker-openIcon display']")
  @FindBy(xpath = "//div[@class='form-element']")
  private WebElement date;

  @FindBy(xpath = "//span[@class='today slds-show--inline-block slds-text-link slds-p-bottom--x-small']")
  private WebElement today;

  @FindBy(xpath = "//div[@class='uiMenu uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//a[@class='select']")
  private WebElement stageField;

  private WebElement stageOption;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public OppyContentPage createOppy(Oppy oppy) {
    oppyName.clear();
    oppyName.sendKeys(oppy.getOppyName());

    driverTools.clickElement(accountField);
    driverTools.clickElement(accountSelected);

    driverTools.clickElement(date);
    driverTools.clickElement(today);

    driverTools.clickElement(stageField);
    String webElement = String.format("//ul[@class='scrollable']//a[text()='%s']", oppy.getStage());
    stageOption = driver.findElement(By.xpath(webElement));
    driverTools.clickElement(stageOption);


    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return new OppyContentPageLight();
  }
}
