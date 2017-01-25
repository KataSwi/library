package pl.polsl.service;

import pl.polsl.dto.LibrarianDTO;

import java.util.List;

/**
 * Created by Katarzyna on 06.12.2016.
 */
public interface LibrarianService {
    LibrarianDTO findLibrarian(Long librarianId);
    List<LibrarianDTO> findAllLibrarians();
}
