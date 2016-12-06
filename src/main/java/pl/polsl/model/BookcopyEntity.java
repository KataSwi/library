package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "bookcopy", schema = "public", catalog = "library")
public class BookcopyEntity {

    @Id
    @Column(name = "inventory", nullable = false)
    private long inventory;

    @Basic
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Basic
    @Column(name = "state", nullable = false)
    private int state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state", referencedColumnName = "stateid", insertable = false, updatable = false)
    private BookstateEntity bookByState;

    @OneToMany(mappedBy = "bookByReservation", cascade = CascadeType.ALL)
    private Collection<ReservationEntity> bookByReservation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", updatable = false, insertable = false)
    private BookEntity bookCopy;

    @OneToMany(mappedBy = "bookByReader", cascade = CascadeType.ALL)
    private Collection<BorrowedbooksEntity> bookByReader;

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public BookstateEntity getBookByState() {
        return bookByState;
    }

    public void setBookByState(BookstateEntity bookByState) {
        this.bookByState = bookByState;
    }

    public Collection<ReservationEntity> getBookByReservation() {
        return bookByReservation;
    }

    public void setBookByReservation(Collection<ReservationEntity> bookByReservation) {
        this.bookByReservation = bookByReservation;
    }

    public BookEntity getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookEntity bookCopy) {
        this.bookCopy = bookCopy;
    }

    public Collection<BorrowedbooksEntity> getBookByReader() {
        return bookByReader;
    }

    public void setBookByReader(Collection<BorrowedbooksEntity> bookByReader) {
        this.bookByReader = bookByReader;
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
