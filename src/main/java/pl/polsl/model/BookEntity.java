package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "book", schema = "public", catalog = "library")
public class BookEntity {
    private String isbn;
    private String title;
    private int author;
    private Integer pages;
    private int genre;
    private String publisher;

    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author", nullable = false)
    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Basic
    @Column(name = "pages", nullable = true)
    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Basic
    @Column(name = "genre", nullable = false)
    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "publisher", nullable = true, length = 50)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    private GenreEntity bookByGenre;

    @ManyToOne(optional = false)
    public GenreEntity getBookByGenre() {
        return bookByGenre;
    }

    public void setBookByGenre(GenreEntity bookByGenre) {
        this.bookByGenre = bookByGenre;
    }

    private AuthorEntity bookByAuthor;

    @ManyToOne(optional = false)
    public AuthorEntity getBookByAuthor() {
        return bookByAuthor;
    }

    public void setBookByAuthor(AuthorEntity bookByAuthor) {
        this.bookByAuthor = bookByAuthor;
    }

    private Collection<BookcopyEntity> bookCopy;

    @OneToMany(mappedBy = "bookCopy")
    public Collection<BookcopyEntity> getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(Collection<BookcopyEntity> bookCopy) {
        this.bookCopy = bookCopy;
    }
}
