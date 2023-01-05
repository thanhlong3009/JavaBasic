package xocdia_management.frontend;

import xocdia_management.backend.controller.AdminController;
import xocdia_management.backend.controller.PlayerController;
import xocdia_management.backend.exception.NotFoundException;
import xocdia_management.backend.model.Player;

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
            System.out.printf("\nChào mừng %s (Admin), bạn có thể thực hiện các công việc sau: \n", adminController.findAdminByEmail(email).getUserName());
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
                    List<Player> players = adminController.getPlayers();

                    if (players.isEmpty()){
                        System.out.println("Không có người chơi nào tham gia trò chơi");
                    }else {
                        System.out.println("--- DANH SÁCH TÀI KHOẢN ĐĂNG KÝ GAME XÓC ĐĨA ---");
                        System.out.printf("%-15s%-30s%-20s\n","USER_NAME","EMAIL","ACCOUNT BALANCE");
                        for (Player p:players) {
                            System.out.printf("%-15s%-30s%-20s\n",p.getUserName(),p.getEmail(),p.getAccountBalance());
                        }
                    }
                    System.out.println("Nhấn 0 + Enter để quay lại");
                    int subOption = 0;
                    subOption = Integer.parseInt(sc.nextLine());
                    if (subOption == 0) {
                        break;
                    }
                }
                case 2: {
                    System.out.println("Nhập username muốn xóa: ");
                    String userName = sc.nextLine();
                    try {
                        adminController.deletePlayers(userName);
                    }catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
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

    public static void showMenu() {
        System.out.println("********* ADMIN MENU *********");
        System.out.println("1 - Xem danh sách người chơi ");
        System.out.println("2 - Xóa người chơi ");
        System.out.println("3 - Đăng xuất");
    }
}
