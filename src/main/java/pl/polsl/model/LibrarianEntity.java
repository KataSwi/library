package pl.polsl.model;

import javax.persistence.*;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "librarian", schema = "public", catalog = "library")
public class LibrarianEntity {
    private long librarianid;
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "librarianid", nullable = false)
    public long getLibrarianid() {
        return librarianid;
    }

    public void setLibrarianid(long librarianid) {
        this.librarianid = librarianid;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibrarianEntity that = (LibrarianEntity) o;

        if (librarianid != that.librarianid) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (librarianid ^ (librarianid >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }

    private UsersEntity librarianUser;

    @OneToOne(mappedBy = "userLibrarian", optional = false)
    public UsersEntity getLibrarianUser() {
        return librarianUser;
    }

    public void setLibrarianUser(UsersEntity librarianUser) {
        this.librarianUser = librarianUser;
    }
}
