package pl.polsl.service;

import org.springframework.stereotype.Service;
import pl.polsl.dto.BookCopyDTO;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.dto.ReservationDTO;
import pl.polsl.model.BookcopyEntity;

import java.util.List;

/**
 * Created by Katarzyna on 17.12.2016.
 */

public interface BookCopyService {
    BookCopyDTO createBookCopy(BookCopyDTO bookCopyDTO);
    List<BookCopyDTO> findAllBookCopies();
    BookCopyDTO findByInventoryNumber(long id);
    List<BookCopyDTO> findBookCopiesByIsbn(String isbn);
    List<BookCopyDTO> findBookCopiesByState(String isbn, int state);
    List<BookCopyDTO> findBookCopiesByTitle(String title);
    BorrowedBooksDTO addNewBorrowing(BorrowedBooksDTO borrowedBooksDTO);
    ReservationDTO addReservation(ReservationDTO reservationDTO);
    BorrowedBooksDTO returnBookCopy(BorrowedBooksDTO borrowedBooksDTO);

}
