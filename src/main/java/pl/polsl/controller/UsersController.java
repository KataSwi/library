package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.LibrarianDTO;
import pl.polsl.dto.ReaderDTO;
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

    @RequestMapping(value = "/admin/create",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO createdUser = userService.createUser(user);
        return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reader/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReaderDTO> createReader(@RequestBody ReaderDTO readerDTO){
        ReaderDTO createdReader = userService.createReader(readerDTO);
        return new ResponseEntity<ReaderDTO>(createdReader,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/librarian/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibrarianDTO> createLibrarian(@RequestBody LibrarianDTO librarianDTO){
        LibrarianDTO createdLibrarian = userService.createLibrarian(librarianDTO);
        return new ResponseEntity<LibrarianDTO>(createdLibrarian,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> allUsers = userService.findAllUsers();
        return new ResponseEntity<List<UserDTO>>(allUsers,HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable("username") String username){
        UserDTO userDTO = userService.findByUserUserName(username);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        UserDTO updated = userService.updateUser(userDTO);
        return new ResponseEntity<UserDTO>(updated,HttpStatus.OK);
    }


}
