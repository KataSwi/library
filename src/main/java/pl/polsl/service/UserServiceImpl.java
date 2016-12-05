package pl.polsl.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public UsersEntity create(UsersEntity user) {
        UsersEntity newUser = user;
        return userRepository.save(user);
    }

    @Override
    public List<UsersEntity> findAll() {
        Iterable<UsersEntity> users = userRepository.findAll();
        List<UsersEntity> result = new ArrayList<>();
        users.forEach(user -> {result.add(user);});
        return result;
    }

    @Override
    public UsersEntity findByUserUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UsersEntity> findByUserSurname(String userSurname) {
        return userRepository.findBySurname(userSurname);
    }
}
