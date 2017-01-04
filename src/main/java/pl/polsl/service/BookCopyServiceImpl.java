package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.BookCopyDTO;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.dto.ReservationDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.BookcopyEntity;
import pl.polsl.model.BorrowedbooksEntity;
import pl.polsl.model.ReservationEntity;
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

    //TODO
    // dodac sprawdzanie czy data rezerwacji minela
    // w zasadzie to jesli minela to zmienic na anulowana rezerwacja i zmienic status ksiazki na dostepny, ale gdzie to zrobic?
    @Override
    public BorrowedBooksDTO addNewBorrowing(BorrowedBooksDTO borrowedBooksDTO) {
        if(borrowedBooksDTO == null){
            return null;
        }

        BorrowedbooksEntity borrowedbooksEntity = libraryMapper.toBorrowedBooksEntity(borrowedBooksDTO);
        BookcopyEntity bookcopyEntity = bookCopyRepository.findByInventory(borrowedbooksEntity.getBookInventory());
        ReservationEntity reservationEntity = reservationRepository.findByReaderCardAndReservedBook(borrowedbooksEntity.getReaderCard(),borrowedbooksEntity.getBookInventory());

        if(bookcopyEntity.getState() == 2){
            return null;
        }

        if(bookcopyEntity.getState() == 3){
            if(reservationEntity == null){
                return null;
            }
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        borrowedbooksEntity.setBorrowedDate(timestamp);
        borrowedbooksEntity.setReturnDate(setReturnDateTimestamp());
        setBookStatusAsBorrowed(borrowedbooksEntity.getBookInventory());
        borrowedbooksEntity = borrowedBooksRepository.save(borrowedbooksEntity);
        return libraryMapper.toBorrowedBooksDTO(borrowedbooksEntity);
    }

    @Override
    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        if(reservationDTO == null){
            return null;
        }
        ReservationEntity newReservation = libraryMapper.toReservationEntity(reservationDTO);
        BookcopyEntity bookcopyEntity = bookCopyRepository.findByInventory(newReservation.getReservedBook());

        if((bookcopyEntity.getState() == 2) || (bookcopyEntity.getState() == 3)){
            return null;
        }
        newReservation.setExpDate(setReservationExpDateTimestamp());
        setBookStatusAsReserved(newReservation.getReservedBook());
        newReservation = reservationRepository.save(newReservation);
        return libraryMapper.toReservationDTO(newReservation);
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

    private Timestamp setReservationExpDateTimestamp(){
        Timestamp date = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, 7);
        date.setTime(cal.getTimeInMillis());
        date = new Timestamp(cal.getTimeInMillis());
        return date;
    }

}
