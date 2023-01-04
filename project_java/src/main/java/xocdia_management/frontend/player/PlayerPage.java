package xocdia_management.frontend.player;

import xocdia_management.backend.controller.PlayerController;
import xocdia_management.frontend.player.DepositAndWithdrawPage;

import java.util.Scanner;

public class PlayerPage {

    private final PlayerController playerController = new PlayerController();

    private final DepositAndWithdrawPage depositAndWithdrawPage = new DepositAndWithdrawPage();
    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            System.out.printf("\nChào mừng %s, bạn có thể thực hiện các công việc sau: \n", playerController.findPlayerByEmail(email).getUserName());
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
                    System.out.println("------ ĐÂY LÀ HUỚNG DẪN SỬ DỤNG ------");
                    System.out.println("1. Khi bắt đầu chơi nhà cái sẽ để các đồng xu nằm sâu vào bên trong bát và sau đó tiến hành xóc.");
                    System.out.println("2. Đặt cược cửa chẵn: khi người chơi đặt cược ở cửa này sẽ có thể ăn tiền nếu kết quả cho ra 4 đồng đỏ, 4 đồng trắng hoặc 2 đồng đỏ – 2 đồng trắng.");
                    System.out.println("3. Cược cửa lẻ: khi đặt ở cửa này nếu kết quả cho ra 1 đồng trắng – 3 đồng đỏ hoặc 1 đồng đỏ – 3 đồng trắng thì người chơi sẽ giành chiến thắng.");

                    System.out.println("Nhấn 0 + Enter để quay lại");
                    int subOption = 0;
                    subOption = Integer.parseInt(sc.nextLine());
                    if (subOption == 0) {
                        break;
                    }
                }
                case 2: {

                    break;
                }
                case 3: {
                    depositAndWithdrawPage.run(email);
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
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
        System.out.println("3 - Nạp/Rút tiền");
        System.out.println("4 - Thay đổi mật khẩu");
        System.out.println("5 - Thoát");
    }
}
