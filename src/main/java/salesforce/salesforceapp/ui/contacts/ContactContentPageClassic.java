package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactContentPageClassic extends ContactContentPage {
  @FindBy(id = "con2_ileinner")
  private WebElement nameLabel;

  @FindBy(id = "con10_ileinner")
  private WebElement phoneLabel;

  @FindBy(id = "con4_ileinner")//lookup0011I00000AqF7Jcon4
  private WebElement accountNameLabel;

  @FindBy(id = "con5_ileinner")
  private WebElement titleLabel;

  @FindBy(id = "con6_ileinner")
  private WebElement departmentLabel;


  @FindBy(id = "con8_ileinner")
  private WebElement reportToLabel;

  @FindBy(id = "con19_ilecell")
  private WebElement mailingAddressLabel;

  @FindBy(id = "con10_ileinner")
  private WebElement homePhoneLabel;

  @FindBy(id = "con12_ileinner")
  private WebElement mobileLabel;

  @FindBy(id = "con11_ileinner")
  private WebElement faxLabel;

  @FindBy(xpath = "con15_ileinner")
  private WebElement emailLabel;
  @FindBy(name = "edit")
  private WebElement editBtn;

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
    driverTools.clickElement(editBtn);
    return new ContactEditionFormClassic();
  }

  @Override
  public void clickOnDetails() {

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

  /**
   * This method gets name label.
   *
   * @return a name label.
   */
  public String[] getCompleteName() {
    return nameLabel.getText().split(" ");
  }


  /**
   * This method gets name label.
   *
   * @return a name label.
   */
  public String getTitleLabel() {
    return titleLabel.getText();
  }


  public String getMailingAdressLabel() {
    return mailingAddressLabel.getText();//.split(",")[0];

  }

  /**
   * This method gets mail label.
   *
   * @return a mail street label.
   */
  public String getMailLabel() {
    return emailLabel.getText();
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingState() {
    return mailingAddressLabel.getText().split(",")[2].split(" ")[1];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getNameLabel() {
    return getCompleteName()[0];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getLastNameLabel() {
    return getCompleteName()[1];

  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingZip() {
    return mailingAddressLabel.getText().split(",")[2].split(" ")[2];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingCountry() {
    return mailingAddressLabel.getText().split(",")[2].split(" ")[3];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingCity() {
    return mailingAddressLabel.getText().split(",")[1].trim();
  }


  /**
   * Click.
   *
   * @return label text.
   */
  public String getPhoneLabel() {
    return phoneLabel.getText();
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getAccountNameLabel() {
    return accountNameLabel.getText();
  }
}
