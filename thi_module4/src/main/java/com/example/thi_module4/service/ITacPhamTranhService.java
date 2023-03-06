package com.example.thi_module4.service;

import com.example.thi_module4.model.TacPhamTranh;

import java.util.List;

public interface ITacPhamTranhService {
    List<TacPhamTranh> danhSach();
    void them(TacPhamTranh tacPhamTranh);
    void xoa(int id);
    List<TacPhamTranh> findByTenTacPhamContaining( String tenTacPham);
}
