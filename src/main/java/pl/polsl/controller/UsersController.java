package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.dto.UserDTO;
import pl.polsl.model.UsersEntity;
import pl.polsl.service.UserService;

import java.util.List;

/**
 * Created by Katarzyna on 27.11.2016.
 */
@RequestMapping(value = "/users")
@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createAuthor(@RequestBody UserDTO user){
        UserDTO createdUser = userService.createUser(user);
        return new ResponseEntity<UserDTO>(createdUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllAuthors(){
        List<UserDTO> allUsers = userService.findAllUsers();
        return new ResponseEntity<List<UserDTO>>(allUsers,HttpStatus.OK);
    }

}
