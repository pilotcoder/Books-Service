package pl.coderslab.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="publishers")
@Getter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String name;

    public void setName(String name) {
        this.name = name;
    }
}
