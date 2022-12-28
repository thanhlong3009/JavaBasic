package book_management.backend.service;

import book_management.backend.model.Book;
import book_management.backend.repository.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository = new BookRepository();


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String title) {
        List<Book> books = bookRepository.findAll();
        List<Book> rs = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                rs.add(b);
            }
        }
        return rs;
    }

    public List<Book> findByCategories(String categories) {
         return null;
    }

    public void sortByPageName() {

    }
}
