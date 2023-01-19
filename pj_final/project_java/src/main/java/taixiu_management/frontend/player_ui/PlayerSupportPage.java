package taixiu_management.frontend.player_ui;

import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.model.Admin;

import java.util.List;
import java.util.Scanner;

public class PlayerSupportPage {

    private final PlayerController playerController = new PlayerController();
    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        int supportOption = 0;
        boolean subIsQuit = false;
        while (!subIsQuit) {
            showMenuSupport();
            try {
                System.out.print("Nhập lựa chọn : ");
                supportOption = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (supportOption) {
                case 1: {
                    System.out.println("Bạn đang có số thứ tự 23 trong hàng chờ, thời gian ước tính 15 phút .........");
                    System.out.println("\nẤn phím bất kỳ để trở lại ...");
                    String out = sc.nextLine();
                    break;
                }
                case 2: {
                    List<Admin> admins = playerController.getAdmins();
                    if (admins.isEmpty()) {
                        System.out.println("Không có admin nào");
                    } else {
                        System.out.println("\n----- DANH SÁCH ADMIN -----");
                        System.out.printf("%-20s%-30s\n", "USER_NAME", "EMAIL");
                        for (Admin a : admins) {
                            System.out.printf("%-20s%-30s\n", a.getUserName(), a.getEmail());
                        }
                    }
                    System.out.println("Hãy liên hệ trực tiếp với 1 trong các admin qua email để nhận được sự hỗ trợ sớm nhất!!!");
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();
                    break;
                }
                case 0: {
                    subIsQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ, nhập lại");
                }
            }
        }
    }
    public static void showMenuSupport() {
        System.out.println("\n ---- TRANG HỖ TRỢ KHÁCH HÀNG -----");
        System.out.println("1. Live Chat");
        System.out.println("2. Liên hệ trực tiếp với các admin");
        System.out.println("0. Quay lại");
    }
}
