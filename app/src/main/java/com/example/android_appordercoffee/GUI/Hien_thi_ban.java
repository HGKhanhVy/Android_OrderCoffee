package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DAL.hienthiBan_Adapter;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;

public class Hien_thi_ban extends AppCompatActivity {

    ArrayList<BanDTO> listBan;
    GridView gridView ; //id GridViewItem

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_ban);

        gridView = findViewById(R.id.GridViewItem);
        listBan = db.getListBanKhuA();

        hienthiBan_Adapter adapter = new hienthiBan_Adapter(Hien_thi_ban.this,listBan);
        gridView.setAdapter(adapter);
    }
}