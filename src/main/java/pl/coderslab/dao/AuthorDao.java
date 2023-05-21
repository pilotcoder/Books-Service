package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author author){
        entityManager.persist(author);

    }
    public Author findById(Long id){
        return entityManager.find(Author.class, id);
    }
    public void update(Author author){
        entityManager.merge(author);

    }
    // Wyszukiwanie wszystkich :
    public List<Author> findAll(){
        return entityManager.createQuery("select a from Author a")
                .getResultList();
    }
    public void deleteById(Long id){
        Author author = findById(id);
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author) );
    }
}
