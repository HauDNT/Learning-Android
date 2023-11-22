package database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase extends SQLiteOpenHelper {
    // Khai báo các bảng:
    public static final String TABLE_NHANVIEN = "NHANVIEN";
    public static final String TABLE_MONAN = "MONAN";
    public static final String TABLE_LOAIMONAN = "LOAIMONAN";
    public static final String TABLE_BANAN = "BANAN";
    public static final String TABLE_GOIMON = "GOIMON";
    public static final String TABLE_CHITIETGOIMON = "CHITIETGOIMON";

    // Khai báo trường thông tin bảng NHANVIEN:
    public static final String TABLE_NHANVIEN_MANV = "MANV";
    public static final String TABLE_NHANVIEN_TENDN = "TENDN";
    public static final String TABLE_NHANVIEN_MATKHAU = "MATKHAU";
    public static final String TABLE_NHANVIEN_GIOITINH = "GIOITINH";
    public static final String TABLE_NHANVIEN_NGAYSINH = "NGAYSINH";
    public static final String TABLE_NHANVIEN_CMND = "CMND";

    // Khai báo trường thông tin bảng MONAN:
    public static final String TABLE_MONAN_MAMON = "MAMON";
    public static final String TABLE_MONAN_TENMON = "TENMON";
    public static final String TABLE_MONAN_GIATIEN = "GIATIEN";
    public static final String TABLE_MONAN_MALOAI = "MALOAI";

    // Khai báo trường thông tin bảng LOAIMONAN:
    public static final String TABLE_LOAIMONAN_MALOAI = "MALOAI";
    public static final String TABLE_LOAIMONAN_TENLOAI = "TENLOAI";

    // Khai báo trường thông tin bảng BANAN:
    public static final String TABLE_BANAN_MABAN = "MABAN";
    public static final String TABLE_BANAN_TENBAN = "TENBAN";
    public static final String TABLE_BANAN_TINHTRANG = "TINHTRANG";

    // Khai báo trường thông tin bảng GOIMON:
    public static final String TABLE_GOIMON_MAGOIMON = "MAGOIMON";
    public static final String TABLE_GOIMON_MANV = "MANV";
    public static final String TABLE_GOIMON_NGAYGOI = "NGAYGOI";
    public static final String TABLE_GOIMON_TINHTRANG= "TINHTRANG";
    public static final String TABLE_GOIMON_MABAN = "MABAN";

    // Khai báo trường thông tin bảng CHITIETGOIMON:
    public static final String TABLE_CHITIETGOIMON_MAGOIMON = "MAGOIMON";
    public static final String TABLE_CHITIETGOIMON_MAMONAN = "MAMONAN";
    public static final String TABLE_CHITIETGOIMON_SOLUONG= "SOLUONG";

    public CreateDatabase (Context context) {
        super(context, "OrderFood", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        String table_NhanVien = "CREATE TABLE " + TABLE_NHANVIEN + "(" +
                                TABLE_NHANVIEN_MANV + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                TABLE_NHANVIEN_TENDN + " TEXT, " +
                                TABLE_NHANVIEN_MATKHAU + " TEXT, " +
                                TABLE_NHANVIEN_GIOITINH + " TEXT, " +
                                TABLE_NHANVIEN_NGAYSINH + " TEXT, " +
                                TABLE_NHANVIEN_CMND + " TEXT)";
        String table_BanAn =    "CREATE TABLE " + TABLE_BANAN + "(" +
                                TABLE_BANAN_MABAN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                TABLE_BANAN_TENBAN + " TEXT, " +
                                TABLE_BANAN_TINHTRANG + " TEXT)";

        String table_MonAn =    "CREATE TABLE " + TABLE_MONAN + "(" +
                                TABLE_MONAN_MAMON + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                TABLE_MONAN_TENMON + " TEXT, " +
                                TABLE_MONAN_MALOAI + " INTEGER, " +
                                TABLE_MONAN_GIATIEN + "TEXT)";
        String table_LoaiMonAn =    "CREATE TABLE " + TABLE_LOAIMONAN + "(" +
                                    TABLE_LOAIMONAN_MALOAI + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    TABLE_LOAIMONAN_TENLOAI + " TEXT)";
        String table_GoiMon =   "CREATE TABLE " + TABLE_GOIMON + "(" +
                                TABLE_GOIMON_MAGOIMON + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                TABLE_GOIMON_MABAN + " INTEGER, " +
                                TABLE_GOIMON_MANV + " INTEGER, " +
                                TABLE_GOIMON_NGAYGOI + " TEXT, " +
                                TABLE_GOIMON_TINHTRANG + " TEXT)";
        String table_ChiTietGoiMon =    "CREATE TABLE " + TABLE_CHITIETGOIMON + "(" +
                                        TABLE_CHITIETGOIMON_MAGOIMON + "INTEGER, " +
                                        TABLE_CHITIETGOIMON_MAMONAN + " INTEGER, " +
                                        TABLE_CHITIETGOIMON_SOLUONG + " INTEGER, " +
                                        "PRIMARY KEY (" + TABLE_CHITIETGOIMON_MAMONAN + ", " + TABLE_CHITIETGOIMON_MAMONAN + "))";

        myDatabase.execSQL(table_NhanVien);
        myDatabase.execSQL(table_BanAn);
        myDatabase.execSQL(table_MonAn);
        myDatabase.execSQL(table_LoaiMonAn);
        myDatabase.execSQL(table_GoiMon);
        myDatabase.execSQL(table_ChiTietGoiMon);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase Open() {
        return this.getReadableDatabase();
    }
}
