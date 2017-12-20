package salesforce.salesforceapp.ui.accounts;

import salesforce.salesforceapp.entities.account.Account;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class AccountHomePage extends HomeBasePage {

  /**
   * Click on new aconut botton.
   *
   * @return new edition form.
   */
  public AccountEditionForm clickNewAccountBtn() {
    clickNewBtnBy();
    return PageFactory.getAccountEditionForm();
  }

  /**
   * Go to conten of the account.
   *
   * @param account Entiti of an account.
   * @return New Acount content page.
   */
  public abstract AccountContentPage goToAccountContent(Account account);

  /**
   * Verify is contain on page an account entiti.
   *
   * @param account Account entiti.
   * @return (true/false)
   */
  public abstract boolean containTheAccount(Account account);



}
