package book_management.frontend;

import book_management.backend.controller.BookController;
import book_management.backend.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookUI {
    private final BookController bookController = new BookController();

    public void run() {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
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
                    List<Book> books = bookController.getBooks();
                    if (books.isEmpty()) {
                        System.out.println("Không có cuốn sách nào");
                    }else {
                        for (Book b:books) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập tên sách cần tìm");
                    String title = sc.nextLine();
                    List<Book> books = bookController.getBooksByName(title);

                    if (books.isEmpty()) {
                        System.out.println("Không có cuốn sách nào có title là " + title);
                    }else {
                        for (Book b:books) {
                            System.out.println(b);
                        }
                    }
                    break;

                }
                case 3: {
                    System.out.println("Nhập thể loại cần tìm");
                    String categories = sc.nextLine();

                    List<Book> books = bookController.findByCategories(categories);

                    break;
                }
                case 4: {
                    bookController.sortByPageNumber();
                    break;
                }
                case 5: {

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
        System.out.println("---------------MENU--------------");
        System.out.println("1. Lấy thông tin toàn bộ sách");
        System.out.println("2. Tìm sách theo tên");
        System.out.println("3. Tìm sách theo thể loại");
        System.out.println("4. Sắp xếp sách theo số trang");
        System.out.println("5. Sắp xếp sách theo năm xuất bản");
        System.out.println("6. Thoat");
    }
}
