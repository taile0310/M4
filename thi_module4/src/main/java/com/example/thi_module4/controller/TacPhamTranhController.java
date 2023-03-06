package com.example.thi_module4.controller;

import com.example.thi_module4.dto.TacPhamTranhDto;
import com.example.thi_module4.model.TacPhamTranh;
import com.example.thi_module4.service.ITacPhamTranhService;
import com.example.thi_module4.service.ITheLoaiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TacPhamTranhController {
    @Autowired
    private ITacPhamTranhService tacPhamTranhService;
    @Autowired
    private ITheLoaiService theLoaiService;

    @GetMapping("")
    public String layDanhSachTacPham(Model model,
                                     @RequestParam(required = false, defaultValue = "") String tenTacPham) {
        model.addAttribute("tacPhamTranhService", tacPhamTranhService.findByTenTacPhamContaining(tenTacPham));
        model.addAttribute("theLoaiService", theLoaiService.danhSachTheLoai());
        model.addAttribute("tenTacPham", tenTacPham);
        return "view/list";
    }

    @GetMapping("/form")
    public String mauThemTacPham(Model model) {
        model.addAttribute("tacPhamTranhDto", new TacPhamTranhDto());
        model.addAttribute("theLoaiService", theLoaiService.danhSachTheLoai());
        return "view/save";
    }

    @PostMapping("/save")
    public String themMoiTacPham(@Validated @ModelAttribute TacPhamTranhDto tacPhamTranhDto, BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("theLoaiService", theLoaiService.danhSachTheLoai());
            model.addAttribute("tacPhamTranhService", tacPhamTranhService.danhSach());
            model.addAttribute("tacPhamTranhDto", tacPhamTranhDto);
            return "view/save";
        }
        TacPhamTranh tacPhamTranh = new TacPhamTranh();
        BeanUtils.copyProperties(tacPhamTranhDto, tacPhamTranh);
        tacPhamTranhService.them(tacPhamTranh);
        redirectAttributes.addFlashAttribute("thongBao", "Thêm mới thành công");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String xoaTacPham(@RequestParam int maSo, RedirectAttributes redirectAttributes) {
        tacPhamTranhService.xoa(maSo);
        redirectAttributes.addFlashAttribute("thongBao", "Xóa thành công tác phẩm");
        return "redirect:/";
    }

}
