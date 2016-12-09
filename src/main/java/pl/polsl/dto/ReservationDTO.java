package pl.polsl.dto;

import java.sql.Timestamp;

/**
 * Created by Katarzyna on 08.12.2016.
 */
public class ReservationDTO {
    private int reservationid;
    private Timestamp expDate;
    private long bookInventory;
    private BookCopyDTO bookCopyDTO;
    private long readerCard;
    private ReaderDTO readerDTO;

    public int getReservationid() {
        return reservationid;
    }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    public BookCopyDTO getBookCopyDTO() {
        return bookCopyDTO;
    }

    public void setBookCopyDTO(BookCopyDTO bookCopyDTO) {
        this.bookCopyDTO = bookCopyDTO;
    }

    public ReaderDTO getReaderDTO() {
        return readerDTO;
    }

    public void setReaderDTO(ReaderDTO readerDTO) {
        this.readerDTO = readerDTO;
    }

    public long getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(long bookInventory) {
        this.bookInventory = bookInventory;
    }

    public long getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(long readerCard) {
        this.readerCard = readerCard;
    }
}
