package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;

public abstract class ContentBasePage extends BasePage {

  public TopMenu topMenu;

  @FindBy(xpath = "//div[@title='Edit'] | //input[@title='Edit']")
  @CacheLookup
  protected WebElement editBtn;

  @FindBy(xpath = "//div[@title='Delete'] | //input[@title='Delete']")
  @CacheLookup
  protected WebElement deleteBtn;


  public ContentBasePage() {
    this.topMenu = PageFactory.getTopMenu();
    waitUntilPageObjectIsLoaded();
  }

  public OppyEditionForm clickEditOppyBtn() {
    driverTools.clickElement(editBtn);
    return PageFactory.getOppyEditionForm();
  }
}