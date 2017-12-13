package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by AT05 team on 12/11/2017.
 */
public class ProfilePageClassic extends ProfilePage {
  @FindBy(xpath = "//div[@class='profileSectionData emailAddr']")
  @CacheLookup
  private WebElement userEmailLabel;

  /**
   * <p>This constructor initializes web elements.</p>
   */
  public ProfilePageClassic() {
    super.userEmailLabel = userEmailLabel;
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.urlContains("userprofile"));
  }
}
