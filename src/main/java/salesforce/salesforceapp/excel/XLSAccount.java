package salesforce.salesforceapp.excel;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import salesforce.salesforceapp.api.methods.APIAccount;
import salesforce.salesforceapp.entities.account.Account;

public class XLSAccount {
    private static Logger log = Logger.getLogger("XLSAccount");
    private static String ACCOUNT_NAME;
    public static String ACCOUNT_TYPE;
    public static String ACCOUNT_WEB;
    public static String ACCOUNT_DESCRIPTION;
    public static String ACCOUNT_PHONE;
    public static String ACCOUNT_SECTOR;
    public static String ACCOUNT_EMPLOYEES;

    /**
     * Create the accounts by API from excel sheet
     *
     * @param accountsXLS
     */
    public static void createAccounts(List<Map<String, String>> accountsXLS) {
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

            if (!APIAccount.isAccountSaved(account)) {
                APIAccount.createAccount(account);
            }
        }
    }

    public static void deleteAccounts(List<Map<String, String>> accountsXLS) {

    }
}
