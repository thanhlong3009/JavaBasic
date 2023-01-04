package xocdia_management.frontend.player;

import java.util.Scanner;

public class DepositAndWithdrawPage {

    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {

            System.out.println("--------- CỔNG NẠP RÚT TIỀN ----------");
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
        System.out.println("\n********* PLAYER MENU *********");
        System.out.println("1 - Nạp tiền ");
        System.out.println("2 - rút tiền");
        System.out.println("3 - Quay lại");
    }
}
