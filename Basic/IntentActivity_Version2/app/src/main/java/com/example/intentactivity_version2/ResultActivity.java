package com.example.intentactivity_version2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView txtNghiem;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Ánh xạ ID:
        Toast.makeText(ResultActivity.this, "1.1", Toast.LENGTH_SHORT).show();
        txtNghiem = findViewById(R.id.txtNghiem);
        btnBack = findViewById(R.id.btnBack);

        // Lấy intent:
        Intent getIntent = getIntent();

        // Lấy Bundle khỏi Intent:
        Bundle getBundle = getIntent.getBundleExtra("myPackage");

        // Lấy dữ liệu khỏi Bundle:
        float firstNumber = getBundle.getFloat("firstNumber");
        float secondNumber = getBundle.getFloat("secondNumber");

        // Tiến hành giải phương trình bậc I:
        String nghiem = "";
        if (firstNumber == 0 && secondNumber == 0)
            nghiem = "Vô số nghiệm!";
        else if (firstNumber == 0 && secondNumber != 0)
            nghiem = "Vô nghiệm!";
        else {
            nghiem = String.valueOf((-1.0)*(secondNumber / firstNumber));
        }
        txtNghiem.setText(nghiem);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}