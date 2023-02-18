package com.furama.model.login;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Role roleId;

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
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }
}
