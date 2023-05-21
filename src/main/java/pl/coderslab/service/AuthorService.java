package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    private AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(Author author) {
        authorDao.save(author);
    }

    public Author findById(Long id) {
        return authorDao.findById(id);
    }
    // wyszukiwanie wszystkich:
    public List<Author> findAll(){
        return authorDao.findAll();
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void deleteById(Long id) {
        authorDao.deleteById(id);
    }


}
