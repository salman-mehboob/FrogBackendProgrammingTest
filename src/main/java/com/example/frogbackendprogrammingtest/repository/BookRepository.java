package com.example.frogbackendprogrammingtest.repository;

import com.example.frogbackendprogrammingtest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByTitle(String title);
}
