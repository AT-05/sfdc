package salesforce.salesforceapp.excel;

import org.apache.log4j.Logger;
import salesforce.salesforceapp.SalesforceConstants;
import salesforce.salesforceapp.api.methods.APIContact;
import salesforce.salesforceapp.entities.contact.Contact;

import java.util.List;
import java.util.Map;

public class XLSContact {
  private static Logger log = Logger.getLogger("XLSContact");

  /**
   * Create the Contacts by API from excel sheet
   *
   * @param contactsXLS
   */
  public static void createContact(List<Map<String, String>> contactsXLS) {
    log.info("Create Contacts");
    for (Map<String, String> contactMap : contactsXLS) {
      Contact contact = new Contact();
      contact.setName(contactMap.get(SalesforceConstants.CONTACT_NAME));
      contact.setLastName(SalesforceConstants.CONTACT_LAST_NAME);
      contact.setAccountName(SalesforceConstants.CONTACT_ACCOUNT_NAME);
      contact.setTitle(SalesforceConstants.CONTACT_TITLE);
      contact.setEmail(SalesforceConstants.CONTACT_EMAIL);
      contact.setPhone(SalesforceConstants.CONTACT_PHONE);
      contact.setStreet(SalesforceConstants.CONTACT_STREET);
      contact.setCity(SalesforceConstants.CONTACT_CITY);
      contact.setState(SalesforceConstants.CONTACT_STATE);
      contact.setCountry(SalesforceConstants.CONTACT_COUNTRY);

      System.out.println("*** Contact api info ***");
      System.out.println("Contact Name: " + contact.getName());
      System.out.println("Contact Last Name: " + contact.getLastName());
      System.out.println("Contact Account Name: " + contact.getAccountName());
      System.out.println("Contact Title: " + contact.getTitle());
      System.out.println("Contact Email: " + contact.getName());
      System.out.println("Contact Phone: " + contact.getName());
      System.out.println("Contact Street: " + contact.getName());
      System.out.println("Contact City: " + contact.getName());
      System.out.println("Contact State: " + contact.getName());
      System.out.println("Contact Country: " + contact.getName());

      if (!APIContact.isContactSaved(contact)) {
        APIContact.createContact(contact);
      }
    }
  }

  public static void deleteContacts(List<Map<String, String>> contactsXLS) {

  }
}
