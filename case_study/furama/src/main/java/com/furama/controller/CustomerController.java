package com.furama.controller;

import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String getShowListCustomer(Model model){
        model.addAttribute("getShowListCustomer",customerService.getShowListCustomer());
        return "view/listCustomer";
    }

}
