package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.LibrarianDTO;
import pl.polsl.service.LibrarianService;

import java.util.List;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/librarian")
public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LibrarianDTO>> getAllLibrarians(){
        List<LibrarianDTO> foundLibrarians = librarianService.findAllLibrarians();
        return new ResponseEntity<List<LibrarianDTO>>(foundLibrarians,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/find",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibrarianDTO> getLibrarian(@PathVariable("id") long librarianId){
        LibrarianDTO foundLibrarian = librarianService.findLibrarian(librarianId);
        return new ResponseEntity<LibrarianDTO>(foundLibrarian,HttpStatus.OK);
    }

}
