package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.model.UsersEntity;
import pl.polsl.service.UserService;

import java.util.List;

/**
 * Created by Katarzyna on 27.11.2016.
 */
@RequestMapping("/users")
@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersEntity> createAuthor(@RequestBody UsersEntity user){
        UsersEntity createdUser = userService.create(user);
        return new ResponseEntity<UsersEntity>(createdUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsersEntity>> getAllAuthors(){
        List<UsersEntity> allUsers = userService.findAll();
        return new ResponseEntity<List<UsersEntity>>(allUsers,HttpStatus.OK);
    }

}
