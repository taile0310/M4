package com.example.thi_module4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSo;
    private String tenTheLoai;

    @OneToMany(mappedBy = "theLoai")
    private Set<TacPhamTranh> tacPhamTranhs;

    public TheLoai() {
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public Set<TacPhamTranh> getTacPhamTranhs() {
        return tacPhamTranhs;
    }

    public void setTacPhamTranhs(Set<TacPhamTranh> tacPhamTranhs) {
        this.tacPhamTranhs = tacPhamTranhs;
    }
}
