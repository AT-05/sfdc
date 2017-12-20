package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import salesforce.salesforceapp.entities.account.Account;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountHomePageClassic extends AccountHomePage {
  private String locatorNameLink;

  public AccountHomePageClassic() {
    super.newBtn = driver.findElement(By.xpath("//input[contains(@name, 'new')]"));
  }

  /**
   * Go to conten of the account.
   *
   * @param account Entiti of an account.
   * @return New Acount content page.
   */
  @Override
  public AccountContentPage goToAccountContent(Account account) {
    locatorNameLink = "//a[text()='" + account.getName() + "']";
    driverTools.clickElement(By.xpath(locatorNameLink));
    return new AccountContentPageClassic();
  }

  /**
   * Verify is contain on page an account entiti.
   *
   * @param account Account entiti.
   * @return (true/false)
   */
  @Override
  public boolean containTheAccount(Account account) {
    locatorNameLink = "//a[text()='" + account.getName() + "']";
    return driverTools.isElementVisibility(By.xpath(locatorNameLink));
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {
    //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(@class, 'pageType')]")));
  }
}
