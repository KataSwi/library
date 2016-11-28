package pl.polsl.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "borrowedbooks", schema = "public", catalog = "library")
public class BorrowedbooksEntity {
    private int borrowid;
    private long readerCard;
    private long bookInventory;
    private Timestamp borrowedDate;
    private Timestamp returnDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowid", nullable = false)
    public int getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(int borrowid) {
        this.borrowid = borrowid;
    }

    @Basic
    @Column(name = "reader_card", nullable = false)
    public long getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(long readerCard) {
        this.readerCard = readerCard;
    }

    @Basic
    @Column(name = "book_inventory", nullable = false)
    public long getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(long bookInventory) {
        this.bookInventory = bookInventory;
    }

    @Basic
    @Column(name = "borrowed_date", nullable = true)
    public Timestamp getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Timestamp borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    @Basic
    @Column(name = "return_date", nullable = true)
    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BorrowedbooksEntity that = (BorrowedbooksEntity) o;

        if (borrowid != that.borrowid) return false;
        if (readerCard != that.readerCard) return false;
        if (bookInventory != that.bookInventory) return false;
        if (borrowedDate != null ? !borrowedDate.equals(that.borrowedDate) : that.borrowedDate != null) return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = borrowid;
        result = 31 * result + (int) (readerCard ^ (readerCard >>> 32));
        result = 31 * result + (int) (bookInventory ^ (bookInventory >>> 32));
        result = 31 * result + (borrowedDate != null ? borrowedDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        return result;
    }

    private ReaderEntity readerByBorrowedBooks;

    @ManyToOne(optional = false)
    public ReaderEntity getReaderByBorrowedBooks() {
        return readerByBorrowedBooks;
    }

    public void setReaderByBorrowedBooks(ReaderEntity readerByBorrowedBooks) {
        this.readerByBorrowedBooks = readerByBorrowedBooks;
    }
}
