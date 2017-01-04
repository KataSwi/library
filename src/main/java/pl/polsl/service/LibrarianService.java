package pl.polsl.service;

import pl.polsl.dto.LibrarianDTO;

/**
 * Created by Katarzyna on 06.12.2016.
 */
public interface LibrarianService {
    LibrarianDTO getLibrarian(Long librarianId);
}
