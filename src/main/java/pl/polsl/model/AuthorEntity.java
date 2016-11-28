package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "author", schema = "public", catalog = "library")
public class AuthorEntity {

    private int authorid;
    private String authorName;
    private String authorSurname;
    private Collection<BookEntity> bookByAuthor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid", nullable = false)
    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    @Basic
    @Column(name = "author_name", nullable = true, length = 20)
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Basic
    @Column(name = "author_surname", nullable = true, length = 50)
    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    @OneToMany(mappedBy = "bookByAuthor")
    public Collection<BookEntity> getBookByAuthor() {
        return bookByAuthor;
    }

    public void setBookByAuthor(Collection<BookEntity> bookByAuthor) {
        this.bookByAuthor = bookByAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (authorid != that.authorid) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (authorSurname != null ? !authorSurname.equals(that.authorSurname) : that.authorSurname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorid;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorSurname != null ? authorSurname.hashCode() : 0);
        return result;
    }

}
