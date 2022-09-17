package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private BookDB bookRepository; // Unsere BookService welche Dependency hat? > BookDbn in Repository

    @Autowired // Hier werden wir das Constructur generieren und dh das Automatisch Autowired werden soll
    public BookService(BookDB bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Jetzt brauchen wir 2 Methoden und Service diese 2 Methoden soll anbieten: 1) getAllBooks durchreichen und 2) getBookById
    public List<Book> getAllBooks() {
        List<Book> foundBooks = bookRepository.getAllBooks();
        return foundBooks;
    }

    // Der Unterschied zwischen Liste und unten Id: Liste kann Leer sein und ist ok.
    // Aber bei Id das problem ist, wenn null zurück kommet, haben wir dann ein Problem, dann
    // Unten bei Id sagen wir wenn nix gefunden ist, soll eine Fehler sein, dann müssen wir es prüfen
    // dann mit if sagen wir if no book was found dann throw mir this String " "


    public Book getBookById(String id) {
        Book foundBook = bookRepository.getBookById(id);

        // when no book with given id was found
        if (foundBook == null) {
            throw new NoSuchElementException("No book with found with id: " + id); // wenn wir z.B in Postman eingeben 8080/book/99999 > weil 99999 gibt es nicht dann wird this NoSuchElementException("No book with found with id: " + id) angezeigt
        }
        return foundBook;
    }


    public Book postNewBook(Book book) {
        return bookRepository.postNewBook(book);
    }


}
