package com.example.frogbackendprogrammingtest;

import com.example.frogbackendprogrammingtest.domain.Book;
import com.example.frogbackendprogrammingtest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FrogBackendProgrammingTestApplicationTests {

    @Autowired
    BookRepository  bookRepository;
    @Test
    @Order(1)
    public void saveBookTest(){
       Book b = new Book();
       b.setId(1L);
       b.setTitle("java");
       b.setDescription("learn java in 24 days");
       b.setEdition("2nd");
       bookRepository.save(b);
       assertNotNull(bookRepository.findById(b.getId()));
    }
    @Test
    @Order(2)
    public void bookReadTest(){
        List<Book> list = bookRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
    @Test
    @Order(3)
    public void bookDeleteTest () {
        Book b = bookRepository.findById(1L).map(iss -> iss)
                .orElseThrow();
        bookRepository.deleteById(b.getId());
        assertThat(bookRepository.existsById(1L)).isFalse();
    }


}
