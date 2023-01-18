package taixiu_management.frontend;

import taixiu_management.backend.controller.AdminController;
import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.exception.NotFoundException;
import taixiu_management.backend.model.Admin;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.model.Status;
import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.request.DepositRequest;
import taixiu_management.backend.request.WithdrawRequest;

import java.util.List;
import java.util.Scanner;

public class AdminPage {
    private final AdminController adminController = new AdminController();
    private final PlayerController playerController = new PlayerController();


    public void run(String email) {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            System.out.println("********* ADMIN PAGE *********");
            System.out.printf("Chào mừng %s(Admin), bạn có thể thực hiện các công việc sau: \n", adminController.findAdminByEmail(email).getUserName());
            showMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (option) {

                case 1: {
                    System.out.println("\n ------- THÔNG TIN CÁ NHÂN ----------");
                    Admin admin = adminController.findAdminByEmail(email);
                    System.out.println("Username: " + admin.getUserName());
                    System.out.println("Email: " + admin.getEmail());
                    System.out.println("Password: " + admin.getPassword());
                    System.out.println("------ HẾT -------");
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();
                    break;
                }
                case 2: {
                    List<Player> players = adminController.getPlayers();
                    if (players.isEmpty()){
                        System.out.println("Không có người chơi nào tham gia trò chơi");
                    }else {
                        System.out.println("\n-------------------------------- DANH SÁCH TÀI KHOẢN ĐĂNG KÝ GAME TÀI XỈU --------------------------------");
                        System.out.printf("%-20s%-30s%-25s%-20s%-20s\n","USER_NAME","EMAIL","ACCOUNT BALANCE (USD)","TOTAL_BET (USD)","BETTING_PROFIT (USD)");
                        for (Player p:players) {
                            System.out.printf("%-20s%-30s%-25d%-20d%-20d\n",p.getUserName(),p.getEmail(),p.getAccountBalance(),p.getTotalBet(),p.getBettingProfit());
                        }
                    }
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();
                    break;

                }

                case 3: {
                    List<Player> playersRanking = adminController.getRankings();
                    if (playersRanking.isEmpty()){
                        System.out.println("CHƯA CÓ CON BẠC NÀO THAM GIA TRÒ CHƠI");
                    }else {
                        System.out.println("\n--------------------------------- BẢNG XẾP HẠNG CÁC CON BẠC ----------------------------------");
                        System.out.printf("%-20s%-30s%-25s%-20s%-20s\n","USER_NAME","EMAIL","ACCOUNT BALANCE (USD)","TOTAL_BET (USD)","BETTING_PROFIT (USD)");
                        for (Player p:playersRanking) {
                            System.out.printf("%-20s%-30s%-25d%-20d%-20d\n",p.getUserName(),p.getEmail(),p.getAccountBalance(),p.getTotalBet(),p.getBettingProfit());
                        }
                    }
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();
                    break;
                }

                case 4: {
                    System.out.println("Nhập email người chơi cần tìm ");
                    String emailFind = sc.nextLine();
                    List<Player> players = adminController.findPlayersByEmail(emailFind);
                    if (players.isEmpty()){
                        System.out.println("KHÔNG CÓ CON BẠC NÀO");
                    }else {
                        System.out.println("\n----- DANH SÁCH CÁC CON BẠC CẦN TÌM -----");
                        System.out.printf("%-20s%-30s%-25s%-20s%-20s\n","USER_NAME","EMAIL","ACCOUNT BALANCE (USD)","TOTAL_BET (USD)","BETTING_PROFIT (USD)");
                        for (Player p:players) {
                            System.out.printf("%-20s%-30s%-25d%-20d%-20d\n",p.getUserName(),p.getEmail(),p.getAccountBalance(),p.getTotalBet(),p.getBettingProfit());
                        }
                    }
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();

                    break;
                }

                case 5: {
                    int subOption = 0;
                    boolean subIsQuit = false;
                    while (!subIsQuit) {
                        List<TransactionHistory> histories = adminController.getHistoriesPending();
                        System.out.println("----------CÁC GIAO DỊCH ĐANG CHỜ XỬ LÝ-----------");
                        System.out.printf("%-31s%-27s%-18s%-14s%-15s%-10s\n","THỜI GIAN","EMAIL","MÃ GIAO DỊCH","SỐ TIỀN (USD)","HÌNH THỨC","TRẠNG THÁI");
                        for (TransactionHistory t:histories) {
                            System.out.printf("%-31s%-27s%-18d%-14d%-15s%-10s\n",t.getTime(),t.getEmail(),t.getTransactionCode(),t.getAmount(),t.getContent(),t.getStatus());
                        }
                        System.out.println("\n--------------- XỬ LÝ GIAO DỊCH -------------");
                        System.out.println("1. Chọn giao dịch cần xử lý");
                        System.out.println("0. Trở về");
                        try {
                            System.out.print("Nhập lựa chọn : ");
                            subOption = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Lựa chọn không hợp lệ, thử lại");
                            continue;
                        }
                        switch (subOption) {
                            case 1: {
                                try {
                                    System.out.print("Nhập mã giao dịch cần xử lý ");
                                    int transactionCode = Integer.parseInt(sc.nextLine());
                                    if (adminController.checkTransactionExits(transactionCode)) {
                                        TransactionHistory transactionHistory = adminController.findTransactionHistoryByCode(transactionCode);
                                        int subOption1 = 0;
                                        boolean subIsQuit1 = false;
                                        while (!subIsQuit1){
                                            System.out.println("-------- GIAO DỊCH ĐANG XỬ LÝ ----------");
                                            System.out.printf("%-31s%-27s%-18s%-14s%-15s%-10s\n","THỜI GIAN","EMAIL","MÃ GIAO DỊCH","SỐ TIỀN (USD)","HÌNH THỨC","TRẠNG THÁI");
                                            System.out.printf("%-31s%-27s%-18d%-14d%-15s%-10s\n",transactionHistory.getTime(),transactionHistory.getEmail(),transactionHistory.getTransactionCode(),transactionHistory.getAmount(),transactionHistory.getContent(),transactionHistory.getStatus());
                                            System.out.println("\n1. Giao dịch hoàn thành        2.Giao dịch thất bại        0. Thoát");
                                            try {
                                                System.out.print("Nhập lựa chọn : ");
                                                subOption1 = Integer.parseInt(sc.nextLine());
                                            } catch (NumberFormatException e) {
                                                System.out.println("Lựa chọn không hợp lệ, thử lại");
                                                continue;
                                            }
                                            switch (subOption1){
                                                case 1:{
                                                    Status stt = Status.DONE;
                                                    adminController.updateStatus(transactionHistory.getTransactionCode(),stt);

                                                    System.out.println("Xác nhận giao dịch");
                                                    if (transactionHistory.getContent().equals("Nạp tiền")){
                                                        DepositRequest depositRequest = new DepositRequest(transactionHistory.getEmail(),transactionHistory.getAmount());
                                                        playerController.depositPlayer(depositRequest);
                                                    }else if (transactionHistory.getContent().equals("Rút tiền")){
                                                        WithdrawRequest withdrawRequest = new WithdrawRequest(transactionHistory.getEmail(),transactionHistory.getAmount());
                                                        playerController.withdrawPlayer(withdrawRequest);
                                                    }
                                                    subIsQuit1 = true;
                                                    break;
                                                }
                                                case 2: {
                                                    if (transactionHistory.getContent().equals("Rút tiền")){
                                                        playerController.returnWithdraw(transactionHistory.getEmail(),transactionHistory.getAmount());
                                                    }
                                                    Status stt = Status.FAILED;
                                                    adminController.updateStatus(transactionHistory.getTransactionCode(),stt);

                                                    System.out.println("Xác nhận giao dịch");
                                                    subIsQuit1 =true;
                                                    break;
                                                }

                                                case 0: {
                                                    subIsQuit1 = true;
                                                    System.out.println("Trở về!!!");
                                                    break;
                                                }
                                                default:{
                                                    System.out.println("Lựa chọn không chính xác, chọn lại!!");
                                                }
                                            }
                                        }
                                    }else {
                                        System.out.println("Mã giao dịch không tồn tại");
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn không hợp lệ, thử lại");
                                    continue;
                                }
                                break;
                            }

                            case 0: {
                                subIsQuit = true;
                                System.out.println("Trở về!!!!");
                                break;
                            }
                            default: {
                                System.out.println("Lựa chọn không đúng, chọn lại!!!");
                            }
                        }
                    }

                    break;
                }

                case 6: {
                    System.out.println("\n---- XÓA NGƯỜI CHƠI THEO USERNAME ----");
                    System.out.println("Nhập username muốn xóa: ");
                    String userName = sc.nextLine();
                    try {
                        adminController.deletePlayers(userName);
                        System.out.println("Đã xóa thành công người chơi có username là \n" + userName);
                    }catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case  7: {
                    System.out.println(" Đăng xuất khỏi tài khoản admin");
                    isQuit = true;
                    break;
                }

                case 8: {
                    System.out.println("---- Thoát chương trình ----");
                    System.exit(1);
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

    public static void showMenu() {
        System.out.println("1 - Thông tin cá nhân ");
        System.out.println("2 - Xem danh sách người chơi ");
        System.out.println("3 - Bảng xếp hạng người chơi");
        System.out.println("4 - Tìm kiếm tài khoản người chơi (theo email)");
        System.out.println("5 - Xử lý giao dịch");
        System.out.println("6 - Xóa người chơi (theo username)");
        System.out.println("7 - Đăng xuất");
        System.out.println("8 - Thoát chương trình");
    }
}
