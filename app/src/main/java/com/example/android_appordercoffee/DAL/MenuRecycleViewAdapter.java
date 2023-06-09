package com.example.android_appordercoffee.DAL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.API.MaChucVuCallback;
import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.BLL.CT_HoaDonBLL;
import com.example.android_appordercoffee.BLL.HoaDonBLL;
import com.example.android_appordercoffee.BLL.ThucUongBLL;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;
import com.example.android_appordercoffee.GUI.AddBanActivity;
import com.example.android_appordercoffee.GUI.OrderActivity;
import com.example.android_appordercoffee.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MenuRecycleViewAdapter extends RecyclerView.Adapter<MenuRecycleViewAdapter.MenuViewHolder>{
    private List<ThucUongDTO> listNuoc;
    public MenuRecycleViewAdapter(List<ThucUongDTO> list) {
        this.listNuoc = new ArrayList<>();
        if(list != null) {
            this.listNuoc = list;
        }
    }
    @NonNull
    @Override
    public MenuRecycleViewAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nuoc, parent, false);
        return new MenuViewHolder(view);
    }

    public void setListThucUong(List<ThucUongDTO> listNuoc) { // lay du lieu vao list
        this.listNuoc = listNuoc;
        notifyDataSetChanged(); // set lai list khi co su thay doi
    }
    public ThucUongDTO getNuoc(int position) {
        return listNuoc.get(position);

    }
    @Override
    public void onBindViewHolder(@NonNull MenuRecycleViewAdapter.MenuViewHolder holder, int position) {
        ThucUongDTO nc = listNuoc.get(position);
        holder.tenNuoc.setText(nc.getTenNuoc());
        holder.gia.setText(nc.getGia().toString());
        holder.size.setText(nc.getSize());
        holder.soLuong.setText("0");
    }

    @Override
    public int getItemCount() {
        if (listNuoc != null) {
            return listNuoc.size();
        } else {
            return 0;
        }
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private final TextView tenNuoc, gia, soLuong, size;
        private final ImageView dauTru, dauCong;
        private final Button them;
        private HoaDonBLL QLHoaDon;
        private CT_HoaDonBLL QLCT_HoaDon;
        private ThucUongBLL QLNuoc;
        private String maHoaDon, maNuoc;
        private Boolean flag = false;
        public MenuViewHolder(@NonNull View view) {
            super(view);
            Calendar calendar = Calendar.getInstance();
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            maHoaDon = "HD" + minute + second;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = format.format(calendar.getTime());
            QLHoaDon = new HoaDonBLL();
            QLCT_HoaDon = new CT_HoaDonBLL();
            QLNuoc = new ThucUongBLL();
            HoaDon_DTO hd = new HoaDon_DTO(maHoaDon, "A001", "CHUA THANH TOAN", "NV01", maHoaDon, currentDate, null, null);
            themHoaDon(hd);

            tenNuoc = view.findViewById(R.id.txt_TenNuoc);
            gia = view.findViewById(R.id.txt_Gia);
            soLuong = view.findViewById(R.id.txt_SoLuong);
            size = view.findViewById(R.id.txt_Size);
            dauTru = view.findViewById(R.id.dauTru);
            dauCong = view.findViewById(R.id.dauCong);
            them = view.findViewById(R.id.btnThem);

            dauCong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int sl = Integer.parseInt(soLuong.getText().toString());
                    sl += 1;
                    soLuong.setText(sl + "");
                }
            });
            dauTru.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int sl = Integer.parseInt(soLuong.getText().toString());
                    if(sl == 0) {
                        soLuong.setText("0");
                    }
                    else {
                        sl -= 1;
                        soLuong.setText(sl + "");
                    }
                }
            });
            them.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getMaNuoc(tenNuoc.getText().toString(), size.getText().toString());
                    CT_HoaDon_DTO cthd = new CT_HoaDon_DTO(maHoaDon, maNuoc, tenNuoc.getText().toString(), Integer.parseInt(soLuong.getText().toString()), Float.parseFloat(gia.getText().toString()));
                    themCTHoaDon(cthd);
                }
            });
        }
        private void themHoaDon(HoaDon_DTO hd) {
            QLHoaDon.themHD(hd, new AddBanCallback() {
                @Override
                public void onSuccess(String rs) {
                    handleThemHD(rs);
                }
                @Override
                public void onError() {
                }
            });
        }
        private void handleThemHD(String rs) {
            flag = true;
        }
        private void themCTHoaDon(CT_HoaDon_DTO hd) {
            QLCT_HoaDon.themCT_HD(hd, new AddBanCallback() {
                @Override
                public void onSuccess(String rs) {
                    handleThemCTHoaDon(rs);
                }
                @Override
                public void onError() {
                }
            });
        }
        private void handleThemCTHoaDon(String rs) {
            flag = true;
        }

        private void getMaNuoc(String tenNuoc, String size) {
            QLNuoc.getMaNuoc(tenNuoc, size, new MaChucVuCallback() {
                @Override
                public void onSuccess(String rs) {
                    handleGetMaNuoc(rs);
                }
                @Override
                public void onError() {
                }
            });
        }
        private void handleGetMaNuoc(String rs) {
            maNuoc = rs;
        }
    }
}
