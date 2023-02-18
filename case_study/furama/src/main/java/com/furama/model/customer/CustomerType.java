package com.furama.model.customer;

import com.furama.model.customer.Customer;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Set;
@Entity
public class CustomerType {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "customerTypeId")
    private Set<Customer> customerSet;

    public CustomerType() {
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

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
