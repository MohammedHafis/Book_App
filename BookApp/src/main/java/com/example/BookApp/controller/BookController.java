package com.example.BookApp.controller;

import org.springframework.stereotype.Controller;
import com.example.BookApp.entities.Book;
import com.example.BookApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBook(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "Book with ID " + id + "deleted successfully";
    }
}
