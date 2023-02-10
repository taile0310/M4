package com.example.spring_boot_ex1.repository;

import com.example.spring_boot_ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IBlogRepository extends JpaRepository<Blog, Integer> {

//    phân trang list và search
    Page<Blog> findByTitleContaining(String title,Pageable pageable);

}

