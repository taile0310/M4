package com.furama.controller;

import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;


    @GetMapping("")
    public String getListContract(Model model) {
        model.addAttribute("contractList", contractService.getListContract());
        return "/view/contract/listContract";
    }

}
