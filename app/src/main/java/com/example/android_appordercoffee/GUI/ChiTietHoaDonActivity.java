package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android_appordercoffee.BLL.ChiTietHoaDon_BLL;
import com.example.android_appordercoffee.DAL.ChiTietHoaDon_Adapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ChiTietHoaDonActivity extends AppCompatActivity {
    ListView listView;
    SQLiteHelper db;
    TextView txtBan, txtTongThanhToan, txtTienKhachDua, txtTraLai;
    TextView txtNgayXuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiethoadon);

        listView = findViewById(R.id.listView);
        txtBan = findViewById(R.id.txtBan);
        txtTongThanhToan = findViewById(R.id.txtTongThanhToan);
        txtTienKhachDua = findViewById(R.id.txtTienKhachDua);
        txtBan.setText("Bàn 00001");
        txtTraLai = findViewById(R.id.txtTienTraLai);
        txtNgayXuat = findViewById(R.id.txtNgayXuat);

        //khởi tạo data
        //ArrayList<CT_HoaDon_DTO> arrList = new ArrayList<CT_HoaDon_DTO>();
        //db = new SQLiteHelper(ChiTietHoaDonActivity.this);
        //String MaHoaDon , String MaSP, String TenSp, int SoLuong, float DonGia,float ThanhTien
        CT_HoaDon_DTO CTHD1 = new CT_HoaDon_DTO("HD001", "SP001", "Sữa Tươi", 1, 15000.0f, 15000.0f);
        CT_HoaDon_DTO CTHD2 = new CT_HoaDon_DTO("HD001", "SP002", "Cafe sữa", 1, 18000.0f, 18000.0f);
        CT_HoaDon_DTO CTHD3 = new CT_HoaDon_DTO("HD001", "SP003", "Sữa Tươi", 1, 12000.0f, 12000.0f);

/*
        db.add_CTHoaDon(CTHD1);
        db.add_CTHoaDon(CTHD2);
        db.add_CTHoaDon(CTHD3);

 */

        CT_HoaDon_DTO CTHD21 = new CT_HoaDon_DTO("HD002", "SP001", "Sting", 1, 15000.0f, 15000.0f);
        CT_HoaDon_DTO CTHD22 = new CT_HoaDon_DTO("HD002", "SP002", "Cafe", 1, 18000.0f, 18000.0f);
        CT_HoaDon_DTO CTHD23 = new CT_HoaDon_DTO("HD002", "SP003", "Bò cụng", 1, 12000.0f, 12000.0f);
/*
        db.add_CTHoaDon(CTHD21);
        db.add_CTHoaDon(CTHD22);
        db.add_CTHoaDon(CTHD23);

 */
        ChiTietHoaDon_BLL cthd = new ChiTietHoaDon_BLL(ChiTietHoaDonActivity.this);
        ArrayList<CT_HoaDon_DTO> lstCTHoaDon = cthd.getAllChiTietHoaDon("HD002");
        float tong = 0;
        float tienkhachdua =100000.0f;
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(now);
        txtNgayXuat.setText(formattedDate);
        for (CT_HoaDon_DTO items : lstCTHoaDon) {
            tong += items.getThanhTien();
        }
        txtTongThanhToan.setText(String.valueOf(tong));
        txtTienKhachDua.setText(String.valueOf(tienkhachdua));
        txtTraLai.setText(String.valueOf(tienkhachdua - tong));
        ChiTietHoaDon_Adapter perAdapter = new ChiTietHoaDon_Adapter(this, lstCTHoaDon);
        listView.setAdapter(perAdapter);
    }
}