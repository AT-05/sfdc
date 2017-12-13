package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Account;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountEditionFormLight extends AccountEditionForm {

    @FindBy(xpath = "//button[contains(@class, 'uiButton--brand uiButton forceActionButton')]")
    private WebElement saveBtn;

    @FindBy(xpath = "//input[contains(@class, 'input uiInput uiInputText uiInput--default uiInput--input')]")
    private WebElement nameInput;

    @FindBy(xpath = "//a[@class='select' and (@aria-label='Tipo' or @aria-label='Type')]")
    private WebElement typeDropDow;

    @FindBy(xpath = "//input[contains(@type, 'url')]")
    private WebElement webInput;

    @FindBy(xpath = "//textarea[@class=' textarea']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[contains(@type, 'tel')]")
    private WebElement phoneInput;

    @FindBy(xpath = "//a[@class='select' and @aria-label='Sector']")
    private WebElement sectorDropDow;

    @FindBy(xpath = "//input[@step='1']")
    private WebElement employeesInput;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        // wait.until(ExpectedConditions.visibilityOf(nameInput));
    }

    /**
     * Create an Acount and save the values.
     *
     * @param account
     * @return
     */
    @Override
    public AccountContentPage saveNewAccount(Account account) {
        driverTools.setInputField(nameInput, account.getName());
        setDropDowField(typeDropDow, account.getType());
        driverTools.setInputField(webInput, account.getWeb());
        driverTools.setInputField(descriptionInput, account.getDescription());
        driverTools.setInputField(phoneInput, account.getPhone());
        driverTools.setInputField(employeesInput, account.getEmployees());
        setDropDowField(sectorDropDow, account.getSector());
        driverTools.clickElement(saveBtn);
        return new AccountContentPageLight();

    }

    /**
     * Select with value on a drop dow field.
     *
     * @param dropDowField Web elemente.
     * @param value        value of the selecction.
     */
    private void setDropDowField(WebElement dropDowField, String value) {
        driverTools.clickElement(dropDowField);
        driverTools.clickElement(By.xpath("//li[contains(@class, 'uiMenuItem uiRadioMenuItem')]/a[@title='" + value + "']"));

    }
}
