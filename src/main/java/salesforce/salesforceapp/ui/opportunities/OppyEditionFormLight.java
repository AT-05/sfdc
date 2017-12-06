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

  @FindBy(xpath = "//a[@class='datePicker-openIcon display']")
  private WebElement date;

  @FindBy(xpath = "//div[@class=\"form-element\"]")
  private WebElement stage;

  @FindBy(xpath = ".//span[@class=\"today slds-show--inline-block slds-text-link slds-p-bottom--x-small\"]")
  private WebElement today;





  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public OppyContentPage createOppy(Oppy oppy) {

    boolean B = driverTools.isElementDisplayed(oppyName);
    System.out.println("ELEMENTO APARACE: " + B);
    oppyName.clear();
    oppyName.sendKeys(oppy.getOppyName());

    accountField.click();
    accountSelected.click();

//    date.findElement(By.xpath("//input[@class=' input']")).click();
//    date.findElement(By.xpath("//input[@class=' input']")).click();
//    date.findElement(By.xpath("//input[@class=' input']")).sendKeys(oppy.getCloseDate());

    driverTools.clickElement(date);
    driverTools.clickElement(today);


    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return new OppyContentPageLight();
  }
}
