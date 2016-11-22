package pl.polsl.service;

import pl.polsl.model.AuthorEntity;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
public interface AuthorService {
    public AuthorEntity create(AuthorEntity author);
    public List<AuthorEntity> findAll();
    public AuthorEntity findById(int id);
    public List<AuthorEntity> findBySurname(String surname);
}
