package salesforce.salesforceapp.ui.contacts;

import salesforce.salesforceapp.entities.Contact;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactEditionFormClassic extends ContactEditionForm {
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }
  @Override
  public ContactContentPage createContact(Contact contact) {
    //sets
    return new ContactContentPageLight();
  }
}
