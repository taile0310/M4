package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }


    @GetMapping("")
    public ModelAndView getListProduct(Model model, @SessionAttribute(value = "cart",required = false) CartDto cart,
                                 @CookieValue(value = "productId",
                                 required = false,defaultValue = "-1")int id) {
        model.addAttribute("historyProduct", productService.findById(id));
        if (cart!=null){
            model.addAttribute("cart", cart);
        }
        return new  ModelAndView("/list","productList",productService.list());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id , HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("productId",id+"");
        cookie.setMaxAge(30);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        return new ModelAndView("detail","product", productService.findById(id));
    }

    @GetMapping("/save/{id}")
    public String addToCart(@PathVariable int id ,@SessionAttribute(value = "cart") CartDto cart){
        Product product = productService.findById(id);
        if (product!=null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "/list_cart";
    }


}
