package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "reader", schema = "public", catalog = "library")
public class ReaderEntity {

    @Id
    @Column(name = "card_number", nullable = false)
    private long cardNumber;

    @Basic
    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", insertable = false, updatable = false)
    private UsersEntity readerUser;

    @OneToMany(mappedBy = "readerByBorrowedBooks", cascade = CascadeType.ALL)
    private Collection<BorrowedbooksEntity> readerByBorrowedBooks;

    @OneToMany(mappedBy = "readerByReservation", cascade = CascadeType.ALL)
    private Collection<ReservationEntity> readerByReservation;


    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UsersEntity getReaderUser() {
        return readerUser;
    }

    public void setReaderUser(UsersEntity readerUser) {
        this.readerUser = readerUser;
    }

    public Collection<BorrowedbooksEntity> getReaderByBorrowedBooks() {
        return readerByBorrowedBooks;
    }

    public void setReaderByBorrowedBooks(Collection<BorrowedbooksEntity> readerByBorrowedBooks) {
        this.readerByBorrowedBooks = readerByBorrowedBooks;
    }

    public Collection<ReservationEntity> getReaderByReservation() {
        return readerByReservation;
    }

    public void setReaderByReservation(Collection<ReservationEntity> readerByReservation) {
        this.readerByReservation = readerByReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReaderEntity that = (ReaderEntity) o;

        if (cardNumber != that.cardNumber) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cardNumber ^ (cardNumber >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }

}
