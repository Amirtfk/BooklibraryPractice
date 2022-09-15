package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private BookDB bookRepository;

    @Autowired
    public BookService(BookDB bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {
        List<Book> foundBooks = bookRepository.getAllBooks();
        return foundBooks;
    }

    public Book getBookById(String id) {
        Book foundBook = bookRepository.getBookById(id);

        // when no book with given id was found
        if (foundBook == null) {
            throw new NoSuchElementException("No book with found with id: " + id);
        }

        return foundBook;
    }


}
