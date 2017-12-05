package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oz64 on 04/12/2017.
 */
public class HomeClassic extends HomeAbstract {

  @FindBy(id = "userNavButton")
  private WebElement navigatorBtn;

  @FindBy(xpath = ".//*[@id='userNav-menuItems']/a[4]")
  private WebElement switchBtn;

  @Override
  public HomeAbstract switchSkin(){
    navigatorBtn.click();
    switchBtn.click();
    return new HomeLighting();
  }
}
