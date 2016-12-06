package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "bookstate", schema = "public", catalog = "library")
public class BookstateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stateid", nullable = false)
    private int stateid;

    @Basic
    @Column(name = "state", length = 20)
    private String state;

    @OneToMany(mappedBy = "bookByState", cascade = CascadeType.ALL)
    private Collection<BookcopyEntity> bookByState;

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

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
