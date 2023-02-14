package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartDtoController {
    @GetMapping
    public ModelAndView getListCart(@SessionAttribute(value = "cart", required = false) CartDto cart) {
        return new ModelAndView("/list_cart", "cart", cart);
    }

}
