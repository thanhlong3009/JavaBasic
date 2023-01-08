package taixiu_management.frontend.player_ui;

import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.request.ChangePasswordRequest;

import java.util.Scanner;

public class PlayerPage {

    private final PlayerController playerController = new PlayerController();

    private final DepositAndWithdrawPage depositAndWithdrawPage = new DepositAndWithdrawPage();

    private final PlayGamePage playGamePage = new PlayGamePage();

    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            Player player = playerController.findPlayerByEmail(email);
            System.out.println("\n-------- PLAYER PAGE -----------");
            System.out.printf("Chào mừng %s, bạn có thể thực hiện các công việc sau:\n", player.getUserName());
            showMenuPlayer();

            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.println("\n------ ĐÂY LÀ HUỚNG DẪN SỬ DỤNG ------");
                    System.out.println("1. Khi bắt đầu chơi nhà cái sẽ tung 3 con xúc xắc và tính điểm");
                    System.out.println("2. Kết quả trả về Xỉu (nếu tổng điểm 3 xúc xắc nhỏ hơn bằng 10), trả về Tài(nếu kết quả lớn hơn 10).");
                    System.out.println("3. Bạn sẽ chọn số tiền đặt cuợc và dự đoán kết quả Tài hay Xỉu.");
                    System.out.println("     + Nếu dự đoán đúng, bạn nhận về 100% số tiền cuợc với phí cuợc là 2 điểm.");
                    System.out.println("     + Nếu dự đoán sai, bạn sẽ mất 100% số tiền cuợc và không mất phí cược");
                    System.out.println("4. Tiền cá cược sẽ ngay lập tức được chuyển vào số dư của bạn sau khi hết ván.");
                    System.out.println("\n Nếu bạn còn có gì thắc mắc hãy liên hệ ngay đến hotline: 8888.8888 .\n");
                    System.out.println("--------- HẾT -----------\n");

                    System.out.println("Nhấn phím bất kỳ + Enter để quay lại");
                    String subOption =sc.nextLine();
                    break;
                }
                case 2: {
                    if (playerController.checkAccountBalance(email)){
                        playGamePage.run(email);
                    }else {
                        System.out.println("Số dư tài khoản của quý khách không đủ để tham gia trò chơi, vui lòng na thêm tiền!!");
                    }
                    break;
                }
                case 3: {
                    depositAndWithdrawPage.run(email);
                    break;
                }
                case 4: {
                    System.out.println("------ THÔNG TIN CÁ NHÂN ------");
                    System.out.println("Tên người chơi: " + player.getUserName());
                    System.out.println("Email đăng ký: " + player.getEmail());
                    System.out.println("Mật khẩu đăng nhập: " + player.getPassword());
                    System.out.println("Mật khẩu rút tiền: " + player.getPasswordWithdaw());
                    System.out.println("Số dư tài khoản: " + player.getAccountBalance());
                    System.out.println("Nhấn phím bất kỳ + Enter để quay lại");
                    String subOption =sc.nextLine();
                    break;
                }
                case 5: {
                    System.out.println("\n ------ THAY ĐỔI MẬT KHẨU ------");
                    System.out.println("Nhập mật khẩu hiện tại");
                    String password = sc.nextLine();
                    System.out.println("Nhập mật khẩu mới");
                    String newPassword = sc.nextLine();
                    System.out.println("Nhập lại mật khẩu mới");
                    String subNewPassword = sc.nextLine();

                    if (newPassword.equals(subNewPassword) && player.getPassword().equals(password)){
                        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(email,newPassword);
                        playerController.changePassword(changePasswordRequest);
                    }else {
                        System.out.println("Nhập xác nhận mật khẩu không chính xác");
                    }

                    break;
                }
                case 6: {
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

    public static void showMenuPlayer() {
        System.out.println("1 - Hướng dẫn ");
        System.out.println("2 - Bắt đầu đốt tiền");
        System.out.println("3 - Nạp/Rút tiền");
        System.out.println("4 - Thông tin cá nhân");
        System.out.println("5 - Thay đổi mật khẩu");
        System.out.println("6 - Thoát");
    }
}
