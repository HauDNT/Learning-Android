package com.example.chuyendoiam_duonglich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Khai bao cac bien giao dien:
    EditText edtDuongLich;
    Button btnChuyen;
    TextView txtAmLich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anh xa ID:
        edtDuongLich = findViewById(R.id.inputNamDuongLich);
        btnChuyen = findViewById(R.id.btnChuyen);
        txtAmLich = findViewById(R.id.txtAmLich);

        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String can = "", chi = "";
                int namDuong = Integer.parseInt(edtDuongLich.getText().toString());

                switch (namDuong % 10) {
                    case 0:
                        can = "Canh";
                        break;
                    case 1:
                        can = "Tân";
                        break;
                    case 2:
                        can = "Nhâm";
                        break;
                    case 3:
                        can = "Quý";
                        break;
                    case 4:
                        can = "Giáp";
                        break;
                    case 5:
                        can = "Ất";
                        break;
                    case 6:
                        can = "Bính";
                        break;
                    case 7:
                        can = "Đinh";
                        break;
                    case 8:
                        can = "Mậu";
                        break;
                    case 9:
                        can = "Kỳ";
                        break;
                }


                switch (namDuong % 12) {
                    case 0:
                        chi = "Thân";
                        break;
                    case 1:
                        chi = "Dậu";
                        break;
                    case 2:
                        chi = "Tuất";
                        break;
                    case 3:
                        chi = "Hợi";
                        break;
                    case 4:
                        chi = "Tí";
                        break;
                    case 5:
                        chi = "Sửu";
                        break;
                    case 6:
                        chi = "Dần";
                        break;
                    case 7:
                        chi = "Mẹo";
                        break;
                    case 8:
                        chi = "Thìn";
                        break;
                    case 9:
                        chi = "Tỵ";
                        break;
                    case 10:
                        chi = "Ngọ";
                        break;
                    case 11:
                        chi = "Mùi";
                        break;
                }

                txtAmLich.setText(can + " " + chi);
            }
        });
    }
}