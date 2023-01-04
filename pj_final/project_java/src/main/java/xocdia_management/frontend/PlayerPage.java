package xocdia_management.frontend;

import xocdia_management.backend.controller.PlayerController;

import java.util.Scanner;

public class PlayerPage {

    private final PlayerController playerController = new PlayerController();
    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            System.out.printf("Chào mừng %s, bạn có thể thực hiện các công việc sau: \n", playerController.findPlayerByEmail(email).getUserName());
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
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
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
        System.out.println("\n********* PLAYER MENU *********");
        System.out.println("1 - Hướng dẫn ");
        System.out.println("2 - Bắt đầu đốt tiền");
        System.out.println("3 - Nạp tiền");
        System.out.println("4 - Rút tiền");
        System.out.println("5 - Thay đổi mật khẩu");
        System.out.println("6 - Thoát");
    }
}
