package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String listProduct(Model model){
        model.addAttribute("listProduct", productService.list());
        return "list";
    }
    @PostMapping("/list")
    public String update(RedirectAttributes redirectAttributes, @RequestParam int id,Model model ){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        redirectAttributes.addFlashAttribute("mess","Sửa sản phẩm thành công");
        return "list";
    }

    @PostMapping("/list")
    public String save(Model model,@RequestParam Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        model.addAttribute("product", product);
        redirectAttributes.addFlashAttribute("mess", "Thêm sản phẩm thành công");
        return "redirect:/product";
    }
    @PostMapping("/list")

    public String delete(@RequestParam int id){
        productService.delete(id);
        return "redirect:/product";

    }

}
