package com.example.thi_module4.service.impl;

import com.example.thi_module4.model.TacPhamTranh;
import com.example.thi_module4.repository.ITacPhamTranhRepository;
import com.example.thi_module4.service.ITacPhamTranhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacPhamTranhService implements ITacPhamTranhService {
    @Autowired
    private ITacPhamTranhRepository tacPhamTranhRepository;

    @Override
    public List<TacPhamTranh> danhSach() {
        return tacPhamTranhRepository.findAll();
    }

    @Override
    public void them(TacPhamTranh tacPhamTranh) {
        tacPhamTranhRepository.save(tacPhamTranh);
    }

    @Override
    public void xoa(int id) {
        tacPhamTranhRepository.deleteById(id);

    }

    @Override
    public List<TacPhamTranh> findByTenTacPhamContaining(String tenTacPham) {
        return tacPhamTranhRepository.findByTenTacPhamContaining(tenTacPham);
    }

}
