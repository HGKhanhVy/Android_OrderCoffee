package com.example.android_appordercoffee.DTO;

import java.io.Serializable;

public class CT_HoaDon_DTO implements Serializable {
    private String MaHoaDon, _maNuoc,_tenNuoc;
    int SoLuong;
    float DonGia, ThanhTien;
    public CT_HoaDon_DTO(String MaHoaDon , String MaNuoc, String TenNuoc, int SoLuong, float DonGia){
        this.MaHoaDon = MaHoaDon;
        this._maNuoc = MaNuoc;
        this._tenNuoc = TenNuoc;
        this.SoLuong = SoLuong;
        this. DonGia = DonGia;
    }
    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public String getMaNuoc() {
        return _maNuoc;
    }

    public void setMaNuoc(String maNuoc) {
        _maNuoc = maNuoc;
    }

    public String getTenNuoc() {
        return _tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        _tenNuoc = tenNuoc;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float thanhTien) {
        ThanhTien = thanhTien;
    }
}
