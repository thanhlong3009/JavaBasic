package book_management.backend.service;

import book_management.backend.model.Book;
import book_management.backend.repository.BookRepository;

import java.util.*;

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
        List<Book> books = bookRepository.findAll();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber() - o2.getPageNumber() ;
            }
        });
        for (Book b:books) {
            System.out.println(b);
        }
    }

    public void getBooksByReleaseYear() {
        List<Book> books = bookRepository.findAll();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getReleaseYear() - o2.getReleaseYear();
            }
        });
        for (Book b:books) {
            System.out.println(b);
        }
    }
}
