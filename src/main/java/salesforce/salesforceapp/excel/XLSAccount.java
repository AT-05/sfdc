package salesforce.salesforceapp.excel;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.account.Account;

import static salesforce.salesforceapp.SalesforceConstants.*;

public class XLSAccount {
    private static Logger log = Logger.getLogger("XLSAccount");

    /**
     * Create the accounts by API from excel sheet
     * @param accountsXLS
     */
    public static void createAccount(List<Map<String, String>> accountsXLS) {
        log.info("Create Accounts");
        for (Map<String, String> accountMap : accountsXLS) {
            Account account = new Account();
            account.setName(accountMap.get(ACCOUNT_NAME));
            account.setType(accountMap.get(ACCOUNT_TYPE));
            account.setWeb(accountMap.get(ACCOUNT_WEB));
            account.setDescription(accountMap.get(ACCOUNT_DESCRIPTION));
            account.setPhone(accountMap.get(ACCOUNT_PHONE));
            account.setSector(accountMap.get(ACCOUNT_SECTOR));
            account.setEmployees(accountMap.get(ACCOUNT_EMPLOYEES));

            System.out.println("*** Account api info ***");
            System.out.println("Account Name: " + account.getName());
            System.out.println("Account Type: " + account.getType());
            System.out.println("Account Web: " + account.getWeb());
            System.out.println("Account Description: " + account.getDescription());
            System.out.println("Account Phone: " + account.getPhone());
            System.out.println("Account Sector: " + account.getSector());
            System.out.println("Account Employees: " + account.getEmployees());

//            if (!APIAccount.isAccountSaved()) {
//                APIAccount.createAccount();
//            }
        }
    }

    public static void deleteAccount(List<Map<String, String>> accountsXLS) {

    }
}
