package com.example.tonghopcoban;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Lấy tất cả ID:
    EditText edtHoTen, edtCCCD, edtBoSung;
    RadioGroup idgroup;
    RadioButton rdbTrungCap, rdbCaoDang, rdbDaiHoc;
    CheckBox chk_docSach, chk_docBao, chk_coding;
    Button btn_guiThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID:
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCCCD = findViewById(R.id.edtCCCD);
        idgroup = findViewById(R.id.idgroup);
        rdbTrungCap = findViewById(R.id.rdbTrungCap);
        rdbCaoDang = findViewById(R.id.rdbCaoDang);
        rdbDaiHoc = findViewById(R.id.rdbDaiHoc);
        chk_docSach = findViewById(R.id.chk_docSach);
        chk_docBao = findViewById(R.id.chk_docBao);
        chk_coding = findViewById(R.id.chk_coding);
        edtBoSung = findViewById(R.id.edtBoSung);
        btn_guiThongTin = findViewById(R.id.btnGuiThongTin);

        // Xử lý click vào Button:
        btn_guiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin họ tên:
                String hoTen = edtHoTen.getText().toString();
                if (hoTen.length() < 3) {
                    Toast.makeText(MainActivity.this, "Họ tên phải từ 3 ký tự trở lên", Toast.LENGTH_SHORT).show();
                    edtHoTen.requestFocus();
                    edtHoTen.selectAll();
                    return;
                }

                // Lấy thông tin CCCD:
                String CCCD = edtCCCD.getText().toString();
                if (CCCD.length() != 12) {
                    Toast.makeText(MainActivity.this, "CCCD phải có 12 số", Toast.LENGTH_SHORT).show();
                    edtCCCD.requestFocus();
                    edtCCCD.selectAll();
                    return;
                }

                // Lấy thông tin bằng cấp:
                int indexSelected = idgroup.getCheckedRadioButtonId();  // Trả về id của button được chọn trong group
                RadioButton rdbSelected = findViewById(indexSelected);
                String bangCap = rdbSelected.getText().toString();

                // Lấy thông tin sở thích:
                String soThich = "";
                if (chk_docSach.isChecked())
                    soThich += chk_docSach.getText().toString() + "-";
                if (chk_docBao.isChecked())
                    soThich += chk_docBao.getText().toString() + "-";
                if (chk_coding.isChecked())
                    soThich += chk_coding.getText().toString() + "-";

                // Lấy thông tin bổ sung:
                String ttBoSung = edtBoSung.getText().toString();
                String tongHop =    "Họ và tên: " + hoTen + "\n" +
                                    "Căn cước công dân: " + CCCD + "\n" +
                                    "Bằng cấp: " + bangCap + "\n" +
                                    "Sở thích: " + soThich + "\n";
                tongHop += "\n---------THÔNG TIN BỔ SUNG---------\n";
                tongHop += ttBoSung + "\n";
                tongHop += "-----------------------------------------------------";


                // Tạo hộp thoại thông báo Dialog hiển thị tất cả thông tin lên:
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("THÔNG TIN CÁ NHÂN");
                myDialog.setMessage(tongHop);
                myDialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface thisDialog, int which) {
                        thisDialog.cancel();
                    }
                });
                myDialog.create();
                myDialog.show();
            }
        });
    }
}