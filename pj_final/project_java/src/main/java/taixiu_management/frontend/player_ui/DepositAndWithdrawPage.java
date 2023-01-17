package taixiu_management.frontend.player_ui;

import taixiu_management.backend.controller.HistoryController;
import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.model.Status;
import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.request.DepositRequest;
import taixiu_management.backend.request.HistoryRequest;
import taixiu_management.backend.request.WithdrawRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class DepositAndWithdrawPage {
    private final PlayerController playerController = new PlayerController();

    private final HistoryController historyController = new HistoryController();

    public void run(String email) {
        Player player = playerController.findPlayerByEmail(email);
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {

            System.out.println("--------- CỔNG NẠP RÚT TIỀN ----------");
            System.out.println("1 - Nạp tiền ");
            System.out.println("2 - rút tiền");
            System.out.println("3 - Lịch sử thanh toán");
            System.out.println("0 - Quay lại");

            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.println("\n ---- NẠP TIỀN ---");
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

                        System.out.println("Vui lòng chuyển tiền đến STK: 46110000400752 - BIDV - TRẦN THÀNH LONG  với nội dung là username của bạn.");
                        System.out.println("Ngay sau khi đã chuyển tiền thành công, quý khách hãy bấm xác nhận!!!");

                        int subOption = 0;
                        boolean subIsQuit = false;
                        // Menu xác nhận thanh toán
                        while (!subIsQuit) {
                            System.out.println("\n--- XÁC NHẬN THANH TOÁN ---");
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
                                    LocalDateTime timeSub = LocalDateTime.now();
                                    String time = timeSub.toString();
                                    int transactionCode = (int)(Math.random() * 90000 + 1000);
                                    Status status = Status.PENDING;
                                    String content = "Nạp tiền";
                                    HistoryRequest historyRequest = new HistoryRequest(email,time,transactionCode,amountDeposit,content,status);
                                    historyController.updateHistory(historyRequest);
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
                    System.out.println("\n---- RÚT TIỀN ----");
                    System.out.println("Bạn có thể rút tiền nhỏ hoặc bằng " + player.getAccountBalance() + "$.");
                    System.out.println("Hạn mức rút tối đa cho mỗi lần rút tiền là 99999$");
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
                        if (Objects.equals(passwordWithdraw, "0")) {
                            System.out.println("Thoát!!");
                            break;
                        }
                        if (player.getPasswordWithdaw().equals(passwordWithdraw)) {
                            try {
                                int otpRandom = (int)(Math.random() * 90000 + 1000);
                                System.out.println("Mã OTP của bạn là: " + otpRandom);
                                System.out.println("Nhập mã OTP để hoàn tất thanh toán");
                                int otp = Integer.parseInt(sc.nextLine());
                                if (Objects.equals(passwordWithdraw, "0")) {
                                    System.out.println("Thoát!!");
                                    break;
                                }
                                if (otp == otpRandom) {
                                    int subOption = 0;
                                    boolean subIsQuit = false;
                                    // Menu xác nhận thanh toán
                                    while (!subIsQuit) {
                                        System.out.println("\n--- XÁC NHẬN THANH TOÁN ---");
                                        System.out.println("1. Xác nhận thanh toán");
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
                                                LocalDateTime timeSub = LocalDateTime.now();
                                                String time = timeSub.toString();
                                                int transactionCode = (int)(Math.random() * 90000 + 1000);
                                                Status status = Status.PENDING;
                                                String content = "Rút tiền";
                                                HistoryRequest historyRequest = new HistoryRequest(email,time,transactionCode,amountWithdraw,content,status);
                                                historyController.updateHistory(historyRequest);
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
                                } else {
                                    System.out.println("Nhập mã otp thất bại, thoát");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Lựa chọn không hợp lệ, thử lại");
                                continue;
                            }
                        } else {
                            System.out.println("Mật khẩu rút tiền không chính xác, quay lại!");
                        }


                    } else {
                        System.out.println("Nhập số tiền không hợp lệ, quay lại");
                    }
                    break;
                }
                case 3: {
                    List<TransactionHistory> histories = historyController.getHistories(email);
                    System.out.println("\n--------- LỊCH SỬ GIAO DỊCH ------------");
                    System.out.printf("%-30s%-18s%-14s%-15s%-10s\n","THỜI GIAN","MÃ GIAO DỊCH","SỐ TIỀN (USD)","HÌNH THỨC","TRẠNG THÁI");
                    for (TransactionHistory t:histories) {
                        System.out.printf("%-30s%-18d%-14d%-15s%-10s\n",t.getTime(),t.getTransactionCode(),t.getAmount(),t.getContent(),t.getStatus());
                    }
                    System.out.println("\nẤn phím bất kỳ + Enter để quay lại!!!!");
                    String out = sc.nextLine();
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
}
