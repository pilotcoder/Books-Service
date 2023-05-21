package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor // dodaje kostruktor do finali

public class BookService {

    private final BookDao bookDao;
    private final PublisherService publisherService; // przy relacjach muszę stworzyć publiszera zeby dało mu Id
    private final AuthorService authorService;




    public void save(Book book) {
        Publisher publisher = book.getPublisher();  // przy relacjach muszę stworzyć publiszera zeby dało mu Id
        publisherService.save(publisher);
        List<Author>  authorList = book.getAuthors();

        List<Author> filteredAuthors = authorList.stream()
                        .filter(a -> authorService.findById(a.getId()) != null)
                                .collect(Collectors.toList());
        book.setAuthors(filteredAuthors);

        bookDao.save(book);

    }

    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    //wyszukanie wszystkich książek
    public List<Book> findAll() {
        return bookDao.findAll();
    }
    //o ratingu
    public List<Book> findByRating(int rating) {
        return bookDao.findByRating(rating);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }

    //wyszukiwanie takiego który ma choć jednego wydawcę :
    public List<Book> findBooksWithPublisher() {
        return bookDao.findBooksWithPublisher();
    }
}