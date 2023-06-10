package com.example.android_appordercoffee.BLL;

import android.content.Context;

import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;

import java.util.ArrayList;

public class HoaDon_BLL {

    private Context context;
    SQLiteHelper db;

    public HoaDon_BLL(Context context1){db = new SQLiteHelper(context1);}
    public ArrayList<HoaDon_DTO> getALLHoaDon(String trangthai){return db.getListHDByHoaDon(trangthai);}
    public long AddHoaDon(HoaDon_DTO hoaDon_dtoDto){
        return db.add_HoaDon(hoaDon_dtoDto);
    }
    public HoaDon_DTO getHoaDonByMaHoaDon (String mahoa){
        return db.getHoaDonByMaHoaDon(mahoa);
    }
    public String getMaHoaDonByMaBan (String MaBan){return db.getMaHoaDonByMaBan(MaBan);}
    public int ThanhToanHoaDon(String maHD){ return  db.ThanhToanHoaDon( maHD );    }
}
