package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnTong, btnClear;
    TextView txtLichSu;
    String lichSu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnTong = findViewById(R.id.btnTong);
        btnClear = findViewById(R.id.btnClear);
        txtLichSu = findViewById(R.id.txtLichSu);

        // Đọc lại dữ liệu đã lưu trong Share Preferences:
        SharedPreferences myPre = getSharedPreferences("mySaver", MODE_PRIVATE);
        lichSu = myPre.getString("lichSu", "");
        txtLichSu.setText(lichSu);

        // Click button Tong:
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int tong = a + b;

                edtKQ.setText(tong + "");
                lichSu += a + " + " + b + " = " + tong;
                txtLichSu.setText(lichSu);
                lichSu += "\n";
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lichSu = "";
                txtLichSu.setText(lichSu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 4 bước lưu dữ liệu:
        SharedPreferences myPre = getSharedPreferences("mySaver", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = myPre.edit();
        myEdit.putString("lichSu", lichSu);
        myEdit.commit();
    }
}