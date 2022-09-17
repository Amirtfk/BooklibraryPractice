package com.example.booklibrary.repository;

import com.example.booklibrary.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDB {

    private Map<String, Book> books = new HashMap<>(
            Map.of(
                    "1", new Book("Hans im Glück", "Jacob Grimm", "1"),
                    "2", new Book("Java ist auch eine Insel", "Christian Ullenboom", "2"),
                    "3", new Book("Die besten Flachwitze für Coaches", "Dominic", "3")));

    public List<Book> getAllBooks(){
        return new ArrayList<Book>(books.values());
    }

    public Book getBookById(String id){
        return books.get(id);
    }

    public Book deleteBookById(String id){
        return books.remove(id);
    }

    public Book postNewBook(Book book){
        books.put(book.getId(), book);
        return book;
    }

}
