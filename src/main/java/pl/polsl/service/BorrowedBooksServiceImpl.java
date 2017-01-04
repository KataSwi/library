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
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<BorrowedBooksDTO> findAllBorrowings() {
        List<BorrowedbooksEntity> borrowings = borrowedBooksRepository.findAll();
        return libraryMapper.toBorrowedBooksDTOList(borrowings);
    }

    //TODO
    //poprawić poprzez dodanie pola o statusie wypozyczenia!!!!
    @Override
    public List<BorrowedBooksDTO> findByReturnDateExpired() {
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<BorrowedbooksEntity> borrowedbooksEntities = borrowedBooksRepository.findByReturnDateBefore(setReturnDateTimestamp());

        List<BookcopyEntity> copies = new ArrayList<>();
        List<BorrowedbooksEntity> borrowedAndNotReturned = new ArrayList<>();

        for (BorrowedbooksEntity borrow:borrowedbooksEntities) {
            copies = bookCopyRepository.findByStateAndInventory(2,borrow.getBookInventory());
        }

        for(BookcopyEntity copy: copies){
            for(BorrowedbooksEntity borrow: borrowedbooksEntities){
                if(copy.getInventory() == borrow.getBookInventory()){
                    borrowedAndNotReturned.add(borrow);
                }
            }
        }
        List<BorrowedBooksDTO> result = libraryMapper.toBorrowedBooksDTOList(borrowedAndNotReturned);
        return result;
    }

    @Override
    public List<BorrowedBooksDTO> findReaderBorrowings(long readerCard) {
        List<BorrowedbooksEntity> borrowedbooksEntities = borrowedBooksRepository.findByReaderCard(readerCard);
        List<BorrowedBooksDTO> result = libraryMapper.toBorrowedBooksDTOList(borrowedbooksEntities);
        return result;
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

}
