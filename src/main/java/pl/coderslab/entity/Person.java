package pl.coderslab.entity;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String login;
    private String password;
    private String email;

    @OneToOne
    @JoinColumn(name = "details_id",
            unique=true)
    private PersonDetails personDetails;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
