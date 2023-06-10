package com.example.android_appordercoffee.BLL;

import android.content.Context;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.API.GetTenChucVuCallback;
import com.example.android_appordercoffee.API.RegisterNhanVienCallback;
import com.example.android_appordercoffee.DAL.BanDAL;
import com.example.android_appordercoffee.DAL.ChucVuDAL;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.Item_ChucVu;
import com.example.android_appordercoffee.DTO.NhanVienDTO;

import java.util.ArrayList;

public class BanBLL {
    private BanDAL QLBan;
    SQLiteHelper db ;
    public BanBLL(Context context1){
        db = new SQLiteHelper(context1);
    }
    public BanBLL() {
        QLBan = new BanDAL();
    }
    public void getMaBanKhuA(final GetMaBanCallback callback) {
        QLBan.getMaBanKhuA(new GetMaBanCallback() {
            @Override
            public void onSuccess(ArrayList<BanDTO> listA) {
                callback.onSuccess(listA);
            }
            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public void getMaBanKhuB(final GetMaBanCallback callback) {
        QLBan.getMaBanKhuB(new GetMaBanCallback() {
            @Override
            public void onSuccess(ArrayList<BanDTO> listB) {
                callback.onSuccess(listB);
            }
            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
    public void themBan(BanDTO ban, final AddBanCallback callback) {
        QLBan.themBan(ban, new AddBanCallback() {
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
    public int ghepBan(String TenHoaDon, String mahoadon){
        return db.ghepBan(TenHoaDon,mahoadon);
    }
    public long addBan(BanDTO ban) {
        return db.addBan(ban);
    }
}


