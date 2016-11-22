package pl.polsl.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "reservation", schema = "public", catalog = "library")
public class ReservationEntity {
    private int reservationid;
    private Timestamp expDate;
    private long reservedBook;
    private long readerCard;

    @Id
    @Column(name = "reservationid", nullable = false)
    public int getReservationid() {
        return reservationid;
    }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    @Basic
    @Column(name = "exp_date", nullable = true)
    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    @Basic
    @Column(name = "reserved_book", nullable = false)
    public long getReservedBook() {
        return reservedBook;
    }

    public void setReservedBook(long reservedBook) {
        this.reservedBook = reservedBook;
    }

    @Basic
    @Column(name = "reader_card", nullable = false)
    public long getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(long readerCard) {
        this.readerCard = readerCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (reservationid != that.reservationid) return false;
        if (reservedBook != that.reservedBook) return false;
        if (readerCard != that.readerCard) return false;
        if (expDate != null ? !expDate.equals(that.expDate) : that.expDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationid;
        result = 31 * result + (expDate != null ? expDate.hashCode() : 0);
        result = 31 * result + (int) (reservedBook ^ (reservedBook >>> 32));
        result = 31 * result + (int) (readerCard ^ (readerCard >>> 32));
        return result;
    }

    private ReaderEntity readerByReservation;

    @ManyToOne(optional = false)
    public ReaderEntity getReaderByReservation() {
        return readerByReservation;
    }

    public void setReaderByReservation(ReaderEntity readerByReservation) {
        this.readerByReservation = readerByReservation;
    }

    private BookcopyEntity bookByReservation;

    @ManyToOne(optional = false)
    public BookcopyEntity getBookByReservation() {
        return bookByReservation;
    }

    public void setBookByReservation(BookcopyEntity bookByReservation) {
        this.bookByReservation = bookByReservation;
    }
}
