package com.example.intentactivity_version2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtFirstNumber, edtSecondNumber;
    Button btnGiaiPT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFirstNumber = findViewById(R.id.edtFirstNumber);
        edtSecondNumber = findViewById(R.id.edtSecondNumber);
        btnGiaiPT = findViewById(R.id.btnGiaiPT);

        // Xử lý click button giải phương trình:
        btnGiaiPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo intent:
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);

                // Lấy dữ liệu:
                float firstNumber = Float.parseFloat(edtFirstNumber.getText().toString());
                float secondNumber = Float.parseFloat(edtSecondNumber.getText().toString());

                // Đóng gói dữ liệu vào Bundle:
                Bundle myBundle = new Bundle();
                myBundle.putFloat("firstNumber", firstNumber);
                myBundle.putFloat("secondNumber", secondNumber);
                // Đưa Bundle vào Intent:
                myIntent.putExtra("myPackage", myBundle);

                // Khởi động Intent (myIntent hiện đã chứa dữ liệu đầy đủ):
                startActivity(myIntent);
            }
        });
    }
}