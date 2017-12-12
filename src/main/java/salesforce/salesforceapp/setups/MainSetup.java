package com.fundacion.at05ui.sfdc.setups;

import com.fundacion.at05ui.sfdc.excel.XLSAccount;
import org.apache.log4j.Logger;
import com.fundacion.at05ui.core.utils.ExcelReader;

import java.util.List;
import java.util.Map;

import static com.fundacion.at05ui.sfdc.SalesforceConstants.ACCOUNTS;

public class MainSetup {
    private static Logger log = Logger.getLogger("MainSetup");
    private static List<Map<String, String>> accountsXLS;
    private static List<Map<String, String>> oppiesXLS;

    public static void beforeExecution() {
        log.info("Start Main before setup...");

        ExcelReader xlsFile = new ExcelReader("Main.xls");
        accountsXLS = xlsFile.getValues(ACCOUNTS);
        oppiesXLS = xlsFile.getValues(OPPY);
        XLSAccount.createAccounts(accountsXLS);
        XLSOppy.createOppies(oppiesXLS);

    }

    public static void afterExecution() {
        XLSAccount.deleteAccounts(accountsXLS);
        XLSAccount.deleteOppies(oppiesXLS);
    }
}
