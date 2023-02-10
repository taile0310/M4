package com.example.spring_boot_ex1.controller;

import com.example.spring_boot_ex1.model.Blog;
import com.example.spring_boot_ex1.model.Category;
import com.example.spring_boot_ex1.service.IBlogService;
import com.example.spring_boot_ex1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String listBlog(Model model, @RequestParam(required = false, defaultValue = "") String titleSearch,
                           @PageableDefault(size = 2, page = 0, sort = "startDay", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogPage = blogService.findByTitleContaining(titleSearch, pageable);
        if (blogPage.isEmpty()) {
            model.addAttribute("mess", "Không tìm thấy sản phẩm");

        } else {
            model.addAttribute("blogPage", blogPage);
            model.addAttribute("title", titleSearch);
        }
        model.addAttribute("listCategory", categoryService.listCategory());
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
        redirectAttributes.addFlashAttribute("mess", "Xóa Blog thành công");
        return "redirect:/blog";
    }
}
