package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.BLL.ChiTietHoaDon_BLL;
import com.example.android_appordercoffee.BLL.HoaDon_BLL;
import com.example.android_appordercoffee.DAL.ChiTietHoaDon_Adapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;
import com.example.android_appordercoffee.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ChiTietHoaDonActivity extends AppCompatActivity {
    ListView listView;
    TextView txtBan, txtTongThanhToan;
    TextView txtNgayXuat;
    TextView txtMaHoaDon;
    ChiTietHoaDon_BLL cthd;
    Button btnGhepBan , btnThanhToan ;
    BanBLL banBLL ;
    HoaDon_BLL hoadonBLL;
    private String maHD="";
    TextView txtTrangThai ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiethoadon);

        cthd = new ChiTietHoaDon_BLL(ChiTietHoaDonActivity.this);
        listView = findViewById(R.id.listView);
        txtBan = findViewById(R.id.txtBan);
        txtTongThanhToan = findViewById(R.id.txtTongThanhToan);
        btnGhepBan = findViewById(R.id.btnGhepBan);
        txtNgayXuat = findViewById(R.id.txtNgayXuat);
        txtMaHoaDon = findViewById(R.id.txtMaHoaDon);
        btnThanhToan = findViewById(R.id.btnThanhToan);
        hoadonBLL = new HoaDon_BLL(ChiTietHoaDonActivity.this);
        txtTrangThai = findViewById(R.id.txtTrangThai);

       /* //khởi tạo data
        //HoaDon_DTO(String mahd, String maban, String trangthai, String manv, String tenhd, String ngayxuat, String giora, String giovao) {
        HoaDon_DTO hd = new HoaDon_DTO("HD01","B01","Chua Thanh Toan","NV01","Ban 01","12/2/2023","12:30","12:30");
        HoaDon_DTO hd1 = new HoaDon_DTO("HD002","A01","Chua Thanh Toan","NV01","Ban 01","12/2/2023","12:30","12:30");
        HoaDon_DTO hd2 = new HoaDon_DTO("HD003","A02","Chua Thanh Toan","NV01","Ban 01","12/2/2023","12:30","12:30");
        hoadonBLL.AddHoaDon(hd);
        hoadonBLL.AddHoaDon(hd1);
        hoadonBLL.AddHoaDon(hd2);

<<<<<<< HEAD
        //khởi tạo data
        //String MaHoaDon , String MaSP, String TenSp, int SoLuong, float DonGia,float ThanhTien
        /*CT_HoaDon_DTO CTHD1 = new CT_HoaDon_DTO("HD002", "SP001", "Sữa Tươi", 1, 15000.0f, 15000.0f);
=======
        CT_HoaDon_DTO CTHD1 = new CT_HoaDon_DTO("HD002", "SP001", "Sữa Tươi", 1, 15000.0f, 15000.0f);
>>>>>>> 783ba7dec5ca83bdd955dc115a72f2efa87c9283
        CT_HoaDon_DTO CTHD2 = new CT_HoaDon_DTO("HD002", "SP002", "Cafe sữa", 1, 18000.0f, 18000.0f);
        CT_HoaDon_DTO CTHD3 = new CT_HoaDon_DTO("HD002", "SP003", "Coca", 1, 12000.0f, 12000.0f);
        CT_HoaDon_DTO CTHD21 = new CT_HoaDon_DTO("HD002", "SP004", "Sting", 1, 15000.0f, 15000.0f);
        CT_HoaDon_DTO CTHD22 = new CT_HoaDon_DTO("HD002", "SP005", "Cafe phin", 1, 18000.0f, 18000.0f);
        CT_HoaDon_DTO CTHD23 = new CT_HoaDon_DTO("HD002", "SP006", "Bò cụng", 1, 12000.0f, 12000.0f);

        cthd.AddChiTietHoaDon(CTHD1);
        cthd.AddChiTietHoaDon(CTHD2);
        cthd.AddChiTietHoaDon(CTHD3);
        cthd.AddChiTietHoaDon(CTHD21);
        cthd.AddChiTietHoaDon(CTHD22);
        cthd.AddChiTietHoaDon(CTHD23);

        CT_HoaDon_DTO CTHD01 = new CT_HoaDon_DTO("HD003", "SP001", "Trà sữa", 1, 15000.0f, 15000.0f);
        CT_HoaDon_DTO CTHD02= new CT_HoaDon_DTO("HD003", "SP002", "sinh tố", 1, 18000.0f, 18000.0f);
        CT_HoaDon_DTO CTHD03= new CT_HoaDon_DTO("HD003", "SP003", "Nước ép", 1, 12000.0f, 12000.0f);

        cthd.AddChiTietHoaDon(CTHD01);
        cthd.AddChiTietHoaDon(CTHD02);
        cthd.AddChiTietHoaDon(CTHD03);


        BanDTO banA = new BanDTO("A02","datcho");
        BanDTO banA1 = new BanDTO("A03","datcho");
        BanDTO banA2 = new BanDTO("A04","trong");
        BanDTO banA3 = new BanDTO("A05","trong");
        /*
        BanDTO banA4 = new BanDTO("A06","trong");
        BanDTO banA5 = new BanDTO("A07","trong");
        BanDTO banA6 = new BanDTO("A08","trong");
        BanDTO banA7 = new BanDTO("A09","trong");
        BanDTO banA8 = new BanDTO("A010","trong");
        BanDTO banA9 = new BanDTO("A011","trong");
        BanDTO banA10 = new BanDTO("A012","trong");

        banBLL.addBan(banA);
        banBLL.addBan(banA1);
        banBLL.addBan(banA2);
        banBLL.addBan(banA3);

        banBLL.addBan(banA4);
        banBLL.addBan(banA5);
        banBLL.addBan(banA6);
        banBLL.addBan(banA7);
        banBLL.addBan(banA8);
        banBLL.addBan(banA9);
        banBLL.addBan(banA10); */

        ArrayList<CT_HoaDon_DTO> lstCTHoaDon = cthd.getAllChiTietHoaDon("HD002");

        float tong = 0;
        maHD = "HD002";
        String maban = "B002";
        HoaDon_DTO _hoadon = hoadonBLL.getHoaDonByMaHoaDon(maHD);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(now);
        txtNgayXuat.setText("Ngày xuât: "+formattedDate);
        txtBan.setText("Tên bàn: "+ maban);
        txtTrangThai.setText("Trạng Thái: "+_hoadon.getTrangthai());
        for (CT_HoaDon_DTO items : lstCTHoaDon) {
            maHD= items.getMaHoaDon();
            tong += items.getThanhTien();
        }
        txtTongThanhToan.setText(ThemDauCham((int)tong)+"đ");
        txtMaHoaDon.setText("Mã Hóa Đơn: "+maHD);
        ChiTietHoaDon_Adapter perAdapter = new ChiTietHoaDon_Adapter(this, lstCTHoaDon);
