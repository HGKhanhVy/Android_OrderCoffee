package com.example.android_appordercoffee.Fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.API.GetTenChucVuCallback;
import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.BLL.ChiTietHoaDon_BLL;
import com.example.android_appordercoffee.DAL.BanRecycleViewAdapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.Item_ChucVu;
import com.example.android_appordercoffee.GUI.AddBanActivity;
import com.example.android_appordercoffee.GUI.ChiTietHoaDonActivity;
import com.example.android_appordercoffee.GUI.HomeActivity;
import com.example.android_appordercoffee.GUI.InfoActivity;
import com.example.android_appordercoffee.GUI.UpdateDeleteBanActivity;
import com.example.android_appordercoffee.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FragmentSoDoBan_KhuA extends Fragment {//implements BanRecycleViewAdapter.BanListener {
    private BanRecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private BanBLL QLBan;
    ArrayList<BanDTO> listBanA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sodoban_khua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_SoDoBanKhuA);
        adapter = new BanRecycleViewAdapter();
        QLBan = new BanBLL();
        //adapter.setBanListener(this);
        getMaBanKhuA();
    }

    /*@Override
    public void onBanClick(BanDTO ban) {

    }*/

    @Override
    public void onResume() { // cho moi lan add la phai lam tuoi lai intent
        super.onResume();
        getMaBanKhuA();
    }
    private void getMaBanKhuA() {
        QLBan.getMaBanKhuA(new GetMaBanCallback() {
            @Override
            public void onSuccess(ArrayList<BanDTO> listA) {
                handleGetMaBan(listA);
            }
            @Override
            public void onError() {
                handleGetMaBan(new ArrayList<>());
            }
        });
    }
    private void handleGetMaBan(ArrayList<BanDTO> listA) {
        listBanA = listA;
        ArrayList<BanDTO> listBan = listBanA;
        adapter.setListBan(listBan);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
