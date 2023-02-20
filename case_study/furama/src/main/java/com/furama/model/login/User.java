package com.furama.model.login;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.furama.model.employee.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(length = 225)
    private String userName;
    @Column(length = 225)
    @NotNull
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "userName")
    private Set<UserRole> userRoleSet;

    @OneToMany(mappedBy = "userName")
    private Set<Employee> employeeSet;

    public User() {
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

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

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
