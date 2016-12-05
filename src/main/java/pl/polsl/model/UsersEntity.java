package pl.polsl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "library")
public class UsersEntity {
    private String userName;
    private String password;
    private String name;
    private String surname;
    private int roleid;
    private String email;
    private long librarianid;
    private long readerCard;
    private RolesEntity usersByRole;
    private ReaderEntity userReader;
    private LibrarianEntity userLibrarian;


    @Id
    @Column(name = "user_name", nullable = false, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "roleid", nullable = false)
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "librarian_id", nullable = true)
    public long getLibrarianid() {
        return librarianid;
    }

    public void setLibrarianid(long librarianid) {
        this.librarianid = librarianid;
    }

    @Basic
    @Column(name = "reader_id", nullable = true)
    public long getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(long readerCard) {
        this.readerCard = readerCard;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "roleid", name = "role_id")
    public RolesEntity getUsersByRole() {
        return usersByRole;
    }

    public void setUsersByRole(RolesEntity usersByRole) {
        this.usersByRole = usersByRole;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id", referencedColumnName = "card_number", insertable = false, updatable = false)
    public ReaderEntity getUserReader() {
        return userReader;
    }

    public void setUserReader(ReaderEntity userReader) {
        this.userReader = userReader;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "librarian_id",referencedColumnName = "librarianid", insertable = false, updatable = false)
    public LibrarianEntity getUserLibrarian() {
        return userLibrarian;
    }

    public void setUserLibrarian(LibrarianEntity userLibrarian) {
        this.userLibrarian = userLibrarian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (roleid != that.roleid) return false;
        if (librarianid != that.librarianid) return false;
        if (readerCard != that.readerCard) return false;
        if (!userName.equals(that.userName)) return false;
        if (!password.equals(that.password)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;

    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + roleid;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) (librarianid ^ (librarianid >>> 32));
        result = 31 * result + (int) (readerCard ^ (readerCard >>> 32));
        return result;
    }
}
