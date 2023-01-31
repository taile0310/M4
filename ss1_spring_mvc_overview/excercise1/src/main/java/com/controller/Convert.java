package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Convert {
    @GetMapping("/convertForm")
    public String showConverterForm() {
        return "convert";
    }

    @GetMapping("/convert")
    public String converter(Model model, @RequestParam("usd") Double usd) {
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", usd * 25000);
        return "convert";
    }
}
