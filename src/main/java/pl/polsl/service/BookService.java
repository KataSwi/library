package pl.polsl.service;

import pl.polsl.dto.BookDTO;

import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    List<BookDTO> findAllBooks();
    List<BookDTO> findBookByTitle(String title);
}
