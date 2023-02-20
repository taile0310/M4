package com.furama.model.login;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    private User userName;

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRoleId() {
        return role;
    }

    public void setRoleId(Role roleId) {
        this.role = roleId;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }
}
