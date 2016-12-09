package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.GenreDTO;
import pl.polsl.service.GenreService;

import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
@RequestMapping("/genres")
@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genre){
        GenreDTO createdGenre = genreService.createGenre(genre);
        return new ResponseEntity<GenreDTO>(createdGenre, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GenreDTO>> getAllGenres(){
        List<GenreDTO> allGenres = genreService.findAllGenres();
        return new ResponseEntity<List<GenreDTO>>(allGenres,HttpStatus.OK);
    }

    @RequestMapping(value = "/{type}/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> getGenreByType(@PathVariable("type") String type){
        GenreDTO foundGenre = genreService.findGenreType(type);
        return new ResponseEntity<GenreDTO>(foundGenre,HttpStatus.OK);
    }

}
