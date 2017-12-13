package salesforce.salesforceapp.ui.contacts;

import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class ContactHomePage extends HomeBasePage {
  public ContactContentPage selectContact(String linkText) {
    selectItem(linkText);
    return PageFactory.getContactContentPage();
  }

  public ContactEditionForm clickNewContactBtn() {
    clickNewBtn();
    return PageFactory.getContacEditionForm();
  }
}
