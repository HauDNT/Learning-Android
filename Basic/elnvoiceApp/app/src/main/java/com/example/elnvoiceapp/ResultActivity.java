package com.example.elnvoiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");

        float result = bundle.getFloat("result");

        TextView tv = findViewById(R.id.textViewResult);
        tv.setText("Số điện tiêu thụ trong tháng là: " + result);
    }
}