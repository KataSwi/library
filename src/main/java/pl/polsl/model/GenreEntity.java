package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "genre", schema = "public", catalog = "library")
public class GenreEntity {
    private int genreid;
    private String type;
    private Collection<BookEntity> bookByGenre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreid", nullable = false)
    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "bookByGenre", cascade = CascadeType.ALL)
    public Collection<BookEntity> getBookByGenre() {
        return bookByGenre;
    }

    public void setBookByGenre(Collection<BookEntity> bookByGenre) {
        this.bookByGenre = bookByGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (genreid != that.genreid) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreid;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
