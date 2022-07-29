package com.example.frogbackendprogrammingtest.controllers;

import com.example.frogbackendprogrammingtest.DTO.BookException;
import com.example.frogbackendprogrammingtest.domain.Book;
import com.example.frogbackendprogrammingtest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Controller
public class BookController {
    BookRepository bookRepository;
    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new BookException("Book", "id", bookId));
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {

        bookRepository.findById(bookId).orElseThrow(() -> new BookException("Book", "id", bookId));

        bookDetails.setId(bookId);
        Book updateBook = bookRepository.save(bookDetails);
        return updateBook;
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookException("Book", "id", bookId));

        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }
}
