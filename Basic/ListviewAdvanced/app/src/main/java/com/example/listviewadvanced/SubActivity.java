package com.example.listviewadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView txtSubPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        txtSubPhone = findViewById(R.id.txtSubphone);
        // Nhận intent:
        Intent myGetIntent = getIntent();
        // Lấy dữ liệu:
        String namePhone = myGetIntent.getStringExtra("name");
        txtSubPhone.setText(namePhone);
    }
}