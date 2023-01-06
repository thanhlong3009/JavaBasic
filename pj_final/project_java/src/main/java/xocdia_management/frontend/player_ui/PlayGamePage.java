package xocdia_management.frontend.player_ui;

import xocdia_management.backend.controller.PlayerController;
import xocdia_management.backend.model.Player;

import java.util.Random;
import java.util.Scanner;

public class PlayGamePage {

    private final PlayerController playerController = new PlayerController();

    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        Player player = playerController.findPlayerByEmail(email);


        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            System.out.println("\n---- BỘ MÔN THỂ THAO TÀI XỈU ----");
            System.out.println("Tên nguời chơi: " + player.getUserName());
            System.out.println("Số dư: " + player.getAccountBalance());
            System.out.println();
            System.out.println("1. Bắt đầu cá cuợc!!!!!");
            System.out.println("0. Thoát, hết tiền không chơi nữa ");
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, thử lại");
                System.out.println();
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.println("---- BẮT ĐẦU CHƠI ----");
                    int amountBet = 0;
                    // Đặt cuợc
                    do {
                        try {
                            System.out.println("Nhập số tiền bạn muốn đặt cược ( 3 - " + player.getAccountBalance() + " ):");
                            amountBet = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Lựa chọn không hợp lệ");
                            continue;
                        }
                    } while (amountBet <= 2 || amountBet > player.getAccountBalance());


                    // Chọn tài xỉu
                    int chooseBet = 0;
                    do {
                        try {
                            System.out.println("--- CHỌN CỬA ---");
                            System.out.println("--- 1. Tài---");
                            System.out.println("--- 2. Xỉu---");
                            chooseBet = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Lựa chọn không hợp lệ");
                            continue;
                        }
                    } while (chooseBet != 1 && chooseBet != 2);

                    Random dice = new Random();
                    int dice1 = dice.nextInt(5) + 1;
                    int dice2 = dice.nextInt(5) + 1;
                    int dice3 = dice.nextInt(5) + 1;
                    int betting = dice1+ dice2 + dice3;

                    int resultBet = 0; // = 1 nếu là tài, bằng 2 nếu là xỉu


                    System.out.printf("Kết quả cá cuợc từ nhà cái: \nXúc xắc: 1 %d điểm\nXúc xắc 2: %d điểm\nXúc xắc 3: %d điểm\n=> Kết quả: %d điểm\n",dice1,dice2,dice3,betting);
                    if (betting <= 10) {
                        System.out.println("=> XỈU");
                        if (chooseBet == 1) {
                            System.out.println("bạn chọn Tài => Cuợc thua, mất 100% số tiền cuợc");
                            playerController.loseBet(email,amountBet);
                        }else {
                            System.out.println("Bạn chọn Xỉu => Cược thắng, bạn thắng 100% số tiền cuợc với phí cá cược 2 điểm");
                            int amountBetWin = amountBet - 2;
                            playerController.winBet(email,amountBetWin);
                        }
                    } else {
                        System.out.println("=> TÀI");
                        if (chooseBet == 1) {
                            System.out.println("bạn chọn Tài => Cược thắng, bạn thắng 100% số tiền cuợc với phí cá cược 2 điểm");
                            int amountBetWin = amountBet - 2;
                            playerController.winBet(email,amountBetWin);
                        }else {
                            System.out.println("Bạn chọn Xỉu => Cuợc thua, mất 100% số tiền cuợc");
                            playerController.loseBet(email,amountBet);
                        }
                    }

                    System.out.println("Nhấn phím bất kỳ + Enter để trở lại");
                    String out = sc.nextLine();
                    break;
                }
                case 0: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    System.out.println();
                    break;
                }
            }
        }
    }

}
