package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "bookcopy", schema = "public", catalog = "library")
public class BookcopyEntity {
    private long inventory;
    private String isbn;
    private int state;
    private BookstateEntity bookByState;
    private Collection<ReservationEntity> bookByReservation;
    private BookEntity bookCopy;

    @Id
    @Column(name = "inventory", nullable = false)
    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "isbn", nullable = false, length = 20)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @ManyToOne(optional = false)
    public BookstateEntity getBookByState() {
        return bookByState;
    }

    public void setBookByState(BookstateEntity bookByState) {
        this.bookByState = bookByState;
    }

    @OneToMany(mappedBy = "bookByReservation")
    public Collection<ReservationEntity> getBookByReservation() {
        return bookByReservation;
    }

    public void setBookByReservation(Collection<ReservationEntity> bookByReservation) {
        this.bookByReservation = bookByReservation;
    }

    @ManyToOne(optional = false)
    public BookEntity getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookEntity bookCopy) {
        this.bookCopy = bookCopy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookcopyEntity that = (BookcopyEntity) o;

        if (inventory != that.inventory) return false;
        if (state != that.state) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (inventory ^ (inventory >>> 32));
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + state;
        return result;
    }

}
