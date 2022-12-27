package account_management.frontend;

import account_management.backend.controller.AccountController;
import account_management.backend.exception.NotFoundException;
import account_management.backend.model.Account;
import account_management.backend.request.LoginAccountRequest;

import java.util.Scanner;

public class AccountUI {
    private final AccountController accountController = new AccountController();
    public void run() {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.println("Nhập email");
                    String email = sc.nextLine();
                    System.out.println("Nhập password");
                    String password = sc.nextLine();

                    LoginAccountRequest request = new LoginAccountRequest(email,password);

                    try {
                        AccountController.checkLogin(request);
                        System.out.println("\n-------------- ĐĂNG NHẬP THÀNH CÔNG --------------");
                        System.out.printf("Chào mừng %s, bạn có thể thực hiện các công việc sau: \n", accountController.findAccountByEmail(email).getUserName());

                    }catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }



                    break;
                }

                case 2: {
                    break;
                }

                case 3: {
                    break;
                }

                case 4: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Thoát\n");
    }
}
