package salesforce.salesforceapp.ui.contacts;

import salesforce.salesforceapp.entities.Contact;
import salesforce.salesforceapp.ui.BasePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class ContactEditionForm extends BasePage {

  //    //In case the method can be used for both skins
//    public ContactContentPage createContact(Contact contact) {
//
//        //set the values
//        return PageFactory.getContactContentPage();
//    }

  //In case the method can be used for both skins
  public abstract ContactContentPage createContact(Contact contact);
  public abstract ContactContentPage editContact(Contact contact);
  public abstract ContactContentPage deleteContact(Contact contact);
}
