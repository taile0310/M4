package com.example.spring_boot_ex1.service.impl;

import com.example.spring_boot_ex1.model.Blog;
import com.example.spring_boot_ex1.repository.IBlogRepository;
import com.example.spring_boot_ex1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> listBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title,pageable);
    }


}
