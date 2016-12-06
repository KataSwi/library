package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.LibrarianDTO;
import pl.polsl.service.LibrarianService;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/librarian")
public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibrarianDTO> createLibrarian(@RequestBody LibrarianDTO librarianDTO){
        librarianDTO = librarianService.saveLibrarian(librarianDTO);
        return new ResponseEntity<LibrarianDTO>(librarianDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/find",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibrarianDTO> findLibrarian(@PathVariable("id") long librarianId){
        LibrarianDTO foundLibrarian = librarianService.getLibrarian(librarianId);
        return new ResponseEntity<LibrarianDTO>(foundLibrarian,HttpStatus.OK);
    }

}
