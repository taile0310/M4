package com.example.thi_module4.dto;

import com.example.thi_module4.model.TheLoai;
import javax.validation.constraints.NotEmpty;


public class TacPhamTranhDto {
    private int maSo;
    @NotEmpty(message = "Tên tác phẩm không được để trống")
    private String tenTacPham;
    @NotEmpty(message = "Tên họa sĩ không được để trống")
    private String hoaSi;
    @NotEmpty(message = "Năm vẽ được để trống")
    private String namVe;
    @NotEmpty(message = "Kích thước được để trống")
    private String kichThuoc;

    private TheLoai theLoai;

    public TacPhamTranhDto() {
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
