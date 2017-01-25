package pl.polsl.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.LibrarianDTO;
import pl.polsl.dto.ReaderDTO;
import pl.polsl.dto.UserDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.LibrarianEntity;
import pl.polsl.model.ReaderEntity;
import pl.polsl.model.UsersEntity;
import pl.polsl.repository.LibrarianRepository;
import pl.polsl.repository.ReaderRepository;
import pl.polsl.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarzyna on 27.11.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public UserDTO createUser(UserDTO user) {
        if(user == null){
            return null;
        }
        UsersEntity usersEntity = libraryMapper.toUsersEntity(user);
        usersEntity = userRepository.save(usersEntity);
        return libraryMapper.toUserDTO(usersEntity);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UsersEntity> users = userRepository.findAll();
        List<UserDTO> result = libraryMapper.toUserDTOList(users);
        return result;
    }

    @Override
    public UserDTO findByUserUserName(String userName) {
        UsersEntity user = userRepository.findByUserName(userName);
        return libraryMapper.toUserDTO(user);
    }

    @Override
    public List<UserDTO> findByUserSurname(String userSurname) {
        List<UsersEntity> users = userRepository.findBySurname(userSurname);
        return libraryMapper.toUserDTOList(users);
    }

    @Override
    public ReaderDTO createReader(ReaderDTO readerDTO) {
        if(readerDTO == null){
            return null;
        }
        ReaderEntity newReader = libraryMapper.toReaderEntity(readerDTO);
        newReader.setCardNumber(generateReaderCardNumber());
        newReader = readerRepository.save(newReader);
        return libraryMapper.toReaderDTO(newReader);
    }

    @Override
    public LibrarianDTO createLibrarian(LibrarianDTO librarianDTO) {
        if(librarianDTO == null){
            return null;
        }
        LibrarianEntity librarianEntity = libraryMapper.toLibrarianEntity(librarianDTO);
        librarianEntity = librarianRepository.save(librarianEntity);
        return libraryMapper.toLibrarianDTO(librarianEntity);
    }

    private long generateReaderCardNumber(){
        long leftLimit = 100000L;
        long rightLimit = 999999L;
        long generatedLong = 0;
        boolean notExists = false;

        while(!notExists){
            generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit + 1));
            ReaderEntity readerEntity = readerRepository.findOne(generatedLong);
            if (readerEntity == null){
                notExists = true;
            }
        }
        return generatedLong;
    }
}
