package com.example.booklibrary.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
class BookControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void getAllBooks_returnAllBooks() throws Exception {

            // GIVEN
            String expectedJson = """
                """;

            // WHEN & THEN
            mockMvc.perform(MockMvcRequestBuilders.get("/book"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(expectedJson));
        }


    @Test
    void addBook_addGivenBook() throws Exception {

        // GIVEN
        String requestBody = """
                {
                    "id": "4",
                    "title": "Der Mann und das Meer",
                    "author": "Ernest Hemingway"
                }
                """;

        String expectedResponseBody = """
                {
                    "id": "4",
                    "title": "Der Mann und das Meer",
                    "author": "Ernest Hemingway"
                }
                """;

        // When & Then
        mockMvc.perform(
                        post("/book")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseBody));

    }

    }