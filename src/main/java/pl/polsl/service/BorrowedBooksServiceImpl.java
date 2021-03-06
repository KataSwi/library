package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.BookcopyEntity;
import pl.polsl.model.BorrowedbooksEntity;
import pl.polsl.repository.BookCopyRepository;
import pl.polsl.repository.BorrowedBooksRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
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
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp = setReturnDateTimestamp();
        List<BorrowedbooksEntity> borrowedbooksEntities = borrowedBooksRepository.findByBorrowingStateAndReturnDateBefore(1,timestamp);
        List<BorrowedBooksDTO> result = libraryMapper.toBorrowedBooksDTOList(borrowedbooksEntities);
        return result;
    }

    @Override
    public List<BorrowedBooksDTO> findReaderBorrowings(long readerCard) {
        List<BorrowedbooksEntity> borrowedbooksEntities = borrowedBooksRepository.findByReaderCard(readerCard);
        List<BorrowedBooksDTO> result = libraryMapper.toBorrowedBooksDTOList(borrowedbooksEntities);
        return result;
    }

    @Override
    public List<BorrowedBooksDTO> findReaderBorrowingsExpired(long readerCard) {
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp = setReturnDateTimestamp();
        List<BorrowedbooksEntity> borrowedbooksEntities = borrowedBooksRepository.findByReaderCardAndBorrowingStateAndReturnDateBefore(readerCard,1,timestamp);
        List<BorrowedBooksDTO> borrowedBooksDTOs = libraryMapper.toBorrowedBooksDTOList(borrowedbooksEntities);
        return borrowedBooksDTOs;
    }

    @Override
    public BorrowedBooksDTO updateReturnDate(long inventory) {
        BorrowedbooksEntity borrowedbooksEntity = borrowedBooksRepository.findByBookInventoryAndBorrowingState(inventory,1);
        if(borrowedbooksEntity == null){
            return null;
        }
        Timestamp timestamp = setProlongateDate(borrowedbooksEntity.getReturnDate());
        borrowedbooksEntity.setReturnDate(timestamp);
        borrowedbooksEntity = borrowedBooksRepository.save(borrowedbooksEntity);
        return libraryMapper.toBorrowedBooksDTO(borrowedbooksEntity);
    }

    private Timestamp setReturnDateTimestamp(){
        Timestamp date = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, 30);
        date.setTime(cal.getTimeInMillis());
        date = new Timestamp(cal.getTimeInMillis());
        return date;
    }

    private Timestamp setProlongateDate(Timestamp date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, 14);
        date.setTime(cal.getTimeInMillis());
        date = new Timestamp(cal.getTimeInMillis());
        return date;
    }

}
