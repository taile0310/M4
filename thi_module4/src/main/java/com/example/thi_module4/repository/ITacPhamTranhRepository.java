package com.example.thi_module4.repository;

import com.example.thi_module4.model.TacPhamTranh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITacPhamTranhRepository extends JpaRepository<TacPhamTranh,Integer> {
    List<TacPhamTranh> findByTenTacPhamContaining( String tenTacPham);
}
