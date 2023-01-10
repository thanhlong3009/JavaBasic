package taixiu_management.frontend;

import taixiu_management.backend.controller.AdminController;
import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.exception.NotFoundException;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.request.ChangePasswordRequest;
import taixiu_management.backend.request.LoginRequest;
import taixiu_management.backend.request.RegisterRequest;
import taixiu_management.frontend.player_ui.PlayerPage;

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
                    System.out.println("\n ---- ĐĂNG NHẬP TÀI KHOẢN ----");
                    System.out.println("Nhập email");
                    String email = sc.nextLine();
                    System.out.println("Nhập mật khẩu");
                    String password = sc.nextLine();

                    LoginRequest loginRequest = new LoginRequest(email, password);

                    try {
                        if (adminController.checkLogin(loginRequest)) {
                            System.out.println("Đăng nhập thành công");
                            adminPage.run(email);
                        } else if (playerController.checkLogin(loginRequest)) {
                            System.out.println("Đăng nhập thành công");
                            playerPage.run(email);
                        } else {
                            System.out.println("Tài khoản hoặc mật khẩu nhập không chính xác, trở lại!\n");
                        }

                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }


                }
                case 2 -> {
                    System.out.println("------------- ĐĂNG KÝ TÀI KHOẢN ------------");
//                    System.out.println("Nhập tên tài khoản");
//                    String userName = sc.nextLine();
//                    System.out.println("Nhập email:");
//                    String email = sc.nextLine();
//                    System.out.println("Nhập mật khẩu:");
//                    String password = sc.nextLine();
//                    System.out.println("Nhập mật khẩu rút tiền");
//                    String passwordWithdaw = sc.nextLine();
//                    int accountBalance = 0;
//                    RegisterRequest registerRequest = new RegisterRequest(userName,email,password,passwordWithdaw,accountBalance);
//
//                    playerController.createPlayer(registerRequest);


                    while (true) {

                        System.out.println("Nhập email đăng ký:");
                        String email = sc.nextLine();
                        if (!playerController.checkEmailExist(email) && playerController.checkEmailValidate(email)) {
                            while (true) {
                                System.out.println("Nhập tên tài khoản (từ 4-15 ký tự có thể gồm cả chữ cái và chữ số)");
                                String userName = sc.nextLine();
                                if (playerController.checkUserName(userName)) {
                                    while (true) {
                                        System.out.println("Nhập mật khẩu (Từ 7-15 ký tự có thể gồm cả chữ cái in hoa và chữ số):");
                                        String password = sc.nextLine();
                                        System.out.println("Nhập mật khẩu rút tiền (Gồm 4 chữ số)");
                                        String passwordWithdaw = sc.nextLine();
                                        int accountBalance = 0;
                                        if (playerController.checkPassword(password) && playerController.checkPasswordWithdraw(passwordWithdaw)) {
                                            RegisterRequest registerRequest = new RegisterRequest(userName, email, password, passwordWithdaw, accountBalance);

                                            playerController.createPlayer(registerRequest);
                                            break;
                                        } else {
                                            System.out.println("Mật khẩu hoặc mật khẩu rút tiền không chính xác, nhập lại");
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Username không hợp lệ, nhập lại");
                                }
                            }
                            break;
                        } else {
                            System.out.println("Email không hợp lệ hoặc đã tồn tại, nhập lại");
                        }
                    }

                }
                case 3 -> {
                    System.out.println("\n ------ QUÊN MẬT KHẨU ------");
                    System.out.println("Nhập email xác thực: ");
                    String email = sc.nextLine();
                    if (playerController.checkEmailExist(email)) {
                        System.out.println("Nhập mật khẩu bạn muốn thay đổi");
                        String password = sc.nextLine();
                        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(email, password);
                        playerController.changePassword(changePasswordRequest);
                    } else {
                        System.out.println("Email không tồn tại, trở lại!!\n");
                    }

                }
                case 4 -> {
                    isQuit = true;

                }
                default -> {
                    System.out.println("Lựa chọn không hợp lệ");

                }
            }
        }
    }

    public static void showMenuSignIn() {
        System.out.println("---- SHENLONG_NHÀ CÁI CÁ CƯỢC UY TÍN SỐ MỘT ĐÔNG DƯƠNG ----");
        System.out.println("--- Chào mừng bạn đến với GAME TÀI XỈU ---");
        System.out.println();
        System.out.println("1 - Đăng nhập ");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Thoát\n");
    }

}
