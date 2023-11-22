package com.example.intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText edtGetData;
    Button btnSendRealData, btnSendSquareData;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        edtGetData = findViewById(R.id.edtGetData);
        btnSendRealData = findViewById(R.id.btnSendRealData);
        btnSendSquareData = findViewById(R.id.btnSendSquareData);
        myIntent = getIntent();

        float getData = myIntent.getFloatExtra("Data", 0);
        edtGetData.setText(getData + "");

        btnSendRealData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("result", getData);
                setResult(0, myIntent);
                finish();
            }
        });

        btnSendSquareData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("result", getData * getData);
                setResult(1, myIntent);
                finish();
            }
        });
    }
}