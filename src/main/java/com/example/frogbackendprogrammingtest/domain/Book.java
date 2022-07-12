package com.example.frogbackendprogrammingtest.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
public class Book implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "edition", length = 100, nullable = false)
    private String edition;

}
