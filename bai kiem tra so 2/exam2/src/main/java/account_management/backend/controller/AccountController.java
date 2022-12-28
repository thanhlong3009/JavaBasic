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

    public void updateUserName(String email, String useNameUpdate) {
        accountService.updateUserName(email,useNameUpdate);
    }

    public void updateEmail(String email, String emailUpdate) {
        accountService.updateEmail(email,emailUpdate);
    }

    public void forgotPassword(String email) {
        accountService.forgotPassword(email);
    }

    public void createAccount(String userName, String email, String password) {
        accountService.createAccount(userName,email,password);
    }
}
