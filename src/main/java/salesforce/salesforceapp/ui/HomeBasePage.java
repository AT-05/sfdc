package salesforce.salesforceapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

public abstract class HomeBasePage extends BasePage {

  public TopMenu topMenu;

  @FindBy(xpath = ".//*[@title='New']")
  @CacheLookup
  protected WebElement newBtn;

  public HomeBasePage() {
    this.topMenu = PageFactory.getTopMenu();
    waitUntilPageObjectIsLoaded();
  }

  private By getItemLinkBy(String linkText) {
    return By.xpath("//a[contains(text(),'" + linkText + "')]");
  }

  public void selectItem(String linkText) {
    driverTools.clickElement(getItemLinkBy(linkText));
  }

  protected void clickNewBtn() {
    driverTools.clickElement(newBtn);
  }

}
