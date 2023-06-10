package com.example.android_appordercoffee.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.NhanVienDTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QL_QuanCafe.db";
    private static int DATABASE_VERSION = 1;

    private Context mContext;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    // Tao Bang
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create Table IF NOT EXISTS BAN(" +
                "MABAN TEXT NOT NULL," +
                "TRANGTHAI TEXT," +
                "CONSTRAINT PK_BAN PRIMARY KEY(MABAN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CALAM(" +
                "MACALAM TEXT NOT NULL," +
                "TENCALAM TEXT," +
                "THOIGIANBATDAU NUMERIC," +
                "THOIGIANKETTHUC NUMERIC," +
                "CONSTRAINT PK_CALAM PRIMARY KEY(MACALAM))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CHUCVU(" +
                "MACHUCVU TEXT NOT NULL," +
                "TENCHUCVU TEXT," +
                "CONSTRAINT PK_CHUCVU PRIMARY KEY(MACHUCVU))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS KHACHHANG(" +
                "MAKHACHHANG TEXT NOT NULL," +
                "THOIGIANDEN NUMERIC," +
                "MABAN TEXT," +
                "CONSTRAINT FK_KHACHHANG_BAN FOREIGN KEY(MABAN) REFERENCES BAN(MABAN)," +
                "CONSTRAINT PK_KHACHHANG PRIMARY KEY(MAKHACHHANG))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS LOAITHUCUONG(" +
                "MALOAI TEXT NOT NULL," +
                "TENLOAI TEXT," +
                "CONSTRAINT PK_LOAITHUCUONG Primary Key (MALOAI))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS NHANVIEN(" +
                "MANHANVIEN TEXT NOT NULL," +
                "MACHUCVU TEXT," +
                "TENNHANVIEN TEXT," +
                "NGSINH TEXT," +
                "GIOITINH TEXT," +
                "EMAIL TEXT," +
                "DIACHI TEXT," +
                "SDT TEXT," +
                "TAIKHOAN TEXT," +
                "MATKHAU TEXT," +
                "CONSTRAINT PK_NHANVIEN Primary Key (MANHANVIEN)," +
                "CONSTRAINT FK_NHANVIEN_CHUCVU Foreign Key (MACHUCVU) references CHUCVU(MACHUCVU))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS NHANVIEN_CO_CALAM(" +
                "MANHANVIEN TEXT NOT NULL," +
                "MACALAM TEXT NOT NULL," +
                "THOIGIANVAO NUMERIC," +
                "THOIGIANRA NUMERIC," +
                "CONSTRAINT PK_NHANVIEN_CO_CALAM Primary Key (MANHANVIEN, MACALAM)," +
                "CONSTRAINT FK_NHANVIEN_NHANVIEN__CALAM Foreign Key (MACALAM) references CALAM (MACALAM)," +
                "CONSTRAINT FK_NHANVIEN_NHANVIEN__NHANVIEN Foreign Key (MANHANVIEN) references NHANVIEN (MANHANVIEN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS HOADON(" +
                "MAHOADON TEXT NOT NULL," +
                "MANHANVIEN TEXT," +
                "TENHOADON TEXT," +
                "NGAYXUAT NUMERIC," +
                "TRANGTHAI TEXT," +
                "MABAN TEXT," +
                "GIOVAO NUMERIC," +
                "GIORA NUMERIC," +
                "CONSTRAINT PK_HOADON Primary Key (MAHOADON)," +
                "CONSTRAINT FK_HOADON_NHANVIEN Foreign Key (MANHANVIEN) references NHANVIEN (MANHANVIEN)," +
                "CONSTRAINT FK_HOADON_BAN FOREIGN KEY (MABAN) REFERENCES BAN(MABAN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS THUCUONG(" +
                "MANUOC TEXT NOT NULL," +
                "MALOAI TEXT," +
                "TENNUOC TEXT," +
                "GIA REAL," +
                "SIZE TEXT," +
                "TRANGTHAI TEXT," +
                "CONSTRAINT PK_THUCUONG Primary Key (MANUOC)," +
                "CONSTRAINT FK_THUCUONG_LOAITHUC Foreign Key (MALOAI) references LOAITHUCUONG (MALOAI))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CT_HOADON(" +
                "MANUOC TEXT NOT NULL," +
                "MAHOADON TEXT NOT NULL," +
                "TENNUOC TEXT," +
                "SL INTEGER," +
                "DONGIA REAL," +
                "THANHTIEN REAL," +
                "CONSTRAINT PK_CT_HOADON Primary Key (MANUOC, MAHOADON)," +
                "CONSTRAINT FK_CT_HOADO_CT_HOADON_THUCUONG Foreign Key (MANUOC) references THUCUONG (MANUOC)," +
                "CONSTRAINT FK_CT_HOADO_CT_HOADON_HOADON Foreign Key (MAHOADON) references HOADON (MAHOADON))";
        db.execSQL(sql);
    }
    public ArrayList<CT_HoaDon_DTO> getListCTHDByHoaDon(String MaHoaDon ){
        ArrayList<CT_HoaDon_DTO> list = new ArrayList<>();
        SQLiteDatabase rdb = getReadableDatabase();
        String query= "SELECT * FROM CT_HOADON WHERE MAHOADON ='"+MaHoaDon+"'";
        //Cursor rs = rdb.query("CT_HOADON", null, null, null, null,null, null);
        Cursor rs = rdb.rawQuery(query,null);
        while(rs != null && rs.moveToNext()) {
            String maNuoc = rs.getString(0).toString();
            String maHoaDon =rs.getString(1).toString();
            String tenNuoc =rs.getString(2).toString();
            int sl =Integer.parseInt(rs.getString(3).toString());
            float donGia =Float.valueOf(rs.getString(4).toString());
            float thanhTien = Float.valueOf(rs.getString(5).toString());
            CT_HoaDon_DTO cthd = new CT_HoaDon_DTO(maHoaDon,maNuoc,tenNuoc,sl,donGia,thanhTien);
            list.add(cthd);
        }
        return list;
    }
    public ArrayList<HoaDon_DTO> getListHDByHoaDon(String trangthai_ )
    {
        ArrayList<HoaDon_DTO> list = new ArrayList<>();
        SQLiteDatabase rdb = getReadableDatabase();
        String query= "SELECT * FROM HOADON where TRANGTHAI ='"+trangthai_+"'";

        //Cursor rs = rdb.query("HOADON", null, null);
        Cursor rs = rdb.rawQuery(query,null);
        while(rs != null && rs.moveToNext()) {

            String maban = rs.getString(5).toString();
            String mahoadon =rs.getString(0).toString();
            String trangthai =rs.getString(4).toString();

            HoaDon_DTO hd = new HoaDon_DTO(maban,mahoadon,trangthai, null, null, null, null, null);
            list.add(hd);
        }
        return list;
    }
    public long add_HoaDon(HoaDon_DTO hd) {
        ContentValues values = new ContentValues();
        values.put("MABAN", hd.getMaban());
        values.put("MAHOADON", hd.getMahd());
        values.put("TRANGTHAI", hd.getTrangthai());

      /*  "MAHOADON TEXT NOT NULL," +
                "MANHANVIEN TEXT," +
                "TENHOADON TEXT," +
                "NGAYXUAT NUMERIC," +
                "TRANGTHAI TEXT," +
                "MABAN TEXT," +
                "GIOVAO NUMERIC," +
                "GIORA NUMERIC," + */

        values.put("MANHANVIEN", hd.getManv());
        values.put("TENHOADON", hd.getTenhd());
        values.put("NGAYXUAT", hd.getNgayxuat());
        values.put("GIOVAO", hd.getGiovao());
        values.put("GIORA", hd.getGiora());

        SQLiteDatabase databse = getWritableDatabase();
        return databse.insert("HOADON", null, values);
    }
    public long add_CTHoaDon(CT_HoaDon_DTO cthd) {
        ContentValues values = new ContentValues();
        values.put("MANUOC", cthd.getMaNuoc());
        values.put("MAHOADON", cthd.getMaHoaDon());
        values.put("TENNUOC", cthd.getTenNuoc());
        values.put("SL", cthd.getSoLuong());
        values.put("DONGIA", cthd.getDonGia());
        values.put("THANHTIEN", cthd.getThanhTien());
        SQLiteDatabase databse = getWritableDatabase();
        return databse.insert("CT_HOADON", null, values);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    public int capNhatSLThucUong(CT_HoaDon_DTO cthd){
        ContentValues values = new ContentValues();
        values.put("MANUOC", cthd.getMaNuoc());
        values.put("MAHOADON", cthd.getMaHoaDon());
        values.put("TENNUOC", cthd.getTenNuoc());
        values.put("SL", cthd.getSoLuong());
        values.put("DONGIA", cthd.getDonGia());
        values.put("THANHTIEN", cthd.getThanhTien());
        SQLiteDatabase db = this.getWritableDatabase();
        //String queryWhere ="MANUOC = "+cthd.getMaNuoc()+" AND MAHOADON = "+cthd.getMaHoaDon()+"";
        //db.update("CT_HOADON", values, "MANUOC = "+cthd.getMaNuoc()+" AND MAHOADON = "+cthd.getMaHoaDon()+"", new String[] { "1" });
        int kq =db.update("CT_HOADON", values, "MANUOC = ? AND MAHOADON = ?", new String[] { cthd.getMaNuoc(), cthd.getMaHoaDon() });
        return kq;
    }
    public float getThanhTienCTHoaDon(String maHoaDon){
        float sum =0;
        SQLiteDatabase rdb = getReadableDatabase();
        String query= "SELECT * FROM CT_HOADON WHERE MAHOADON ='"+maHoaDon+"'";
        Cursor rs = rdb.rawQuery(query,null);
        while(rs != null && rs.moveToNext()) {
            float thanhTien = Float.valueOf(rs.getString(5).toString());
            sum+= thanhTien;
        }
        return sum;
    }
    public int deleteAllCTHaDonByMaHoaDon( String maHoaDon){
        SQLiteDatabase db = this.getWritableDatabase();
        int kq = db.delete("CT_HOADON","MAHOADON=?",new String[]{maHoaDon});
        return kq;
    }
    public HoaDon_DTO getHoaDonByMaHoaDon(String mahoa){
        /*
                "MAHOADON TEXT NOT NULL," +
                "MANHANVIEN TEXT," +
                "TENHOADON TEXT," +
                "NGAYXUAT NUMERIC," +
                "TRANGTHAI TEXT," +
                "MABAN TEXT," +
                "GIOVAO NUMERIC," +
                "GIORA NUMERIC," +
         */
        SQLiteDatabase rdb = getReadableDatabase();
        String query= "SELECT * FROM HOADON WHERE MAHOADON ='"+mahoa+"'";
        Cursor rs = rdb.rawQuery(query,null);
        HoaDon_DTO hd=null;
        while(rs != null && rs.moveToNext()) {
            hd = new HoaDon_DTO(rs.getString(0), rs.getString(5) , rs.getString(4), rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(6));
        }
        return hd;
    }
    public int ThanhToanHoaDon(String maHD ){
        ContentValues values = new ContentValues();
        values.put("TRANGTHAI", "Da Thanh Toan");
        SQLiteDatabase db = this.getWritableDatabase();
        int kq =db.update("HOADON", values, "MAHOADON = ?", new String[] { maHD });
        return kq;
    }
    public String getMaHoaDonByMaBan (String MaBan){
        SQLiteDatabase rdb = getReadableDatabase();
        String query= "SELECT * FROM HOADON WHERE MABAN ='"+MaBan+"'";
        Cursor rs = rdb.rawQuery(query,null);
        String MaHoaDon="";
        while(rs != null && rs.moveToNext()) {
            MaHoaDon =rs.getString(0).toString();
        }
        return MaHoaDon;
    }
    public int ghepBan(String TenHoaDon, String mahoadon){
        /*
                "MAHOADON TEXT NOT NULL," +
                "MANHANVIEN TEXT," +
                "TENHOADON TEXT," +
                "NGAYXUAT NUMERIC," +
                "TRANGTHAI TEXT," +
                "MABAN TEXT," +
                "GIOVAO NUMERIC," +
                "GIORA NUMERIC," +
        */
        ContentValues values = new ContentValues();
        values.put("TENHOADON", TenHoaDon);
        SQLiteDatabase db = this.getWritableDatabase();
        int kq =db.update("HOADON", values, "MAHOADON = ?", new String[] { mahoadon });
        return kq;
    }
}