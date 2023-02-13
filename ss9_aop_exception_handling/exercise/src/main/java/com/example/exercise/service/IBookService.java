package com.example.exercise.service;

import com.example.exercise.model.Book;
import com.example.exercise.model.BorrowedBook;

import java.util.List;

public interface IBookService {
    List<Book> listBook();
    Book findById ( int id );
    void update(Book book);


}
