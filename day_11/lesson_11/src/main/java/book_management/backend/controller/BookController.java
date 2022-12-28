package book_management.backend.controller;

import book_management.backend.model.Book;
import book_management.backend.service.BookService;

import java.util.List;

public class BookController {
    private final BookService bookService = new BookService();

    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    public List<Book> getBooksByName(String title) {
        return bookService.getBooksByName(title);
    }

    public List<Book> findByCategories(String categories) {
        return bookService.findByCategories(categories);
    }

    public void sortByPageNumber() {
        bookService.sortByPageName();
    }
}
