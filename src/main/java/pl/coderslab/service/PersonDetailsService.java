package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.PersonDetails;

@Service
@Transactional
public class PersonDetailsService {
    private PersonDetailsDao personDetailsDao;

    public PersonDetailsService(PersonDetailsDao personDetailsDao) {
        this.personDetailsDao = personDetailsDao;
    }

    public void save(PersonDetails personDetails) {
        personDetailsDao.save(personDetails);
    }

    public PersonDetails findById(Long id) {
        return personDetailsDao.findById(id);
    }

    public void update(PersonDetails personDetails) {
        personDetailsDao.update(personDetails);
    }

    public void deleteById(Long id) {
        personDetailsDao.deleteById(id);
    }

}
