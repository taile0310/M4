package com.example.thi_module4.service.impl;

import com.example.thi_module4.model.TheLoai;
import com.example.thi_module4.repository.ITheLoaiRepository;
import com.example.thi_module4.service.ITheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TheLoaiService implements ITheLoaiService {
    @Autowired
    private ITheLoaiRepository theLoaiRepository;
    @Override
    public List<TheLoai> danhSachTheLoai() {
        return theLoaiRepository.findAll();
    }
}
