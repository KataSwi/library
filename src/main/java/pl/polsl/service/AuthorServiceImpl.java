package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.model.AuthorEntity;
import pl.polsl.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorEntity create(AuthorEntity author) {
        AuthorEntity newAuthor = author;
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorEntity> findAll() {
        Iterable<AuthorEntity> authors = authorRepository.findAll();
        List<AuthorEntity> result = new ArrayList<>();
        authors.forEach(author -> {result.add(author);});
        return result;
    }

    @Override
    public AuthorEntity findById(int id) {
        return authorRepository.findOne(id);
    }

    @Override
    public List<AuthorEntity> findBySurname(String surname) {
        return null;
    }
}
