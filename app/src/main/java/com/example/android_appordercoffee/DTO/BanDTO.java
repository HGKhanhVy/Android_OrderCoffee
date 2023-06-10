package com.example.android_appordercoffee.DTO;

import java.io.Serializable;

public class BanDTO implements Serializable { // do phai gui di gui lai
    String maBan;
    String tenBan;
    String trangThai;
    public BanDTO() {
    }
    public BanDTO(String maBan, String trangThai) {
        this.maBan = maBan;
        this.trangThai = trangThai;
    }

    public BanDTO(String maBan, String tenBan, String trangThai) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.trangThai = trangThai;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}