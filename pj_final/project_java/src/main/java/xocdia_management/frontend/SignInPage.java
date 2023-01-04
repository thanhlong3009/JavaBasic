package xocdia_management.frontend;

import xocdia_management.backend.controller.AdminController;
import xocdia_management.backend.controller.PlayerController;
import xocdia_management.backend.exception.NotFoundException;
import xocdia_management.backend.request.LoginRequest;

import java.util.Scanner;

public class SignInPage {


    private final AdminController adminController = new AdminController();
    private final PlayerController playerController = new PlayerController();

    private final AdminPage adminPage = new AdminPage();
    private final PlayerPage playerPage = new PlayerPage();
    public void run() {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenuSignIn();

            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.println("Nhập email");
                    String email = sc.nextLine();
                    System.out.println("Nhập mật khẩu");
                    String password = sc.nextLine();

                    LoginRequest loginRequest = new LoginRequest(email, password);

                    try {
                        if (adminController.checkLogin(loginRequest)) {
                            System.out.println("Đăng nhập thành công");
                            adminPage.run(email);
                        } else if (playerController.checkLogin(loginRequest)){
                            System.out.println("Đăng nhập thành công");
                            playerPage.run(email);
                        }else {
                            System.out.println("Tài khoản hoặc mật khẩu nhập không chính xác, nhập lại!");
                        }

                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 2 -> {
                    
                    break;
                }
                case 3 -> {
                    break;
                }
                case 4 -> {
                    isQuit = true;
                    break;
                }
                default -> {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }
    public static void showMenuSignIn() {
        System.out.println("\n********* SIGN UP MENU *********");
        System.out.println("1 - Đăng nhập ");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Thoát\n");
    }

}