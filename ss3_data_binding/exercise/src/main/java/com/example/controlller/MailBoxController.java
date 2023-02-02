package com.example.controlller;


import com.example.model.MailBox;
import com.example.service.IMailBoxService;
import com.example.service.MailBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailBoxController {

    private IMailBoxService mailBoxService = new MailBoxService();

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("mailBoxList", mailBoxService.showList());
        return "list";
    }

    @GetMapping("/form")
    public String updateForm(Model model, @RequestParam int id){

        MailBox mailBox=mailBoxService.findById(id);
        List<String> languagesList = mailBoxService.language();
        List<Integer> pageSizes = mailBoxService.pageSizes();
        model.addAttribute("languagesList",languagesList);
        model.addAttribute("pageSizes",pageSizes);
        model.addAttribute("mailBox",mailBox);
        return "form";
    }

    @PostMapping("/form")
    public String update(@ModelAttribute MailBox mailBox,RedirectAttributes redirectAttributes){
        mailBoxService.update(mailBox);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/list";

    }
}
