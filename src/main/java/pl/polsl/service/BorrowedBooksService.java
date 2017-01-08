package pl.polsl.service;

import pl.polsl.dto.BorrowedBooksDTO;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Katarzyna on 18.12.2016.
 */
public interface BorrowedBooksService {
    List<BorrowedBooksDTO> findAllBorrowings();
    List<BorrowedBooksDTO> findByReturnDateExpired();
    List<BorrowedBooksDTO> findReaderBorrowings(long readerCard);
    List<BorrowedBooksDTO> findReaderBorrowingsExpired(long readerCard);
}
