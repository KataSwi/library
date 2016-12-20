package pl.polsl.dto;

import pl.polsl.model.BookEntity;

import java.util.Collection;
import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
public class AuthorDTO {
    private int authorid;
    private String authorName;
    private String authorSurname;

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

}
