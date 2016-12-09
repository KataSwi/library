package pl.polsl.service;

import pl.polsl.dto.AuthorDTO;
import pl.polsl.model.AuthorEntity;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
public interface AuthorService {
    AuthorDTO create(AuthorDTO author);
    List<AuthorDTO> findAll();
    AuthorDTO findById(int id);
    List<AuthorDTO> findBySurname(String surname);
}
