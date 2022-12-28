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

                        int subOption = 0;
                        boolean subIsQuit = false;

                        while (!subIsQuit) {
                            System.out.println("user: " + accountController.findAccountByEmail(email).getUserName());
                            System.out.println("Email: " + accountController.findAccountByEmail(email).getEmail());
                            System.out.println("Password: " + accountController.findAccountByEmail(email).getPassword());
                            showSubMenu();
                            try {
                                System.out.print("Nhập lựa chọn : ");
                                subOption = Integer.parseInt(sc.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Lựa chọn không hợp lệ");
                                continue;
                            }
                            switch (subOption) {
                                case 1: {
                                    System.out.println("Nhập usename bạn muốn thay đổi");
                                    String useNameUpdate = sc.nextLine();

                                    accountController.updateUserName(email,useNameUpdate);
                                    break;
                                }

                                case 2: {
                                    System.out.println("Nhập email muốn thay đổi");
                                    String emailUpdate = sc.nextLine();
                                    accountController.updateEmail(email,emailUpdate);
                                    if (!email.equals(emailUpdate)) {
                                        email = emailUpdate;
                                    }
                                    break;
                                }

                                case 3: {
                                    break;
                                }

                                case 4: {
                                    subIsQuit = true;
                                    System.out.println("Đăng xuất khỏi tài khoản " + accountController.findAccountByEmail(email).getUserName());
                                    break;
                                }

                                case 5: {
                                    subIsQuit = true;
                                    isQuit = true;
                                    System.out.println("Thoát chương trình");
                                    break;
                                }
                                default: {
                                    System.out.println("Lựa chọn không hợp lệ");
                                    break;
                                }
                            }
                        }


                    }catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }



                    break;
                }

                case 2: {
                    System.out.println("Nhập tài khoản:");
                    String userName = sc.nextLine();
                    System.out.println("Nhập email:");
                    String email = sc.nextLine();
                    System.out.println("Nhập mật khẩu: ");
                    String password =sc.nextLine();
                    accountController.createAccount(userName,email,password);
                    break;
                }

                case 3: {
                    System.out.println("Nhập email xác thực");
                    String email = sc.nextLine();
                    accountController.forgotPassword(email);
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
        System.out.println("\n--------- MENU ----------");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Thoát\n");
    }

    public static void showSubMenu() {
        System.out.println("-------- USER MENU ----------");
        System.out.println("1. Thay đổi username");
        System.out.println("2. Thay đổi email (Không được trùng với email của user khác trong List)");
        System.out.println("3. Thay đổi mật khẩu");
        System.out.println("4. Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng ký)");
        System.out.println("5. Thoát chương trình");
    }
}

