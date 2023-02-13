package com.example.exercise.service.impl;

import com.example.exercise.model.Book;
import com.example.exercise.repository.IBookRepository;
import com.example.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> listBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);

    }


}
