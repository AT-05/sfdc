package salesforce.salesforceapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.components.TopMenu;

public abstract class HomeBasePage extends BasePage {

  public TopMenu topMenu;

  //@FindBy(xpath = "//*[@title='New']")
  @FindBy(xpath = "//input[@title='New']|//div[@title='New']")
  protected WebElement newBtn;

  private By newBtnBy= By.xpath("//input[@title='New']|//div[@title='New']");

  public HomeBasePage() {
    this.topMenu = PageFactory.getTopMenu();
    //waitUntilPageObjectIsLoaded();
  }


  /**
   * Get an Item Link.
   *
   * @param linkText string.
   * @return By.
   */
  private By getItemLinkBy(String linkText) {
    return By.linkText(linkText);
  }

  /**
   * Select an Item Link.
   *
   * @param linkText string.
   */
  public void selectItem(String linkText) {
    driverTools.clickElement(getItemLinkBy(linkText));
  }

  /**
   * Click new Item btn.
   */
  protected void clickNewBtn() {
    driverTools.clickElement(newBtn);
  }

  /**
      * Click new Item btn.
      */
  protected void clickNewBtnBy() {
    //newBtn = driver.findElement(By.xpath("//input[@title='New']|//div[@title='New']"));
    driverTools.clickElement(newBtnBy);
  }

}
