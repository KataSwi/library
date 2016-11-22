package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.polsl.model.AuthorEntity;
import pl.polsl.service.AuthorService;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorEntity> createAuthor(@RequestBody AuthorEntity author){
        AuthorEntity createdAuthor = authorService.create(author);
        return new ResponseEntity<AuthorEntity>(createdAuthor,HttpStatus.OK);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorEntity>> getAllAuthors(){
        List<AuthorEntity> allAutors = authorService.findAll();
        return new ResponseEntity<List<AuthorEntity>>(allAutors,HttpStatus.OK);
    }


}
