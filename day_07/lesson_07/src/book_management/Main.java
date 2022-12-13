package book_management;

import book_management.controller.BookController;

public class Main {
    // Chi tiết các layer

    // 1.Controller : tiếp nhận request từ người dùng,( nhấn 1 2 3 để thực hiện chức năng, làm menu
    // 2.Server : chứa business logic của ứng dụng
    // 3. repository : chứa phương thức để lấy dữ liệu
    // 4: database: chứa dữ liệu của ứng dụng (database)

    // Model: chứa các đối tượng( Student, Person,  Film,...)

    // actor -> gửi request(1,2,3) -> controller -> gửi thông tin request -> service -> reposition

    public static void main(String[] args) {
        BookController bookController = new BookController();
        bookController.run();
    }
}
 