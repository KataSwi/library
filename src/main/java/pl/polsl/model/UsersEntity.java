package pl.polsl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "library")
public class UsersEntity {

    @Id
    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Basic
    @Column(name = "name", length = 20)
    private String name;

    @Basic
    @Column(name = "surname", length = 50)
    private String surname;

    @Basic
    @Column(name = "roleid", nullable = false)
    private int roleid;

    @Basic
    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(referencedColumnName = "roleid", name = "roleid", insertable = false, updatable = false)
    private RolesEntity usersByRole;

    @JsonIgnore
    @OneToOne(mappedBy = "readerUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ReaderEntity userReader;

    @JsonIgnore
    @OneToOne(mappedBy = "librarianUser",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private LibrarianEntity userLibrarian;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolesEntity getUsersByRole() {
        return usersByRole;
    }

    public void setUsersByRole(RolesEntity usersByRole) {
        this.usersByRole = usersByRole;
    }

    public ReaderEntity getUserReader() {
        return userReader;
    }

    public void setUserReader(ReaderEntity userReader) {
        this.userReader = userReader;
    }

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
        return result;
    }
}
