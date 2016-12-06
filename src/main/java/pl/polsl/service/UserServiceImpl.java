package pl.polsl.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.UserDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.UsersEntity;
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
        return null;
        //return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserDTO> findByUserSurname(String userSurname) {
        return null;
        //return userRepository.findBySurname(userSurname);
    }
}
