package taixiu_management.frontend;

import taixiu_management.backend.controller.AdminController;
import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.exception.NotFoundException;
import taixiu_management.backend.model.Admin;
import taixiu_management.backend.model.Player;

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
                        System.out.println("\n----- DANH SÁCH TÀI KHOẢN ĐĂNG KÝ GAME TÀI XỈU -----");
                        System.out.printf("%-20s%-30s%-20s\n","USER_NAME","EMAIL","ACCOUNT BALANCE");
                        for (Player p:players) {
                            System.out.printf("%-20s%-30s%-20s\n",p.getUserName(),p.getEmail(),p.getAccountBalance());
                        }
                    }
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();
                    break;

                }

                case 3: {
                    List<Player> players = adminController.getRankings();
                    if (players.isEmpty()){
                        System.out.println("CHƯA CÓ CON BẠC NÀO THAM GIA TRÒ CHƠI");
                    }else {
                        System.out.println("\n----- BẢNG XẾP HẠNG CÁC CON BẠC -----");
                        System.out.printf("%-20s%-30s%-20s\n","USER_NAME","EMAIL","ACCOUNT BALANCE");
                        for (Player p:players) {
                            System.out.printf("%-20s%-30s%-20s\n",p.getUserName(),p.getEmail(),p.getAccountBalance());
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
                        System.out.printf("%-20s%-30s%-20s\n","USER_NAME","EMAIL","ACCOUNT BALANCE");
                        for (Player p:players) {
                            System.out.printf("%-20s%-30s%-20s\n",p.getUserName(),p.getEmail(),p.getAccountBalance());
                        }
                    }
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();

                    break;
                }

                case 5: {
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

                case  6: {
                    System.out.println(" Đăng xuất khỏi tài khoản admin");
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
        System.out.println("4 - Tìm kiếm tài khoản người chơi");
        System.out.println("5 - Xóa người chơi ");
        System.out.println("6 - Đăng xuất");
    }
}
