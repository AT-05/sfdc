package salesforce.salesforceapp.ui.opportunities;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.salesforceapp.ui.PageFactory;

public class OppyContentPageClassic extends OppyContentPage {

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * This method return true in this view.
   *
   * @return true.
   */
  @Override
  public boolean displayedCreateMessage() {
    return true;
  }

  /**
   * Made a click over the button delete and confirm.
   *
   * @return OppyContentPage.
   */
  @Override
  public OppyContentPage clickDeleteOppyBtn() {
    List<WebElement> deleteBtns = driver.findElements(By.xpath("//input[@name='del']"));
    driverTools.clickElement(deleteBtns.get(0));
    Alert alert = driver.switchTo().alert();
    alert.accept();
    return PageFactory.getOppyContentPage();
  }

  /**
   * This method in classic view does nothing.
   */
  @Override
  public void clickDetailsOppyBtn() {
  }

  @Override
  public OppyEditionForm clickEditOppyBtn() {
    String xpath = String.format("//input[@name='edit']");
    driverTools.clickElement(By.xpath(xpath));
    return PageFactory.getOppyEditionForm();
  }

  /**
   * Verify if exist some content in details with div type.
   *
   * @param value to find.
   * @return as a boolean.
   */
  @Override
  public boolean containsSpanElement(String value) {
    String xpath = String.format("//table[@class='detailList']//div[contains(text(),'%s')]", value);
    return driverTools.isElementDisplayed(By.xpath(xpath));
  }

  /**
   * Verify if exist some content in details with link type.
   *
   * @param value to find.
   */
  @Override
  public boolean containsLinkElement(String value) {
    String xpath = String.format("//table[@class='detailList']//a[contains(text(),'%s')]", value);
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
    String flag = value.equalsIgnoreCase("true") ? "Checked" : "Not Checked";
    String xpath = String.format("//table[@class='detailList']//img[@alt='%s']", flag);
    return driverTools.isElementDisplayed(By.xpath(xpath));
  }

  /**
   * <p>This method sends to Opportunity Quotes View.</p>
   *
   * @return a OppyQuotesView object type.
   */
  @Override
  public OppyQuotesView goToQuotesView() {
    return new OppyQuotesViewClassic(); //It is not necessary for this skin
  }

  /**
   * This method change the stage of an Opportunity
   *
   * @param stageName as a string.
   */
  @Override
  public OppyContentPage changeStage(String stageName) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("opp11_ileinner")));
    Actions action = new Actions(driver);
    WebElement element = driver.findElement(By.id("opp11_ileinner"));
    action.doubleClick(element).perform();
    WebElement stageSelect = driver.findElement(By.id("opp11"));
    Select stageDropDown = new Select(stageSelect);
    stageDropDown.selectByVisibleText(stageName);
    driverTools.clickElement(By.xpath("//input[@value='OK']"));
    driverTools.clickElement(By.xpath("//*[@id='topButtonRow']/input[@title='Save']"));
    return PageFactory.getOppyContentPage();
  }
}
