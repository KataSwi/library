package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.dto.LibrarianDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.LibrarianEntity;
import pl.polsl.repository.LibrarianRepository;

import java.util.List;

/**
 * Created by Katarzyna on 06.12.2016.
 */
@Transactional
@Service
public class LibrarianServiceImpl implements LibrarianService {

    @Autowired
    LibrarianRepository librarianRepository;

    @Autowired
    LibraryMapper libraryMapper;

    @Override
    public LibrarianDTO findLibrarian(Long librarianId) {
        LibrarianEntity librarianEntity = librarianRepository.findOne(librarianId);
        return libraryMapper.toLibrarianDTO(librarianEntity);
    }

    @Override
    public List<LibrarianDTO> findAllLibrarians() {
        List<LibrarianEntity> librarianEntities = librarianRepository.findAll();
        return libraryMapper.toLibrarianDTOList(librarianEntities);
    }
}
