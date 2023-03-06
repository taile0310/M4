package com.example.thi_module4.model;

import javax.persistence.*;

@Entity
public class TacPhamTranh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSo;
    private String tenTacPham;
    private String hoaSi;
    private String namVe;
    private String kichThuoc;
    @ManyToOne
    @JoinColumn(name = "theLoai_maSo", referencedColumnName = "maSo")
    private TheLoai theLoai;

    public TacPhamTranh() {
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getTenTacPham() {
        return tenTacPham;
    }

    public void setTenTacPham(String tenTacPham) {
        this.tenTacPham = tenTacPham;
    }

    public String getHoaSi() {
        return hoaSi;
    }

    public void setHoaSi(String hoaSi) {
        this.hoaSi = hoaSi;
    }

    public String getNamVe() {
        return namVe;
    }

    public void setNamVe(String namVe) {
        this.namVe = namVe;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }
}
