package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private BookDB bookRepository = mock(BookDB.class);

    private BookService bookService = new BookService(bookRepository);

    @Test
    void getAllBooks_returnsAllBooks(){
        // GIVEN
        List<Book> dummyBooks = List.of(
                new Book("Java ist auch eine Insel", "Christian Ullenboom", "1"),
                new Book("Clean Code", "Robert C. Martin", "2")
        );
        when(bookService.getAllBooks()).thenReturn(dummyBooks);

        // WHEN
        List<Book> actual = bookService.getAllBooks();

        // THEN
        List<Book> expected = List.of(
                new Book("Java ist auch eine Insel", "Christian Ullenboom", "1"),
                new Book("Clean Code", "Robert C. Martin", "2")
        );
        assertEquals(expected, actual);
    }

    @Test
    void getBookById_whenIdExists_returnsBook() {
        // GIVEN
        Book dummyBook = new Book("Java ist auch eine Insel", "Christian Ullenboom", "1");
        when(bookRepository.getBookById("1")).thenReturn(dummyBook);

        // WHEN
        Book actual = bookService.getBookById("1");

        // THEN
        Book expected = new Book("Java ist auch eine Insel", "Christian Ullenboom", "1");
        assertEquals(expected, actual);
    }

    @Test
    void getBookById_whenIdDoesNotExists_returnsBook() {
        // GIVEN
        when(bookRepository.getBookById("1")).thenReturn(null);

        // WHEN & THEN
        assertThrows(NoSuchElementException.class, () -> bookService.getBookById("1"));
    }

}