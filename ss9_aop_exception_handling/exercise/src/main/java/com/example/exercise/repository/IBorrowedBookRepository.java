package com.example.exercise.repository;

import com.example.exercise.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook,Integer> {
}
