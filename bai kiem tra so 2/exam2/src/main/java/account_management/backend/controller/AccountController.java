package account_management.backend.controller;

import account_management.backend.model.Account;
import account_management.backend.request.LoginAccountRequest;
import account_management.backend.service.AccountService;

public class AccountController {
    private static final AccountService accountService = new AccountService();


    public static void checkLogin(LoginAccountRequest request) {
        accountService.checkLogin(request);
    }

    public Account findAccountByEmail(String email) {
        return accountService.findAccountByEmail(email);
    }

    public void updateUserName(String email, String useName) {
        accountService.updateUserName(email,useName);
    }
}
