package pl.polsl.service;

import pl.polsl.model.UsersEntity;

import java.util.List;

/**
 * Created by Katarzyna on 27.11.2016.
 */
public interface UserService {
    public UsersEntity create(UsersEntity user);
    public List<UsersEntity> findAll();
    public UsersEntity findByUserUserName(String userName);
    public List<UsersEntity> findByUserSurname(String userSurname);

}
