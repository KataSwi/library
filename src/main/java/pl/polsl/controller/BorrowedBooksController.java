package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.dto.BorrowedBooksDTO;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BorrowedBooksDTO> addNewBorrowedBook(@RequestBody BorrowedBooksDTO newBorrow){
        BorrowedBooksDTO borrowedBooksDTO = borrowedBooksService.addNewBorrowing(newBorrow);
        return new ResponseEntity<BorrowedBooksDTO>(borrowedBooksDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BorrowedBooksDTO>> getAllBorrowings(){
        List<BorrowedBooksDTO> borrowedBooksDTOs = borrowedBooksService.findAllBorrowings();
        return new ResponseEntity<List<BorrowedBooksDTO>>(borrowedBooksDTOs,HttpStatus.OK);
    }
}
