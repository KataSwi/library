package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.AuthorDTO;
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
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO author){
        AuthorDTO createdAuthor = authorService.create(author);
        return new ResponseEntity<AuthorDTO>(createdAuthor,HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){
        List<AuthorDTO> allAutors = authorService.findAll();
        return new ResponseEntity<List<AuthorDTO>>(allAutors,HttpStatus.OK);
    }

    @RequestMapping(value = "/{authorSurname}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorDTO>> getAuthorBySurname(@PathVariable("authorSurname") String surname){
        List<AuthorDTO> allAutors = authorService.findBySurname(surname);
        return new ResponseEntity<List<AuthorDTO>>(allAutors,HttpStatus.OK);
    }


}
