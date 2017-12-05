package salesforce.salesforceapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Oz64 on 04/12/2017.
 */
public class HomeLighting extends HomeAbstract {

  protected WebDriverWait wait;

  @FindBy(xpath = ".//*[@id='189:171;a']")
  private WebElement profileBtn;

  @FindBy(xpath = ".//*[@id='113:1652;a']/div[1]/div[1]/div/div[4]/a")
  private WebElement switchBtn;

  @Override
  public HomeAbstract switchSkin() {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(
        By.xpath(".//*[@id='189:171;a']")));
    profileBtn.click();
    switchBtn.click();
    return new HomeClassic();
  }
}
