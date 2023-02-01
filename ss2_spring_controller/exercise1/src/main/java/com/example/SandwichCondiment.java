package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondiment {
    @RequestMapping("/sandwichForm")
    public String showForm() {
        return "sandwich";
    }

    @RequestMapping("/sandwich")
    public String sandwich(@RequestParam(value = "condiment", defaultValue = "Bạn chưa chọn gia vị") String[] condiment, Model model) {

        if (condiment.length > 0) {
            model.addAttribute("condiment", condiment);
        }
        return "sandwich";
    }

}
