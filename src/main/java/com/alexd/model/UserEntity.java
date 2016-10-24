package com.alexd.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "user", schema = "mydb", catalog = "")
public class UserEntity  {
    private int id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private int roleId;
    private RoleEntity roleByRoleId;
    private int driverId;


    public UserEntity() {
    }

    public UserEntity(  String login, String password, String name, String lastName, int roleId) {

        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.roleId = roleId;
    }

    public UserEntity(  String login, String password, String name, String lastName, int roleId, int driverId) {

        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.roleId = roleId;
        this.driverId = driverId;
    }

    public UserEntity( int id,  String login, String password, String name, String lastName, int roleId, int driverId) {

        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.roleId = roleId;
        this.driverId = driverId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Login", nullable = true, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Last_name", nullable = true, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "DriverId", nullable = false)
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (roleId != that.roleId) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + roleId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Role_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
