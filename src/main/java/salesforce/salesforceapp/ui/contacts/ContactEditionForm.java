package salesforce.salesforceapp.ui.contacts;

import salesforce.salesforceapp.entities.Contact;
import salesforce.salesforceapp.ui.BasePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class ContactEditionForm extends BasePage {

  public abstract ContactContentPage createContact(Contact contact);

  public abstract ContactContentPage editContact(Contact contact);
}
