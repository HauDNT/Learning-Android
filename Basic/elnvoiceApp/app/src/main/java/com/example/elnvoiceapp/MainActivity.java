package com.example.elnvoiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etStartElecIndex, etEndElecIndex;
    Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etStartElecIndex = findViewById(R.id.soChuDienDauKy);
        etEndElecIndex = findViewById(R.id.soChuDiencuoiKy);
        btnTinh = findViewById(R.id.btnTinh);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTinh_onClick(view);
            }
        });
    }

    public void btnTinh_onClick(View view) {
        float start = Float.parseFloat(etStartElecIndex.getText().toString());
        float end = Float.parseFloat(etEndElecIndex.getText().toString());

        float result = end - start;

        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putFloat("result", result);
        intent.putExtra("data", bundle);
        startActivity(intent);

        //Toast.makeText(this, "Số chữ điện tiêu thụ trong tháng: " + result, Toast.LENGTH_SHORT).show();
    }
}