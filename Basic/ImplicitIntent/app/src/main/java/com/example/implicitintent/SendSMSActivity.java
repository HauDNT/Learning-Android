package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends AppCompatActivity {
    EditText edtSMS;
    Button btnSMS, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smsactivity);

        edtSMS = findViewById(R.id.edtSMS);
        btnBack = findViewById(R.id.btnBack_2);
        btnSMS = findViewById(R.id.btnSend);

        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo intent ẩn gọi đến ứng dụng nhắn tin:
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + edtSMS.getText().toString()));
                startActivity(smsIntent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}