package salesforce.salesforceapp.ui.contacts;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactContentPageClassic extends ContactContentPage {
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public String getContactNameText() {
    return null;
  }

  /**
   * Opens the Form page for editing.
   *
   * @return FormBase.
   */
  @Override
  public ContactEditionForm clickEditButton() {
    return null;
  }

  /**
   * Deletes the current Item.
   *
   * @return HomeBase.
   */
  @Override
  public ContactHomePage deleteItem() {
    return null;
  }
}
