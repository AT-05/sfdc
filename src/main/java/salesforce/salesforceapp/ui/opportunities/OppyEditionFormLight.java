package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyEditionFormLight extends OppyEditionForm {

  @FindBy(xpath = "//input[@class=' input']")
  private WebElement oppyInput;

  @FindBy(xpath = "//input[@title='Search Accounts']")
  private WebElement accountInput;

  private WebElement accountSelected;

  @FindBy(xpath = "//div[@class='form-element']//input[@class=' input']")
  private WebElement date;

  @FindBy(xpath = "//span[@class='today slds-show--inline-block slds-text-link slds-p-bottom--x-small']")
  private WebElement today;

  @FindBy(xpath = "//div[@class='uiMenu uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//a[@class='select']")
  private WebElement stageInput;

  private WebElement stageOption;

  @FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
  private WebElement saveBtn;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public OppyContentPage createOppy(Oppy oppy) {
    driverTools.setInputField(oppyInput, oppy.getOppyName());

    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, oppy.getAccount());
    String accountElement = String
        .format("//div[@role='listbox']//div[@title='%s']", oppy.getAccount());
    accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);

    driverTools.clickElement(date);
    driverTools.clickElement(today);
    driverTools.setInputField(date, oppy.getCloseDate());

    driverTools.clickElement(stageInput);
    String webElement = String.format("//ul[@class='scrollable']//a[text()='%s']", oppy.getStage());
    stageOption = driver.findElement(By.xpath(webElement));
    driverTools.clickElement(stageOption);

    driverTools.clickElement(saveBtn);

    return new OppyContentPageLight();
  }

  @Override
  public OppyContentPage editOppy(Oppy oppy) {
    driverTools.setInputField(oppyInput, oppy.getOppyName());

    WebElement removeAccount = driver.findElement(By.xpath("//span[@class='deleteIcon']"));
    driverTools.clickElement(removeAccount);
    driverTools.setInputField(accountInput, oppy.getAccount());
    String accountElement = String
        .format("//div[@role='listbox']//div[@title='%s']", oppy.getAccount());
    accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);

    driverTools.clickElement(date);
    driverTools.clickElement(today);
    driverTools.setInputField(date, oppy.getCloseDate());

    driverTools.clickElement(stageInput);
    String webElement = String.format("//ul[@class='scrollable']//a[text()='%s']", oppy.getStage());
    stageOption = driver.findElement(By.xpath(webElement));
    driverTools.clickElement(stageOption);

    driverTools.clickElement(saveBtn);

    return new OppyContentPageLight();
  }
}
