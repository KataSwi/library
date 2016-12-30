package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.BorrowedbooksEntity;
import pl.polsl.repository.BorrowedBooksRepository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Katarzyna on 18.12.2016.
 */
@Service
public class BorrowedBooksServiceImpl implements BorrowedBooksService {

    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<BorrowedBooksDTO> findAllBorrowings() {
        List<BorrowedbooksEntity> borrowings = borrowedBooksRepository.findAll();
        return libraryMapper.toBorrowedBooksDTOList(borrowings);
    }

    @Override
    public List<BorrowedBooksDTO> findByReturnDateExpired() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<BorrowedbooksEntity> borrowedbooksEntities = borrowedBooksRepository.findByReturnDateBefore(timestamp);
        List<BorrowedBooksDTO> result = libraryMapper.toBorrowedBooksDTOList(borrowedbooksEntities);
        return result;
    }

    @Override
    public List<BorrowedBooksDTO> findReaderBorrowings(long readerCard) {
        List<BorrowedbooksEntity> borrowedbooksEntities = borrowedBooksRepository.findByReaderCard(readerCard);
        List<BorrowedBooksDTO> result = libraryMapper.toBorrowedBooksDTOList(borrowedbooksEntities);
        return result;
    }




}
