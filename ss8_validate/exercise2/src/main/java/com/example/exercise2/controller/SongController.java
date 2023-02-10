package com.example.exercise2.controller;

import com.example.exercise2.dto.SongDto;
import com.example.exercise2.model.Song;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listSong(Model model){
        model.addAttribute("listSong", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto", songDto);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm thành công!");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable int id, Model model){
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(this.songService.findById(id), songDto);
        model.addAttribute("songDto", songDto);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto", songDto);
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/";
    }
}
