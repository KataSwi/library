package pl.polsl.service;

import pl.polsl.dto.BorrowedBooksDTO;

import java.util.List;

/**
 * Created by Katarzyna on 18.12.2016.
 */
public interface BorrowedBooksService {
    BorrowedBooksDTO addNewBorrowing(BorrowedBooksDTO borrowedBooksDTO);
    List<BorrowedBooksDTO> findAllBorrowings();
}
