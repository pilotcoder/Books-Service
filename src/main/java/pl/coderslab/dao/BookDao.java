package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }
    // wyszykiwanie wszystkich książek
    public List<Book> findAll() {
        return entityManager.createQuery("select b from Book b")
                .getResultList();
    }
// o ratingu
    public List<Book> findByRating(int rating) {
        return entityManager.createQuery("select b from Book b where b.rating = :rating")
                .setParameter("rating", rating)
                .getResultList();
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void deleteById(Long id) {
        Book book = findById(id);
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    // wyszukiwanie takiego która ma choć jesnego wydawcę
    public List<Book> findBooksWithPublisher(){
        return entityManager
                .createQuery("SELECT b FROM Book b where b.authors IS NOT EMPTY")
                .getResultList();
    }

    // o określonym wydawcy:

    public List<Book> findBooksWithPublisher(Publisher publisher) {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.publisher in :publisher")
                .setParameter("publisher", publisher)
                .getResultList();
    }
    // o określonym autorze

    public List<Book> findBooksWithAuthor(Author author) {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.publisher in :author")
                .setParameter("author", author)
                .getResultList();
    }

}