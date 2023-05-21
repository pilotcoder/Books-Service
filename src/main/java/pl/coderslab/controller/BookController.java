package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // create book
    @PostMapping(path = "/book")
    void save(@RequestParam String title, @RequestParam int rating, @RequestParam String description, @RequestParam String publisherName, @RequestParam("authorId") Long[] authorIds) {

        final Book book = new Book();

        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        Publisher publisher = new Publisher();  // mamy relację z publiszerem
        publisher.setName(publisherName);
        book.setPublisher(publisher);
//      dodawanie autorów do ksążki
        List<Author> authorList = Arrays.stream(authorIds)
                        .map(Author:: new)
                                .collect(Collectors.toList());
        book.setAuthors(authorList);

        bookService.save(book);
    }
    @GetMapping(path = "/book/{id}", produces = "text/plain;charset=utf-8")

    public String read(@PathVariable Long id){
        Book book = new Book();
        book = bookService.findById(id);
        return book.toString();

    }
    @PostMapping("/book/update")
    public void update(@RequestParam Long id, @RequestParam String title, @RequestParam int rating, @RequestParam String description){
        Book book = new Book();
        book = bookService.findById(id);
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        bookService.update(book);
    }
    @GetMapping("/book/delete/{id}")
    public void delete(@PathVariable Long id){
        bookService.deleteById(id);
    }

    // pobieranie wszystkich książek
    @GetMapping(path = "/books", produces = "text/plain;charset=utf-8")
    String findAll() {

        final List<Book> books = bookService.findAll();

        return books.toString();
    }

    // o ratingu
    @GetMapping(path = "/books", produces = "text/plain;charset=utf-8", params = "rating")
    String findAllByRating(@RequestParam int rating) {

        final List<Book> books = bookService.findByRating(rating);

        return books.toString();
    }

    // wyszukiwania takiego który ma choś jednego wydawcę :
    @GetMapping(path = "/books/anypublisher", produces = "text/plain;charset=utf-8", params = "rating")
    String fifindBooksWithPublisher() {

        final List<Book> books = bookService.findBooksWithPublisher();

        return books.toString();
    }

}