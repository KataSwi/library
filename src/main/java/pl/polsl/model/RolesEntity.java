package pl.polsl.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "roles", schema = "public", catalog = "library")
public class RolesEntity {
    private int roleid;
    private String type;
    private Collection<UsersEntity> usersByRole;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid", nullable = false)
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "usersByRole", cascade = CascadeType.ALL)
    public Collection<UsersEntity> getUsersByRole() {
        return usersByRole;
    }

    public void setUsersByRole(Collection<UsersEntity> usersByRole) {
        this.usersByRole = usersByRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (roleid != that.roleid) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
