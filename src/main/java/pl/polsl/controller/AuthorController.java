package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.model.AuthorEntity;
import pl.polsl.service.AuthorService;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@RequestMapping(value = "/authors")
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

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorEntity>> getAllAuthors(){
        List<AuthorEntity> allAutors = authorService.findAll();
        return new ResponseEntity<List<AuthorEntity>>(allAutors,HttpStatus.OK);
    }

    @RequestMapping(value = "/{authorSurname}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorEntity>> getAuthorBySurname(@PathVariable("authorSurname") String surname){
        List<AuthorEntity> allAutors = authorService.findBySurname(surname);
        return new ResponseEntity<List<AuthorEntity>>(allAutors,HttpStatus.OK);
    }


}
