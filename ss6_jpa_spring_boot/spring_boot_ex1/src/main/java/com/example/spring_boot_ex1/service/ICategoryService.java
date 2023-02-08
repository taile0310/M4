package com.example.spring_boot_ex1.service;



import com.example.spring_boot_ex1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> listCategory();
    void save(Category category);
    void update(Category category);
    void delete(int id);
    Page<Category> findByNameContaining(String name, Pageable pageable);

}
