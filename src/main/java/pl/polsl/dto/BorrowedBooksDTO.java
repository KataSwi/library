package pl.polsl.dto;

import java.sql.Timestamp;

/**
 * Created by Katarzyna on 08.12.2016.
 */
public class BorrowedBooksDTO {
    private int borrowid;
    private long readerCard;
    private long bookInventory;
    private BookCopyDTO bookCopyDTO;
    private Timestamp borrowedDate;
    private Timestamp returnDate;
    private int state;


    public int getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(int borrowid) {
        this.borrowid = borrowid;
    }

    public BookCopyDTO getBookCopyDTO() {
        return bookCopyDTO;
    }

    public void setBookCopyDTO(BookCopyDTO bookCopyDTO) {
        this.bookCopyDTO = bookCopyDTO;
    }

    public Timestamp getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Timestamp borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public long getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(long readerCard) {
        this.readerCard = readerCard;
    }

    public long getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(long bookInventory) {
        this.bookInventory = bookInventory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
