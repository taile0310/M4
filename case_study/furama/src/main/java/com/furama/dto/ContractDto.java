package com.furama.dto;

import com.furama.model.customer.Customer;
import com.furama.model.employee.Employee;
import com.furama.model.facility.Facility;

import javax.validation.constraints.NotEmpty;

public class ContractDto {
    private int id;
    @NotEmpty(message = "Ngày đặt dịch vụ không được để trống")
    private String startDay;
    @NotEmpty(message = "Ngày trả không được để trống")
    private String endDay;
    private double deposit;
//    @NotEmpty(message = "Tên nhân viên không được để trống")
    private Employee employee;
//    @NotEmpty(message = "Tên khách hàng không được để trống")
    private Customer customer;
//    @NotEmpty(message = "Tên cơ sở không được để trống")
    private Facility facility;

    private double total;

    public ContractDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
