package taixiu_management.frontend.player_ui;

import taixiu_management.backend.controller.HistoryController;
import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.model.Status;
import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.request.DepositRequest;
import taixiu_management.backend.request.HistoryRequest;
import taixiu_management.backend.request.WithdrawRequest;

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
                        System.out.println("Nhập số tiền muốn nạp không trong hạn mức, thoát!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n---- RÚT TIỀN ----");
                    System.out.println("Bạn có thể rút tiền nhỏ hoặc bằng " + player.getAccountBalance() + "$.");
                    System.out.println("Hạn mức rút tối đa cho mỗi lần rút tiền là 99999$");
                    System.out.println("0. Nhấn 0 để thoát rút tiền bất cứ lúc nào!!!");
                    int amountWithdraw = 0;
                    try {
                        System.out.println("Nhập số tiền bạn muốn rút");
                        amountWithdraw = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ, thử lại");
                        continue;
                    }
                    if (amountWithdraw == 0) {
                        System.out.println("Thoát!!");
                        break;
                    }
                    WithdrawRequest withdrawRequest = new WithdrawRequest(email, amountWithdraw);
                    if (playerController.checkAmount(amountWithdraw) && amountWithdraw <= player.getAvailableAccountBalance() && amountWithdraw > 0) {
                        System.out.println("Nhập lại mật khẩu rút tiền: ");
                        String passwordWithdraw = sc.nextLine();
                        if (Objects.equals(passwordWithdraw, "0")) {
                            System.out.println("Thoát!!");
                            break;
                        }
                        if (player.getPasswordWithdaw().equals(passwordWithdraw)) {
                            try {
                                System.out.println("Nhập số điện thoại bạn muốn rút tiền về với hình thức thẻ cào điện thoại (10 đến 11 chữ số).");
                                String phoneWithdraw = sc.nextLine();
                                if (Objects.equals(passwordWithdraw, "0")) {
                                    System.out.println("Thoát!!");
                                    break;
                                }
                                if (playerController.checkPhoneWithdraw(phoneWithdraw)) {
                                    int subOption = 0;
                                    boolean subIsQuit = false;
                                    // Menu xác nhận thanh toán
                                    while (!subIsQuit) {
                                        System.out.println("\n--- XÁC NHẬN LẠI GIAO DỊCH ---");
                                        System.out.println("Số điện thoại nhận tiền: " + phoneWithdraw);
                                        System.out.println("Số tiền nạp điện thoại: " + amountWithdraw + " USD");
                                        System.out.println("Lưu ý: Bạn hãy kiểm tra lại lần cuối số điện thoại giao dịch, chúng tôi sẽ không giải quyết các vần đề liên quan đến sai số điện thoai.");
                                        System.out.println("\n1. Xác nhận giao dịch");
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
                                                playerController.temporaryWithdrawPlayer(email,amountWithdraw);
                                                LocalDateTime timeSub = LocalDateTime.now();
                                                String time = timeSub.toString();
                                                int transactionCode = (int)(Math.random() * 90000 + 1000);
                                                Status status = Status.PENDING;
                                                String content = "Rút tiền";
                                                HistoryRequest historyRequest = new HistoryRequest(email,time,transactionCode,amountWithdraw,content,status);
                                                historyController.updateHistory(historyRequest);
                                                System.out.println("\n Yêu cầu rút tiền đã được gửi đi!!!");
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
                                    System.out.println("Số điện thoại không hợp lệ, thoát!");
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
