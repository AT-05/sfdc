package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import salesforce.salesforceapp.entities.Account;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountEditionFormClassic extends AccountEditionForm {
    @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//input[@id='acc2']")
    private WebElement nameInput;

    @FindBy(xpath = "//select[@id='acc6']")
    private WebElement typeDropDow;

    @FindBy(xpath = "//input[@id='acc12']")
    private WebElement webInput;

    @FindBy(xpath = "//textarea[@id='acc20']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@id='acc10']")
    private WebElement phoneInput;

    @FindBy(id = "acc7")
    private WebElement sectorDropDow;

    @FindBy(id = "acc15")
    private WebElement employeesInput;



    public AccountEditionFormClassic() {

    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

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
        return new AccountContentPageClassic();
    }

    private void setDropDowField(WebElement typeDropDow, String type) {
        Select stageDropDown = new Select(typeDropDow);
        stageDropDown.selectByVisibleText(type);
    }
}
