package book_management.controller;

import book_management.service.BookService;

import java.util.Scanner;


// Lấy thông tin người dùng tương tác với hệ thống --> gọi các hàm sử lý tương ứng ở trong service
public class BookController {
    public BookService bookService = new BookService();

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
                    System.out.println("Nhập tiêu đề cần tìm: ");
                    String title = sc.nextLine();
                    bookService.findByTitle(title);
                    break;
                }
                case 2: {
                    System.out.println("Nhập thể loại sách cần tìm: ");
                    String category = sc.nextLine();
                    bookService.findByCategory(category);
                    break;
                }
                case 3: {
                    bookService.listBooksPublishedThisYear();
                    break;
                }
                case 4: {
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
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Tìm sách theo tên");
        System.out.println("2 - Tìm sách theo thể loại");
        System.out.println("3 - Liệt kê sách xuất bản trong năm nay");
        System.out.println("4 - Thoát\n");
    }
}
