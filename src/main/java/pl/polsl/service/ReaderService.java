package pl.polsl.service;

import pl.polsl.dto.ReaderDTO;

import java.util.List;

/**
 * Created by Katarzyna on 30.11.2016.
 */
public interface ReaderService {
    List<ReaderDTO> findAllReaders();
    ReaderDTO findReaderByCardNumber(long cardNumber);
    ReaderDTO findReaderByUserName(String userName);
}
