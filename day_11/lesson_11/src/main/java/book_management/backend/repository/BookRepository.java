package book_management.backend.repository;

import book_management.backend.database.BookDB;
import book_management.backend.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public List<Book> findAll() {
        return BookDB.books;
    }

    
}
