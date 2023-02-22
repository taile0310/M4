package com.furama.model.login;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;

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

    public User getUsername() {
        return username;
    }

    public void setUsername(User userName) {
        this.username = userName;
    }
}
