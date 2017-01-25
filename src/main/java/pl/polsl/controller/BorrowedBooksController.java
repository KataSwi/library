package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.service.BookCopyService;
import pl.polsl.service.BorrowedBooksService;

import java.util.List;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/borrowed")
public class BorrowedBooksController {

    @Autowired
    private BorrowedBooksService borrowedBooksService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BorrowedBooksDTO>> getAllBorrowings(){
        List<BorrowedBooksDTO> borrowedBooksDTOs = borrowedBooksService.findAllBorrowings();
        return new ResponseEntity<List<BorrowedBooksDTO>>(borrowedBooksDTOs,HttpStatus.OK);
    }

    @RequestMapping(value = "/expired", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BorrowedBooksDTO>> getExpiredBooks(){
        List<BorrowedBooksDTO> borrowedBooksDTOs = borrowedBooksService.findByReturnDateExpired();
        return new ResponseEntity<List<BorrowedBooksDTO>>(borrowedBooksDTOs,HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{card}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BorrowedBooksDTO>> getReaderBorrowings(@PathVariable long card){
        List<BorrowedBooksDTO> borrowedBooksDTOs = borrowedBooksService.findReaderBorrowings(card);
        return new ResponseEntity<List<BorrowedBooksDTO>>(borrowedBooksDTOs,HttpStatus.OK);
    }

    @RequestMapping(value = "/expired/{card}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BorrowedBooksDTO>> getReaderBorrowingsExpired(@PathVariable long card){
        List<BorrowedBooksDTO> borrowedBooksDTOs = borrowedBooksService.findReaderBorrowingsExpired(card);
        return new ResponseEntity<List<BorrowedBooksDTO>>(borrowedBooksDTOs,HttpStatus.OK);
    }

    @RequestMapping(value = "/prolongate/{inventory}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BorrowedBooksDTO> prolongateBook(@PathVariable("inventory") long inventory){
        BorrowedBooksDTO borrowedBooksDTO = borrowedBooksService.updateReturnDate(inventory);
        return new ResponseEntity<BorrowedBooksDTO>(borrowedBooksDTO,HttpStatus.OK);
    }
}
