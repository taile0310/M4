package com.example.exercise.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String name;
    private int quantity;


    @OneToMany(mappedBy = "book")
    private Set<BorrowedBook> borrowedBookSet;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<BorrowedBook> getBorrowedBookSet() {
        return borrowedBookSet;
    }

    public void setBorrowedBookSet(Set<BorrowedBook> borrowedBookSet) {
        this.borrowedBookSet = borrowedBookSet;
    }
}
