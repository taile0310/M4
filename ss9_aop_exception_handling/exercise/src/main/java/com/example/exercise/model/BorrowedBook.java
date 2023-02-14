package com.example.exercise.model;

import javax.persistence.*;

@Entity
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bookCode",referencedColumnName = "id")
    private Book book;

    public BorrowedBook() {
    }

    public BorrowedBook(String bookCode, Book book1) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
