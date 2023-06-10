package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.API.GetThucUongCallback;
import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.BLL.ThucUongBLL;
import com.example.android_appordercoffee.DAL.BanRecycleViewAdapter;
import com.example.android_appordercoffee.DAL.MenuRecycleViewAdapter;
import com.example.android_appordercoffee.DAL.ViewPagerAdapter;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;
import com.example.android_appordercoffee.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private MenuRecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private ThucUongBLL QLThucUong;
    ArrayList<ThucUongDTO> listNuoc;
    Button dongY;
    TextView tSoLuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        listNuoc = new ArrayList<>();
        QLThucUong = new ThucUongBLL();
        recyclerView = findViewById(R.id.rcView_Nuoc);
        getAllThucUong();
        dongY = findViewById(R.id.btn_DongY);
        dongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void getAllThucUong() {
        QLThucUong.getAllThucUong(new GetThucUongCallback() {
            @Override
            public void onSuccess(ArrayList<ThucUongDTO> list) {
                handleGetThucUong(list);
            }

            @Override
            public void onError() {
                handleGetThucUong(new ArrayList<>());
            }
        });
    }
    private void handleGetThucUong(ArrayList<ThucUongDTO> list) {
        listNuoc = list;
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        MenuRecycleViewAdapter adapter = new MenuRecycleViewAdapter(listNuoc);
        recyclerView.setAdapter(adapter);
    }
}