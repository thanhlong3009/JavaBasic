package account_management.backend.database;

import account_management.backend.model.Account;
import account_management.backend.utils.FileUtils;

import java.util.List;

public class AccountDB {
    public static List<Account> accounts = FileUtils.getDataFromFile("accounts.json");
}
