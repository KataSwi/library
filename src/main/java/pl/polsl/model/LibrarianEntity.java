package pl.polsl.model;

import javax.persistence.*;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "librarian", schema = "public", catalog = "library")
public class LibrarianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "librarianid", nullable = false)
    private long librarianid;

    @Basic
    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", updatable = false, insertable = false)
    private UsersEntity librarianUser;

    public long getLibrarianid() {
        return librarianid;
    }

    public void setLibrarianid(long librarianid) {
        this.librarianid = librarianid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UsersEntity getLibrarianUser() {
        return librarianUser;
    }

    public void setLibrarianUser(UsersEntity librarianUser) {
        this.librarianUser = librarianUser;
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

}
