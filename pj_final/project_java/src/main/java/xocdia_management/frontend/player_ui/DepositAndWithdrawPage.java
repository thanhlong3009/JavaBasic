package xocdia_management.frontend.player_ui;

import xocdia_management.backend.controller.PlayerController;
import xocdia_management.backend.model.Player;
import xocdia_management.backend.request.DepositRequest;
import xocdia_management.backend.request.WithdrawRequest;

import java.util.Objects;
import java.util.Scanner;

public class DepositAndWithdrawPage {
    private final PlayerController playerController = new PlayerController();

    public void run(String email) {
        Player player = playerController.findPlayerByEmail(email);
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
                    int amountDeposit;
                    try {
                        System.out.println("Nhập số tiền bạn muốn nạp( Số tiền nạp trong khoản 1 - 99999)");
                        amountDeposit = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ, thử lại");
                        continue;
                    }
                    DepositRequest depositRequest = new DepositRequest(email, amountDeposit);
                    if (playerController.checkAmount(depositRequest.getAmountDeposit()) && depositRequest.getAmountDeposit() > 0) {

                        System.out.println("Vui lòng chuyển tiền đến STK: 46110000400752 - BIDV - TRẦN THÀNH LONG");
                        System.out.println("Ngay sau khi đã chuyển tiền thành công, quý khách hãy bấm xác nhận!!!");

                        int subOption = 0;
                        boolean subIsQuit = false;
                        // Menu xác nhận thanh toán
                        while (!subIsQuit) {
                            System.out.println("--- Xác nhận thanh toán ---");
                            System.out.println("1. Thanh toán thành công");
                            System.out.println("0. Hủy thanh toán, quay lại");

                            try {
                                System.out.print("Nhập lựa chọn : ");
                                subOption = Integer.parseInt(sc.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Lựa chọn không hợp lệ, thử lại");
                                continue;
                            }

                            switch (subOption) {
                                case 1: {
                                    playerController.depositPlayer(depositRequest);
                                    System.out.println("\nTài khoản quý khách sẽ được cộng điểm trong 3-5 phút!!!");
                                    subIsQuit = true;
                                    break;
                                }
                                case 0: {
                                    subIsQuit = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Lựa chọn không hợp lệ");
                                    break;
                                }
                            }
                        }

                    } else {
                        System.out.println("Nhập số tiền muốn nạp không chính xác");
                    }
                    break;

                }
                case 2: {
                    System.out.println("Bạn có thể rút tiền nhỏ hoặc bằng " + player.getAccountBalance());
                    int amountWithdraw = 0;
                    try {
                        System.out.println("Nhập số tiền bạn muốn rút");
                        amountWithdraw = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ, thử lại");
                        continue;
                    }

                    WithdrawRequest withdrawRequest = new WithdrawRequest(email, amountWithdraw);
                    if (playerController.checkAmount(amountWithdraw) && amountWithdraw <= player.getAccountBalance()) {
                        System.out.println("Nhập lại mật khẩu rút tiền: ");
                        String passwordWithdraw = sc.nextLine();
                        if (player.getPasswordWithdaw().equals(passwordWithdraw)) {
                            try {
                                System.out.println("Nhập mã otp để hoàn tất thanh toán");
                                String otp = sc.nextLine();
                                if (Objects.equals(otp, "9999")) {
                                    int subOption = 0;
                                    boolean subIsQuit = false;
                                    // Menu xác nhận thanh toán
                                    while (!subIsQuit) {
                                        System.out.println("--- Xác nhận thanh toán ---");
                                        System.out.println("1. Xác nhận rút tiền");
                                        System.out.println("0. Hủy thanh toán, quay lại");

                                        try {
                                            System.out.print("Nhập lựa chọn : ");
                                            subOption = Integer.parseInt(sc.nextLine());
                                        } catch (NumberFormatException e) {
                                            System.out.println("Lựa chọn không hợp lệ, thử lại");
                                            continue;
                                        }

                                        switch (subOption) {
                                            case 1: {
                                                playerController.withdrawPlayer(withdrawRequest);
                                                System.out.println("\n Rút tiền thành công!!!");
                                                subIsQuit = true;
                                                break;
                                            }
                                            case 0: {
                                                subIsQuit = true;
                                                break;
                                            }
                                            default: {
                                                System.out.println("Lựa chọn không hợp lệ");
                                                break;
                                            }
                                        }
                                    }
                                }else {
                                    System.out.println("Nhập mã otp thất bại, thoát");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Lựa chọn không hợp lệ, thử lại");
                                continue;
                            }
                        }else {
                            System.out.println("Mật khẩu rút tiền không chính xác, quay lại!");
                        }
                        // TODO: làm tương tự nạp tiền, thêm mục nhập lại mật khẩu rút tiền, nhập mã otp và sau đó xác nhận1

                    }
                    break;
                }
                case 0: {
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

    public static void showMenuDepositAndWithdraw() {
        System.out.println("\n********* DEPOSIT/WITHDRAW MENU *********");
        System.out.println("1 - Nạp tiền ");
        System.out.println("2 - rút tiền");
        System.out.println("0 - Quay lại");
    }
}
