package homework_product_manager.service;

import homework_product_manager.model.Product;
import homework_product_manager.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    ProductRepository productRepository = new ProductRepository();

    Scanner sc = new Scanner(System.in);
    public void printProducts() {
        for (Product p: productRepository.findAll()) {
            System.out.println(p);
        }
    }

    public void findByNameContainsIgnoreCase(String name) {
        for (Product p: productRepository.findByNameContainsIgnoreCase(name)) {
            System.out.println(p);
        }
    }

    public void findByID(int id) {

        System.out.println(productRepository.findById(id));

        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showSubMenu();

            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    productRepository.deleteById(id);
                    break;
                }
                case 2: {
                    System.out.println("Nhập số lượng cập nhật cho sản phẩm có id = " + id);
                    int quantity = Integer.parseInt(sc.nextLine());
                    productRepository.updateQuantity(quantity,id);
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

    public void findByQuantity(int quantity) {
        for (Product p:productRepository.findByQuantity(quantity)) {
            System.out.println(p);
        }
    }

    public void findByPrice(int minPrice,int maxPrice) {
        for (Product p:productRepository.findByPrice(minPrice,maxPrice)) {
            System.out.println(p);
        }

    }
    public static void showSubMenu() {
        System.out.println("\n-----------SUB-MENU--------------");
        System.out.println("1 - Xóa sản phẩm được tìm");
        System.out.println("2 - Cập nhật số lượng sản phẩm");
        System.out.println("3 - Thoát\n");
    }
}
