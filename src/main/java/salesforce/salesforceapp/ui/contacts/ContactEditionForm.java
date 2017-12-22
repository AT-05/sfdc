package salesforce.salesforceapp.ui.contacts;

import salesforce.salesforceapp.entities.contact.Contact;
import salesforce.salesforceapp.ui.BasePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class ContactEditionForm extends BasePage {

  /**
   * Create an Contact and save the values.
   * @param contact Entity
   * @return ContactContentPage object type
   */
  public abstract ContactContentPage createContact(Contact contact);
  /**
   * Edit an Contact and save the values.
   * @param contact Entity
   * @return ContactContentPage object type
   */
  public abstract ContactContentPage editContact(Contact contact);

  /**
   * Verify is show the error message on create/edit an Contact.
   *
   * @return (true/false)
   */
  public abstract boolean displayedErrorMessage();
}
