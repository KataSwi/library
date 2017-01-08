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
    private int state;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
