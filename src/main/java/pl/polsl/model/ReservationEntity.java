package pl.polsl.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "reservation", schema = "public", catalog = "library")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationid", nullable = false)
    private int reservationid;

    @Basic
    @Column(name = "exp_date")
    private Timestamp expDate;

    @Basic
    @Column(name = "reserved_book", nullable = false)
    private long reservedBook;

    @Basic
    @Column(name = "reader_card", nullable = false)
    private long readerCard;

    @Basic
    @Column(name = "state")
    private int reservationState;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reader_card", referencedColumnName = "card_number", insertable = false, updatable = false)
    private ReaderEntity readerByReservation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reserved_book", referencedColumnName = "inventory", insertable = false, updatable = false)
    private BookcopyEntity bookByReservation;

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

    public long getReservedBook() {
        return reservedBook;
    }

    public void setReservedBook(long reservedBook) {
        this.reservedBook = reservedBook;
    }

    public long getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(long readerCard) {
        this.readerCard = readerCard;
    }

    public int getReservationState() {
        return reservationState;
    }

    public void setReservationState(int reservationState) {
        this.reservationState = reservationState;
    }

    public ReaderEntity getReaderByReservation() {
        return readerByReservation;
    }

    public void setReaderByReservation(ReaderEntity readerByReservation) {
        this.readerByReservation = readerByReservation;
    }

    public BookcopyEntity getBookByReservation() {
        return bookByReservation;
    }

    public void setBookByReservation(BookcopyEntity bookByReservation) {
        this.bookByReservation = bookByReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (reservationid != that.reservationid) return false;
        if (reservedBook != that.reservedBook) return false;
        if (readerCard != that.readerCard) return false;
        if (reservationState != that.reservationState) return false;
        return expDate.equals(that.expDate);

    }

    @Override
    public int hashCode() {
        int result = reservationid;
        result = 31 * result + expDate.hashCode();
        result = 31 * result + (int) (reservedBook ^ (reservedBook >>> 32));
        result = 31 * result + (int) (readerCard ^ (readerCard >>> 32));
        result = 31 * result + reservationState;
        return result;
    }
}
