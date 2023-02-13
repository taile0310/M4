package com.example.exercise.service.impl;

import com.example.exercise.model.BorrowedBook;
import com.example.exercise.repository.IBorrowedBookRepository;
import com.example.exercise.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookService implements IBorrowedBookService {
    @Autowired
    private IBorrowedBookRepository borrowedBookRepository;

    @Override
    public BorrowedBook findById(int id) {
        return borrowedBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }
    @Override
    public List<BorrowedBook> findAll() {
        return borrowedBookRepository.findAll();
    }
}
