package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.BookCopyDTO;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.BookcopyEntity;
import pl.polsl.model.BorrowedbooksEntity;
import pl.polsl.repository.BookCopyRepository;
import pl.polsl.repository.BorrowedBooksRepository;
import pl.polsl.repository.ReservationRepository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Katarzyna on 17.12.2016.
 */
@Service
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LibraryMapper libraryMapper;


    @Override
    public BookCopyDTO createBookCopy(BookCopyDTO bookCopyDTO) {
        if (bookCopyDTO == null){
            return null;
        }
        BookcopyEntity bookcopyEntity = libraryMapper.toBookCopyEntity(bookCopyDTO);
        bookcopyEntity = bookCopyRepository.save(bookcopyEntity);
        return libraryMapper.toBookCopyDTO(bookcopyEntity);
    }

    @Override
    public List<BookCopyDTO> findAllBookCopies() {
        List<BookcopyEntity> bookcopyEntities = bookCopyRepository.findAll();
        return libraryMapper.toBookCopyDTOList(bookcopyEntities);
    }

    @Override
    public BookCopyDTO findByInventoryNumber(long id) {
        BookcopyEntity bookcopyEntity = bookCopyRepository.findByInventory(id);
        return libraryMapper.toBookCopyDTO(bookcopyEntity);
    }

    @Override
    public List<BookCopyDTO> findBookCopiesByIsbn(String isbn) {
        List<BookcopyEntity> bookcopyEntities = bookCopyRepository.findByIsbn(isbn);
        return libraryMapper.toBookCopyDTOList(bookcopyEntities);
    }

    @Override
    public List<BookCopyDTO> findBookCopiesByState(String isbn, int state) {
        List<BookcopyEntity> bookcopyEntities = bookCopyRepository.findByStateAndIsbn(state,isbn);
        return libraryMapper.toBookCopyDTOList(bookcopyEntities);
    }

    @Override
    public BorrowedBooksDTO addNewBorrowing(BorrowedBooksDTO borrowedBooksDTO) {
        if(borrowedBooksDTO == null){
            return null;
        }
        BorrowedbooksEntity borrowedbooksEntity = libraryMapper.toBorrowedBooksEntity(borrowedBooksDTO);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        borrowedbooksEntity.setBorrowedDate(timestamp);
        borrowedbooksEntity.setReturnDate(setReturnDateTimestamp());
        borrowedbooksEntity = borrowedBooksRepository.save(borrowedbooksEntity);
        return libraryMapper.toBorrowedBooksDTO(borrowedbooksEntity);
    }

    @Override
    public BookcopyEntity setBookStatusAsBorrowed(long inventory) {
        BookcopyEntity bookcopyEntity = bookCopyRepository.findByInventory(inventory);
        bookcopyEntity.setState(2);
        bookcopyEntity = bookCopyRepository.save(bookcopyEntity);
        return bookcopyEntity;
    }

    @Override
    public BookCopyDTO setBookStatusAsReturned(long inventory) {
        BookcopyEntity bookcopyEntity = bookCopyRepository.findByInventory(inventory);
        bookcopyEntity.setState(1);
        bookcopyEntity = bookCopyRepository.save(bookcopyEntity);
        return libraryMapper.toBookCopyDTO(bookcopyEntity);
    }

    @Override
    public BookcopyEntity setBookStatusAsReserved(long inventory) {
        BookcopyEntity bookcopyEntity = bookCopyRepository.findByInventory(inventory);
        bookcopyEntity.setState(3);
        bookcopyEntity = bookCopyRepository.save(bookcopyEntity);
        return bookcopyEntity;
    }

    private Timestamp setReturnDateTimestamp(){
        Timestamp date = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, 14);
        date.setTime(cal.getTimeInMillis());
        date = new Timestamp(cal.getTimeInMillis());
        return date;
    }

}
