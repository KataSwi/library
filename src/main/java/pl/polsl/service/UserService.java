package pl.polsl.service;

import pl.polsl.dto.LibrarianDTO;
import pl.polsl.dto.ReaderDTO;
import pl.polsl.dto.UserDTO;
import pl.polsl.model.UsersEntity;

import java.util.List;

/**
 * Created by Katarzyna on 27.11.2016.
 */
public interface UserService {
    UserDTO createUser(UserDTO user);
    List<UserDTO> findAllUsers();
    UserDTO findByUserUserName(String userName);
    List<UserDTO> findByUserSurname(String userSurname);
    ReaderDTO createReader(ReaderDTO readerDTO);
    LibrarianDTO createLibrarian(LibrarianDTO librarianDTO);

}
