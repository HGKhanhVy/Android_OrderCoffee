package com.example.android_appordercoffee.BLL;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.DAL.BanDAL;
import com.example.android_appordercoffee.DAL.HoaDonDAL;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;

import java.util.ArrayList;

public class HoaDonBLL {
    private HoaDonDAL QLHoaDon;
    public HoaDonBLL() {
        QLHoaDon = new HoaDonDAL();
    }

    public void themHD(HoaDon_DTO hd, final AddBanCallback callback) {
        QLHoaDon.themHD(hd, new AddBanCallback() {
            @Override
            public void onSuccess(String rs) {
                callback.onSuccess(rs);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
}
