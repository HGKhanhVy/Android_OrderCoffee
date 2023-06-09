package com.example.android_appordercoffee.BLL;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.DAL.CT_HoaDonDAL;
import com.example.android_appordercoffee.DAL.HoaDonDAL;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;

public class CT_HoaDonBLL {
    private CT_HoaDonDAL QLCTHoaDon;
    public CT_HoaDonBLL() {
        QLCTHoaDon = new CT_HoaDonDAL();
    }

    public void themCT_HD(CT_HoaDon_DTO hd, final AddBanCallback callback) {
        CT_HoaDonDAL.themCT_HD(hd, new AddBanCallback() {
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
