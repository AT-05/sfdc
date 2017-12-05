package salesforce.salesforceapp.ui.home;

import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageTransporter;

public abstract class HomePage extends HomeBasePage {

  public boolean isInHomePage(){
    System.out.println("========= " + PageTransporter.getInstance().getCurrentURL());
    return (PageTransporter.getInstance().getCurrentURL().contains("home"));
  }

}
