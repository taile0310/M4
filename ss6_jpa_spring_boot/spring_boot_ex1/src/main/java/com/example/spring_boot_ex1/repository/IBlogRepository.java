package com.example.spring_boot_ex1.repository;

import com.example.spring_boot_ex1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
