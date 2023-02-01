package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @RequestMapping("/calculatorForm")
    public String calculatorForm() {
        return "calculator";
    }


    @RequestMapping("/calculator")
    public String calculator(@RequestParam("num1") int num1, @RequestParam("num2") int num2,
                             @RequestParam("calculus") String calculus, Model model) {
        String result = "";
        switch (calculus) {
            case "Addition":
                result = String.valueOf((num1 + num2));
                break;
            case "Subtraction":
                result = String.valueOf((num1 - num2));
                break;
            case "Multiplication":
                result = String.valueOf((num1 * num2));
                break;
            case "Division":
                if (num2 != 0) {
                    result = String.valueOf((num1 / num2));
                }else {
                    result = "Lỗi khi chia với 0";
                }
                break;
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "calculator";
    }
}
