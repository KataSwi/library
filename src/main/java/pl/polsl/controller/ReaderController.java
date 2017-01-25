package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.ReaderDTO;
import pl.polsl.model.ReaderEntity;
import pl.polsl.service.ReaderService;

import java.util.List;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/reader")
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/{id}/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReaderDTO> getReader(@PathVariable("id") Long cardNumber){
        ReaderDTO foundReader = readerService.findReaderByCardNumber(cardNumber);
        return new ResponseEntity<ReaderDTO>(foundReader,HttpStatus.OK);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReaderDTO>> getAllReaders(){
        List<ReaderDTO> foundReaders = readerService.findAllReaders();
        return new ResponseEntity<List<ReaderDTO>>(foundReaders,HttpStatus.OK);
    }
}
