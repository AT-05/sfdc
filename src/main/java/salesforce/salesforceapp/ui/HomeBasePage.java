package salesforce.salesforceapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

public abstract class HomeBasePage extends BasePage {

    public TopMenu topMenu;

  @FindBy(xpath = ".//*[@title='New']")
  @CacheLookup
  protected WebElement newBtn;

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
        return By.xpath("//a[contains(text(),'" + linkText + "')]");
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
     * Click new Product btn.
     */
    protected void clickNewBtn() {
  protected void clickNewBtn() {
        driverTools.clickElement(newBtn);
    driverTools.jsClickClassButton(newButton);
    }




}
