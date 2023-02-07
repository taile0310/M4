package com.example.spring_boot_ex1.controller;

import com.example.spring_boot_ex1.model.Blog;
import com.example.spring_boot_ex1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String listBlog(Model model) {
        model.addAttribute("listBlog", blogService.listBlog());
        model.addAttribute("blog", new Blog());
        return "list";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/blog";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Sửa blog thành công");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Xóa Blog thành công");
        return "redirect:/blog";
    }
}
