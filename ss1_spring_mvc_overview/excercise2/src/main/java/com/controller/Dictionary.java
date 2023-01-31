package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Dictionary {

    @GetMapping("/dictionaryForm")
    public String showForm() {
        return "dictionary";
    }

    @GetMapping("/dictionary")
    public String translate(@RequestParam("word") String word, Model model) {
        String translate;
        switch (word) {
            case "red":
                translate = "đỏ";
                break;
            case "pink":
                translate = "hồng";
                break;
            case "black":
                translate = "đen";
                break;
            case "grey":
                translate = "xám";
                break;
            default:
                translate = "Không có trong từ điển";

        }
        model.addAttribute("word",word);
        model.addAttribute("translate", translate);
        return "dictionary";
    }

}
