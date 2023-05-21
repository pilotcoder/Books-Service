package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.service.AuthorService;

import java.util.List;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    void save(@RequestParam String firstName, @RequestParam String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorService.save(author);
    }
    @GetMapping("/author/{id}")
    public Author read(@PathVariable Long id){
        Author author = new Author();
        author = authorService.findById(id);
        return author;
    }
    @PostMapping("/author/update")
    public void update(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName){
        Author author = new Author();
        author = authorService.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorService.update(author);
    }
    @PostMapping("/author/delete")
    public void delete(@RequestParam Long id){
        authorService.deleteById(id);
    }

    // Wyszykiwanie wszystkich:
    @GetMapping(path = "/authors", produces = "text/plain;charset=utf-8")
    String findAll() {

        final List<Author> authorList = authorService.findAll();

        return authorList.toString();
    }


}
