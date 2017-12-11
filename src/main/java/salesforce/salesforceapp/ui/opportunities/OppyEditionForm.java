package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.ui.BasePage;

public abstract class OppyEditionForm extends BasePage {

//    //In case the method can be used for both skins
//    public OppyContentPage createOppy(Oppy oppy) {
//
//        //set the values
//        return PageFactory.getOppyContentPage();
//    }

  //In case the method can be used for both skins
  public abstract OppyContentPage createOppy(Oppy oppy);

}

