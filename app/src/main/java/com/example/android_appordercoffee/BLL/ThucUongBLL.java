package com.example.android_appordercoffee.BLL;

import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.API.GetThucUongCallback;
import com.example.android_appordercoffee.API.MaChucVuCallback;
import com.example.android_appordercoffee.DAL.BanDAL;
import com.example.android_appordercoffee.DAL.ThucUongDAL;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;

import java.util.ArrayList;

public class ThucUongBLL {
    private ThucUongDAL QLThucUong;
    public ThucUongBLL() {
        QLThucUong = new ThucUongDAL();
    }

    public void getAllThucUong(final GetThucUongCallback callback) {
        QLThucUong.getAllThucUong(new GetThucUongCallback() {

            @Override
            public void onSuccess(ArrayList<ThucUongDTO> list) {
                callback.onSuccess(list);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
    public void getMaNuoc(String tenNuoc, String size, final MaChucVuCallback callback) {
        QLThucUong.getMaNuoc(tenNuoc, size, new MaChucVuCallback() {

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
