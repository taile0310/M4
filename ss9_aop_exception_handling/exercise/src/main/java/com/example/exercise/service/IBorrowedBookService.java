package com.example.exercise.service;

import com.example.exercise.model.BorrowedBook;

import java.util.List;

public interface IBorrowedBookService {
    BorrowedBook findById(int id);
    void save(BorrowedBook borrowedBook);
    List<BorrowedBook> findAll();}
