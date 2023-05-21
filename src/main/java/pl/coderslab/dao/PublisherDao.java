package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher publisher){
        entityManager.persist(publisher);

    }
    public Publisher findById(Long id){

        return entityManager.find(Publisher.class, id);
    }

    // pobieranie wszystkich
    public List<Publisher> findAll() {
        return entityManager.createQuery("select p from Publisher p")
                .getResultList();
    }

    public void update(Publisher publisher){
        entityManager.merge(publisher);

    }
    public void deleteById(Long id){
        Publisher publisher = findById(id);
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }



}
