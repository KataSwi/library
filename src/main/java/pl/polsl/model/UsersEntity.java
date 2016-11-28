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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (roleid != that.roleid) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + roleid;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    private RolesEntity usersByRole;

    @JsonBackReference
    @ManyToOne(optional = false)
    public RolesEntity getUsersByRole() {
        return usersByRole;
    }

    public void setUsersByRole(RolesEntity usersByRole) {
        this.usersByRole = usersByRole;
    }

    private ReaderEntity userReader;

    @OneToOne(optional = false)
    public ReaderEntity getUserReader() {
        return userReader;
    }

    public void setUserReader(ReaderEntity userReader) {
        this.userReader = userReader;
    }

    private LibrarianEntity userLibrarian;

    @OneToOne(optional = false)
    public LibrarianEntity getUserLibrarian() {
        return userLibrarian;
    }

    public void setUserLibrarian(LibrarianEntity userLibrarian) {
        this.userLibrarian = userLibrarian;
    }
}
