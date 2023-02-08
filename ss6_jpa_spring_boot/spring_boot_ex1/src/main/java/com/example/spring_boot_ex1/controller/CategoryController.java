package com.example.spring_boot_ex1.controller;


import com.example.spring_boot_ex1.model.Category;
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

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String listCategory(Model model,
                               @RequestParam(required = false, defaultValue = "") String nameSearch,
                               @PageableDefault(size = 2, page = 0, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Category> categoryPage = categoryService.findByNameContaining(nameSearch, pageable);
        if (categoryPage.isEmpty()) {
            model.addAttribute("mess", "Không tìm thấy thể loại");
        } else {
            model.addAttribute("categoryPage", categoryPage);
            model.addAttribute("name", nameSearch);
        }
        model.addAttribute("category", new Category());
        return "list-category";

    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/category";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Sửa thể loại thành công");
        return "redirect:/category";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thể loại thành công");
        return "redirect:/category";
    }
}
