package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "bookstate", schema = "public", catalog = "library")
public class BookstateEntity {
    private int stateid;
    private String state;
    private Collection<BookcopyEntity> bookByState;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stateid", nullable = false)
    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 10)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @OneToMany(mappedBy = "bookByState")
    public Collection<BookcopyEntity> getBookByState() {
        return bookByState;
    }

    public void setBookByState(Collection<BookcopyEntity> bookByState) {
        this.bookByState = bookByState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookstateEntity that = (BookstateEntity) o;

        if (stateid != that.stateid) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stateid;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

}
