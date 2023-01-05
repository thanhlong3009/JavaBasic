package xocdia_management.frontend.player_ui;

import xocdia_management.backend.controller.PlayerController;
import xocdia_management.backend.repository.request.DepositRequest;

import java.util.Scanner;

public class DepositAndWithdrawPage {
    private final PlayerController playerController = new PlayerController();
    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {

            System.out.print("--------- CỔNG NẠP RÚT TIỀN ----------");
            showMenuDepositAndWithdraw();

            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.println("Nhập số tiền bạn muốn nạp");
                    int amountDeposit = Integer.parseInt(sc.nextLine());
                    DepositRequest depositRequest = new DepositRequest(email,amountDeposit);
                    playerController.depositPlayer(depositRequest);
                    break;
                }
                case 2: {

                    break;
                }
                case 3: {
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
    public static void showMenuDepositAndWithdraw () {
        System.out.println("\n********* DEPOSIT/WITHDRAW MENU *********");
        System.out.println("1 - Nạp tiền ");
        System.out.println("2 - rút tiền");
        System.out.println("3 - Quay lại");
    }
}
