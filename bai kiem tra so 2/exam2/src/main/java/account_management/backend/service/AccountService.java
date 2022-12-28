package account_management.backend.service;

import account_management.backend.exception.NotFoundException;
import account_management.backend.model.Account;
import account_management.backend.repository.AccountRepository;
import account_management.backend.request.LoginAccountRequest;
import account_management.backend.utils.FileUtils;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountService {
    Scanner sc = new Scanner(System.in);
    private final AccountRepository accountRepository = new AccountRepository();

    List<Account> accounts = accountRepository.findAll();
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
    public void checkLogin(LoginAccountRequest request) {

//        && checkEmailValidiy(request.getEmail())  :   check email hợp lệ
        if (checkEmailExists(request.getEmail()) ) {
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

    public boolean checkEmailValidiy(String email) {
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]{5}+\\.[\\w]{3,}+|[\\w]{5}+\\.[\\w]{3,}\\.[\\w]{2,})$";

        return Pattern.matches(EMAIL_PATTERN, email);
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

    public void updateUserName(String email, String useNameUpdate) {
        Account account = findAccountByEmail(email);
        account.setUserName(useNameUpdate);
        FileUtils.setDataToFile("accounts.json", accounts);
    }

    public void updateEmail(String email, String emailUpdate) {
        Account account = findAccountByEmail(email);
        if (!checkEmailExists(emailUpdate) && checkEmailValidiy(emailUpdate)) {
            account.setEmail(emailUpdate);
            FileUtils.setDataToFile("accounts.json", accounts);
        }
    }

    public void forgotPassword(String email) {
        if (checkEmailExists(email)) {
            Account account = findAccountByEmail(email);
            System.out.println("Nhập mật khẩu bạn muốn thay đổi");
            String updatePassword = sc.nextLine();
            if (checkPassword(updatePassword)){
                account.setPassword(updatePassword);
                FileUtils.setDataToFile("accounts.json", accounts);
                System.out.println("Thay đổi mật khẩu thành công");
            }else {
                System.out.println("Mật khẩu không hợp lệ ");
            }

        }else {
            System.out.println("Không tồn tại tài khoản");
        }

    }

    public boolean checkPassword(String password) {
        String PASSWORD_PATTERN = "[a-z A-Z0-9]{7,15}$";
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public void createAccount(String userName, String email, String password) {
        if (!checkEmailExists(email) && checkEmailValidiy(email) && checkPassword(password)) {
            Account account = new Account();
            account.setUserName(userName);
            account.setPassword(password);
            account.setEmail(email);
            accounts.add(account);
            FileUtils.setDataToFile("accounts.json", accounts);
        }else {
            System.out.println("nhập không hợp lệ");
        }
    }
}
