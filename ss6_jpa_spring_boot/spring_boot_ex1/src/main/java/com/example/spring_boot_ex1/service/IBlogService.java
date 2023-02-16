package com.example.spring_boot_ex1.service;

import com.example.spring_boot_ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> listBlog();
    void save(Blog blog);
    void delete(int id);
    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Blog findById(int id);


}
