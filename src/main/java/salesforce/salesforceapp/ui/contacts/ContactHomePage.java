package salesforce.salesforceapp.ui.contacts;

import salesforce.salesforceapp.entities.contact.Contact;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class ContactHomePage extends HomeBasePage {
  public abstract ContactContentPage selectContact(String text);
  public abstract boolean containContact(Contact contact);
  public ContactEditionForm clickNewContactBtn() {
    clickNewBtn();
    return PageFactory.getContacEditionForm();
  }
}
