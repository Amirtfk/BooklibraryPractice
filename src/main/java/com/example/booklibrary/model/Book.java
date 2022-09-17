package com.example.booklibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Video 3-Besprechung Mockito Aufgabe.mp4 > check part Tests

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String title;
    private String author;
    private String id;
}
