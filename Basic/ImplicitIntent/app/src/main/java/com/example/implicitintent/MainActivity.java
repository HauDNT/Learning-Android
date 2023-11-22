package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCall, btnSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSendSMS);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToCall = new Intent(MainActivity.this, CallPhoneActivity.class);
                startActivity(intentToCall);
            }
        });

        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToSMS = new Intent(MainActivity.this, SendSMSActivity.class);
                startActivity(intentToSMS);
            }
        });
    }
}