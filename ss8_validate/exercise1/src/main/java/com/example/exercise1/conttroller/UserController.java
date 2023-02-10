package com.example.exercise1.conttroller;

import com.example.exercise1.dto.UserDto;
import com.example.exercise1.model.User;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String listUser(Model model) {
        model.addAttribute("listUser", userService.list());
        return "list";
    }
    @GetMapping("/form")
    public String showForm(Model model  ){
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

//        CUSTOMER VALIDATE
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "create";
        }

//        SAO CHÉP DỮ LIỆU
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/";
    }
}
