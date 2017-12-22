package salesforce.salesforceapp.excel;

import salesforce.core.utils.*;
import static salesforce.salesforceapp.SalesforceConstants.*;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.api.methods.APIOppy;
import salesforce.salesforceapp.entities.opportunities.Oppy;

/**
 * Created by Oz64 on 19/12/2017.
 */
public class XLSOppy {
  private static Logger log = Logger.getLogger("XLSOppy");
  private static APIOppy apiOppy;

  /**
   * <p>Create Opportunities by API from excel sheet.</p>
   *
   * @param oppyXLS is the oppy xls file.
   */
  public static void createOppy(List<Map<String, String>> oppyXLS) {
    log.info("Create Oppy");
    for (Map<String, String> oppyMap : oppyXLS) {
      Oppy oppy = new Oppy();
      oppy.setOppyName(oppyMap.get(OPPY_NAME));
      oppy.setCloseDate(DateConverter.convertDateFormat(oppyMap.get(OPPY_CLOSE_DATE)));
      oppy.setStage(oppyMap.get(OPPY_STAGE));
      oppy.setAccount(oppyMap.get(OPPY_ACCOUNT_NAME));
      oppy.setPrivateOppy(Boolean.valueOf(oppyMap.get(OPPY_PRIVATE)));
      oppy.setAmount(Double.valueOf(oppyMap.get(OPPY_AMOUNT)));

      System.out.println("*** oppy api info ***");
      System.out.println("Oppy Name: " + oppy.getOppyName());
      System.out.println("Oppy Close Date: " + oppy.getCloseDate());
      System.out.println("Oppy Stage: " + oppy.getStage());
      System.out.println("Oppy Account Name: " + oppy.getAccount());
      System.out.println("Oppy Private: " + oppy.getPrivateOppy());
      System.out.println("Oppy Amount: " + oppy.getAmount());

      apiOppy = new APIOppy(oppy);
      if (!apiOppy.isSObjectRecordSaved()) {
        System.out.println("*******Creating oppy for setup");
        apiOppy.createSObjectRecord();
      }
    }
  }
}
