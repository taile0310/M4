package com.example.spring_boot_ex1.service;

import com.example.spring_boot_ex1.model.Blog;

import java.util.List;

public interface IBogService {
    List<Blog> listBlog();
    void save(Blog blog);
    void update(Blog blog);
    void delete(int id);
    void view(int id );
}
