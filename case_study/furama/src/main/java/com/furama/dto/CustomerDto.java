package com.furama.dto;

import com.furama.model.customer.CustomerType;

import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;

public class CustomerDto {
    private int id;
    @NotEmpty(message = "Tên không được để trống")
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    @NotEmpty(message = "Số điện thoại không được dể trống")
    private String phoneNumber;
    @NotEmpty(message = "Email không được để trống")
    private String email;
    private String address;
    private CustomerType customerTypeId;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, CustomerType customerTypeId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
