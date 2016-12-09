package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.dto.BookDTO;
import pl.polsl.service.BookService;

import java.util.List;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO book){
        BookDTO createdBook = bookService.createBook(book);
        return new ResponseEntity<BookDTO>(createdBook, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> foundBooks = bookService.findAllBooks();
        return new ResponseEntity<List<BookDTO>>(foundBooks,HttpStatus.OK);
    }

    @RequestMapping(value = "/{title}/find",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getBookByTitle(@PathVariable String title){
        List<BookDTO> foundBooks = bookService.findBookByTitle(title);
        return new ResponseEntity<List<BookDTO>>(foundBooks,HttpStatus.OK);
    }


}
