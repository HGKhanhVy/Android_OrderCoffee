package com.example.android_appordercoffee.DAL;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.GUI.ChiTietHoaDonActivity;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;

public class hienthiBan_Adapter extends BaseAdapter {
    Context context;
    ArrayList<BanDTO> list;
    LayoutInflater inflater;

    public hienthiBan_Adapter (Context context, ArrayList<BanDTO> listBan){
        this.context = context;
        this.list = listBan;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view== null){
            view= inflater.inflate(R.layout.listview_hienthiban,null);
        }
        BanDTO item = list.get(i);
        Button btn = view.findViewById(R.id.btnBan);
        btn.setText(item.getMaBan());
        String trangThai = item.getTrangThai();
        if(trangThai.equalsIgnoreCase("Trống")==true){
            btn.setBackgroundColor(Color.parseColor("#036ac4"));
            btn.setTextColor(Color.WHITE);
        }
        else{
            btn.setBackgroundColor(Color.RED);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo một Intent với context và Activity đích
                Intent intent = new Intent(context, ChiTietHoaDonActivity.class);
                // Thêm dữ liệu vào Intent, ví dụ như một chuỗi
                String data = "Hello, world!";
                intent.putExtra("TenHoaDon", item.getMaBan());
                // Chuyển Activity
                context.startActivity(intent);
                Toast.makeText(context,item.getMaBan()+"is click",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
