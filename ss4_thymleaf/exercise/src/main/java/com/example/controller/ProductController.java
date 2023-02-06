package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String listProduct(Model model) {
        model.addAttribute("listProduct", productService.list());
        model.addAttribute("product", new Product());
        return "list";
    }

    @PostMapping("/update")
    public String update(@RequestParam int updateId, Model model, Product product,RedirectAttributes redirectAttributes) {
        product.setId(updateId);
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess", "Sửa sản phẩm thành công");
        return "redirect:/product";
    }

    @PostMapping("/save")
    public String save(Model model, Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        model.addAttribute("product", product);
        redirectAttributes.addFlashAttribute("mess", "Thêm sản phẩm thành công");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam String name) {
        List<Product> listProduct = productService.search(name);
        if (listProduct.isEmpty()) {
            model.addAttribute("mess", "Không tìm thấy sản phẩm");

        } else {
            model.addAttribute("listProduct", listProduct);
        }
        return "list";
    }
}
