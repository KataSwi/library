package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "book", schema = "public", catalog = "library")
public class BookEntity {

    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Basic
    @Column(name = "author", nullable = false)
    private int author;

    @Basic
    @Column(name = "pages")
    private Integer pages;

    @Basic
    @Column(name = "genre", nullable = false)
    private int genre;

    @Basic
    @Column(name = "publisher", length = 50)
    private String publisher;

    @ManyToOne
    @JoinColumn(name = "genre", referencedColumnName = "genreid", insertable = false, updatable = false)
    private GenreEntity bookByGenre;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "authorid", insertable = false, updatable = false)
    private AuthorEntity bookByAuthor;

    @OneToMany(mappedBy = "bookCopy", cascade = CascadeType.ALL)
    private Collection<BookcopyEntity> bookCopy;


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public GenreEntity getBookByGenre() {
        return bookByGenre;
    }

    public void setBookByGenre(GenreEntity bookByGenre) {
        this.bookByGenre = bookByGenre;
    }

    public AuthorEntity getBookByAuthor() {
        return bookByAuthor;
    }

    public void setBookByAuthor(AuthorEntity bookByAuthor) {
        this.bookByAuthor = bookByAuthor;
    }

    public Collection<BookcopyEntity> getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(Collection<BookcopyEntity> bookCopy) {
        this.bookCopy = bookCopy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (author != that.author) return false;
        if (genre != that.genre) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + author;
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + genre;
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        return result;
    }
}
