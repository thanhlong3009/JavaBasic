package account_management.backend.service;

import account_management.backend.exception.NotFoundException;
import account_management.backend.model.Account;
import account_management.backend.repository.AccountRepository;
import account_management.backend.request.LoginAccountRequest;
import account_management.backend.utils.FileUtils;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository = new AccountRepository();

    List<Account> accounts = accountRepository.findAll();
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
    public void checkLogin(LoginAccountRequest request) {

        if (checkEmailExists(request.getEmail())) {
            for (Account a:accounts) {
                if (a.getEmail().equals(request.getEmail()) && a.getPassword().equals(request.getPassword())) {
                    return;
                }
            }
        }
        throw new NotFoundException("Tài khoản hoặc mật khẩu không chính xác");
    }

    public boolean checkEmailExists(String email) {
        for (Account a: accountRepository.findAll()) {
            if (a.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPasswordExists(String password) {
        for (Account a:getAccounts()) {
            if (a.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Account findAccountByEmail(String email) {
        Account account = new Account();
        for (Account a: getAccounts()) {
            if (a.getEmail().equals(email)) {
                account = a;
            }
        }
        return account;
    }

    public void updateUserName(String email, String useName) {
        Account account = findAccountByEmail(email);
        account.setUserName(useName);
        FileUtils.setDataToFile("accounts.json", accounts);
    }
}
