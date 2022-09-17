package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book") // Unsere End Point
public class BookController {

    private BookService bookService; //Unsere BookController hat Dependency mit BookService
    // control + leertaste

    // Theorie ist: Wir geben erstmal unsere Dependency und dann mit Constructur lassen wir unsere Injection
    // und dann Constructur generieren wie in Service
    // Und vergiss es nicht, dass diese Injections wird nur durch die @RestController zu @Service und daann zu @Repository gemacht werden
    @Autowired // mit Autowired injecten wir automatisch zu BookService
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping // Gibt uns eine Liste
    public List<Book> getAllBooks() {
        List<Book> foundBooks = bookService.getAllBooks();
        return foundBooks;
    }

    @GetMapping("{id}") // Gibt uns ein einzeles Buch // und {id} ist ein PathVariable und mit {} wird definiert, dass es ein wert ist und wird dann als id interpretiert, und jetzt wenn wir in Postman nach dem /book/1 angeben, wird 1 als unsere id defeniert und buch mit id 1 wird angzeigt
    public Book getBookById(@PathVariable String id){ // Wo kriegen wir diese Id aber her?! deswegen mussen wir ein PathVariable geben und sagen aus dem Path
        Book foundBook = bookService.getBookById(id);
        return foundBook;
    } //@PathVariable funktioniert so: wenn z.B 1 in {id} angegeben wird, wird in path id reingepackt und in den Methode arbeitet

    @PostMapping()
    public Book addBook(@RequestBody Book book) {
        return bookService.postNewBook(book);
    }

}
