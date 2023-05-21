package pl.coderslab.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
//@ToString(exclude = {"id"})  //daje toString bez ajdika
@ToString
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //wyłącza id z Setterów
    private Long id;

    private String title;
    private int rating;
    private String description;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

}
