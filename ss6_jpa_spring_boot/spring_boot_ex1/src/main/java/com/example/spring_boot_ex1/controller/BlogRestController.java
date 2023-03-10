package com.example.spring_boot_ex1.controller;


import com.example.spring_boot_ex1.dto.BlogDto;
import com.example.spring_boot_ex1.model.Blog;
import com.example.spring_boot_ex1.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getListBlog(@RequestParam(required = false,defaultValue = "") String title,
                                                  @RequestParam int size,@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Blog> blogPage = blogService.findByTitleContaining(title, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addBlog(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity updateBlog(@RequestBody BlogDto blogDto) {
        Blog blog = blogService.findById(blogDto.getId());
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

}
