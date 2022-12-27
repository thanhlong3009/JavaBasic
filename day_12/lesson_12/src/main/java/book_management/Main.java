package book_management;

import book_management.backend.database.BookDB;
import book_management.backend.model.Book;
import book_management.frontend.ui.BookUI;

public class Main {
    public static void main(String[] args) {
        BookUI bookUI = new BookUI();
        bookUI.run();
    }
}
