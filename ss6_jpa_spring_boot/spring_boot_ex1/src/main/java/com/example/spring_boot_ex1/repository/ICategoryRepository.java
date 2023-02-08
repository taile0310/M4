package com.example.spring_boot_ex1.repository;


import com.example.spring_boot_ex1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository  extends JpaRepository<Category,Integer> {
    //    phân trang list và search
    Page<Category> findByNameContaining(String name, Pageable pageable);


}
