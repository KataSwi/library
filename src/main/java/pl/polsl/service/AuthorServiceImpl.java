package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.AuthorDTO;
import pl.polsl.mapper.BookMapper;
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

    @Autowired
    private BookMapper bookMapper;

    @Override
    public AuthorDTO create(AuthorDTO author) {
        if(author == null){
            return null;
        }
        AuthorEntity authorEntity = bookMapper.toAuthorEntity(author);
        authorEntity = authorRepository.save(authorEntity);
        return bookMapper.toAuthorDTO(authorEntity);
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<AuthorEntity> authors = authorRepository.findAll();
        List<AuthorDTO> result = bookMapper.toAuthorDTOList(authors);
        return result;
    }

    @Override
    public AuthorDTO findById(int id) {
        AuthorEntity author = authorRepository.findOne(id);
        return bookMapper.toAuthorDTO(author);
    }

    @Override
    public List<AuthorDTO> findBySurname(String surname) {
        List<AuthorEntity> foundAuthors = authorRepository.findByAuthorSurname(surname);
        return bookMapper.toAuthorDTOList(foundAuthors);
    }
}
