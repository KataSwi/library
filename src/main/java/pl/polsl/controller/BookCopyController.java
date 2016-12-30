package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.BookCopyDTO;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.service.BookCopyService;
import pl.polsl.service.BorrowedBooksService;

import java.util.List;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/bookcopy")
public class BookCopyController {

    @Autowired
    private BookCopyService bookCopyService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookCopyDTO> createBookCopy(@RequestBody BookCopyDTO bookCopyDTO){
        BookCopyDTO newCopy = bookCopyService.createBookCopy(bookCopyDTO);
        return new ResponseEntity<BookCopyDTO>(newCopy, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookCopyDTO>> getAllBookCopies(){
        List<BookCopyDTO> foundCopies = bookCopyService.findAllBookCopies();
        return new ResponseEntity<List<BookCopyDTO>>(foundCopies,HttpStatus.OK);
    }

    @RequestMapping(value = "/isbn/{isbn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookCopyDTO>> getBookCopiesByIsbn(@PathVariable String isbn){
        List<BookCopyDTO> foundCopies = bookCopyService.findBookCopiesByIsbn(isbn);
        return new ResponseEntity<List<BookCopyDTO>>(foundCopies,HttpStatus.OK);
    }

    @RequestMapping(value = "/inventory/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookCopyDTO> getBookCopyByInventory(@PathVariable long number){
        BookCopyDTO copyDTO = bookCopyService.findByInventoryNumber(number);
        return new ResponseEntity<BookCopyDTO>(copyDTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/state/{isbn}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookCopyDTO>> getBookCopiesByState(@PathVariable String isbn, @PathVariable Integer id){
        List<BookCopyDTO> foundBooks = bookCopyService.findBookCopiesByState(isbn,id);
        return new ResponseEntity<List<BookCopyDTO>>(foundBooks,HttpStatus.OK);
    }

    @RequestMapping(value = "/return", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookCopyDTO> returnBook(@RequestBody BorrowedBooksDTO borrowedBooksDTO){
        BookCopyDTO updated = bookCopyService.setBookStatusAsReturned(borrowedBooksDTO.getBookInventory());
        return new ResponseEntity<BookCopyDTO>(updated,HttpStatus.OK);
    }

    @RequestMapping(value = "/borrow", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BorrowedBooksDTO> borrowBook(@RequestBody BorrowedBooksDTO newBorrow){
        bookCopyService.setBookStatusAsBorrowed(newBorrow.getBookInventory());
        BorrowedBooksDTO borrowedBooksDTO = bookCopyService.addNewBorrowing(newBorrow);
        return new ResponseEntity<BorrowedBooksDTO>(borrowedBooksDTO, HttpStatus.OK);
    }


}
