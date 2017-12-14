package salesforce.salesforceapp.excel;

import static salesforce.salesforceapp.SalesforceConstants.ACCOUNT_ADDRESS;
import static salesforce.salesforceapp.SalesforceConstants.ACCOUNT_NAME;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.api.methods.APIAccount;
import salesforce.salesforceapp.entities.Account;

public class XLSAccount {
    private static Logger log = Logger.getLogger("XLSAccount");

    /**
     * Create the accounts by API from excel sheet
     *
     * @param accountsXLS
     */
    public static void createAccounts(List<Map<String, String>> accountsXLS) {
        log.info("Create Accounts");
        for (Map<String, String> accountMap : accountsXLS) {
            Account account = new Account();

//            account.setAccountName(accountMap.get(ACCOUNT_NAME));
//            account.setAddressName(accountMap.get(ACCOUNT_ADDRESS));
            //for all the fields

            if (!APIAccount.isAccountSaved(account)) {
                APIAccount.createAccount(account);
            }
        }
    }

    public static void deleteAccounts(List<Map<String, String>> accountsXLS) {

    }
}