<<<<<<< HEAD
        listView.setAdapter(perAdapter);*/
=======
        listView.setAdapter(perAdapter);

        btnGhepBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietHoaDonActivity.this, Hien_thi_ban.class);
                startActivity(intent);
            }
        });
        // Lấy Intent từ Activity trước đó
        Intent intent = getIntent();
        // Lấy dữ liệu từ Intent, ví dụ như một chuỗi
        String mabanghep = intent.getStringExtra("TenHoaDon");
        if(mabanghep != null){
            //lấy ra mã hóa đơn
            String _maHDChinh = maHD;
            String _mhd = hoadonBLL.getMaHoaDonByMaBan(mabanghep); //lasaa từ DB
            if(_mhd.length()!=0){
                //lấy danh sách chi tiết hóa đơn theo mã bàn
                ArrayList<CT_HoaDon_DTO> _listCTHoaDon = new ArrayList<>();
                _listCTHoaDon = cthd.getListCTHDByHoaDon(_mhd);
                int _sizeTam = _listCTHoaDon.size();
                //ghép bàn
                banBLL.ghepBan(maban + "-"+mabanghep, maHD);
                //add vào hóa đơn chính
                int sl_ListHD_Chinh = lstCTHoaDon.size(); //trước khi thêm
                for(CT_HoaDon_DTO item: _listCTHoaDon){
                    CT_HoaDon_DTO ct = new CT_HoaDon_DTO(_maHDChinh,item.getMaNuoc(),item.getTenNuoc(),item.getSoLuong(),item.getDonGia(),item.getThanhTien());
                    lstCTHoaDon.add(ct);
                }
                sl_ListHD_Chinh = lstCTHoaDon.size(); //sau khi thêm
                //xóa bảng hóa đơn bên kia
                cthd.deleteAllCTHaDonByMaHoaDon(_mhd);
                _listCTHoaDon = cthd.getListCTHDByHoaDon(_mhd);
                int i= _listCTHoaDon.size();
                //reloadActivity();
                Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show();
                //load lại tổng tiền
                lstCTHoaDon = cthd.getAllChiTietHoaDon("HD002");
                for (CT_HoaDon_DTO items : lstCTHoaDon) {
                    maHD= items.getMaHoaDon();
                    tong += items.getThanhTien();
                }
                txtTongThanhToan.setText(ThemDauCham((int)tong)+"đ");
                txtMaHoaDon.setText("Mã Hóa Đơn: "+maHD);
                txtBan.setText("Bàn: "+maban + "-"+mabanghep);
            }
            else {
                Toast.makeText(ChiTietHoaDonActivity.this, "Không tìm thấy hóa đơn", Toast.LENGTH_SHORT).show();
            }
        }
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //thanh toán hóa đơn
                hoadonBLL.ThanhToanHoaDon(maHD);
                if( hoadonBLL.ThanhToanHoaDon(maHD)==1){
                    HoaDon_DTO _hoadon = hoadonBLL.getHoaDonByMaHoaDon(maHD);
                    txtTrangThai.setText("Trạng Thái: "+_hoadon.getTrangthai());
                    Toast.makeText(ChiTietHoaDonActivity.this, "Thanh Toán Hoa Đơn Thành Công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ChiTietHoaDonActivity.this, "Thanh Toán Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void reloadActivity() {
        recreate();
    }
    public String ThemDauCham(int tien){
        double amount = (double)tien;
        DecimalFormat formatter = new DecimalFormat("#,##0");
        return formatter.format(amount);
>>>>>>> 783ba7dec5ca83bdd955dc115a72f2efa87c9283
    }
}