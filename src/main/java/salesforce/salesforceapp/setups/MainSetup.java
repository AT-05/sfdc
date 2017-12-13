package salesforce.salesforceapp.setups;

import static salesforce.salesforceapp.SalesforceConstants.ACCOUNTS;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.core.utils.ExcelReader;
import salesforce.salesforceapp.excel.XLSAccount;

public class MainSetup {
    private static Logger log = Logger.getLogger("MainSetup");
    private static List<Map<String, String>> accountsXLS;
    private static List<Map<String, String>> oppiesXLS;

    public static void beforeExecution() {
        log.info("Start Main before setup...");

        ExcelReader xlsFile = new ExcelReader("Main.xls");
        accountsXLS = xlsFile.getValues(ACCOUNTS);
        XLSAccount.createAccounts(accountsXLS);

    }

    public static void afterExecution() {
        XLSAccount.deleteAccounts(accountsXLS);
    }
}
