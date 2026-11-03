package com.example.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    // 1. Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // 2. Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // 3. Get a book by ID
    public Book getBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        throw new BookNotFoundException(
                "Book not found with ID: " + bookId);
    }

    // 4. Update book availability
    public Book updateAvailability(int bookId, boolean available) {

        Book book = getBookById(bookId);

        book.setAvailable(available);

        return book;
    }

    // 5. Delete a book
    public String deleteBook(int bookId) {

        Book book = getBookById(bookId);

        books.remove(book);

        return "Book deleted successfully";
    }

}
