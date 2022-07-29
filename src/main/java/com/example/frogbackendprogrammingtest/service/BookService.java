package com.example.frogbackendprogrammingtest.service;

import com.example.frogbackendprogrammingtest.DTO.BookException;
import com.example.frogbackendprogrammingtest.domain.Book;
import com.example.frogbackendprogrammingtest.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final Logger log = LoggerFactory.getLogger(BookService.class);
    BookRepository bookRepository;

    public Book save(Book book) {
        log.debug("Request to save new book : {}", book);
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        log.debug("Request to get all books");
        return bookRepository.findAll();
    }

    public void delete(Long id){
        log.debug("Request to delete user : {}", id);
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookException("Book", "id", id));
        bookRepository.deleteById(id);
    }




}
