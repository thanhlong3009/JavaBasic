package homework_product_manager.controller;

import homework_product_manager.service.ProductService;

import java.util.Scanner;

public class ProductController {
    ProductService productService = new ProductService();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    productService.printProducts();
                    break;
                }
                case 2: {
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String name = sc.nextLine();
                    productService.findByNameContainsIgnoreCase(name);
                    break;
                }
                case 3: {
                    System.out.println("Nhập id cần tìm: ");
                    int id = Integer.parseInt(sc.nextLine());
                    productService.findByID(id);
                    break;
                }
                case 4: {
                    System.out.println("Tìm số luợng sản phẩm dưới: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    productService.findByQuantity(quantity);
                    break;
                }
                case 5: {
                    System.out.println("Nhập khoảng giá cần tìm:");
                    System.out.println("Từ:");
                    int minPrice = Integer.parseInt(sc.nextLine());
                    System.out.println("Đến:");
                    int maxPrice = Integer.parseInt(sc.nextLine());
                    productService.findByPrice(minPrice,maxPrice);
                    break;
                }
                case 6: {
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
        System.out.println("\n------------MENU--------------");
        System.out.println("1 - Xem danh sách sản phẩm");
        System.out.println("2 - Tìm sản phẩm theo tên");
        System.out.println("3 - Tìm sản phẩm theo id");
        System.out.println("4 - Tìm các sản phẩn có số lượng dưới 5");
        System.out.println("5 - Tìm sản phẩm theo mức giá");
        System.out.println("6 - Thoát\n");
    }
}
