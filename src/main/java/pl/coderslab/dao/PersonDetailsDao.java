package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(PersonDetails person){
        entityManager.persist(person);
    }

    public PersonDetails findById(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void update(PersonDetails person) {
        entityManager.merge(person);
    }

    public void deleteById(Long id) {
        PersonDetails person = findById(id);
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }
}
