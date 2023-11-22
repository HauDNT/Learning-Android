package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallPhoneActivity extends AppCompatActivity {
    EditText edtPhone;
    Button btnCall, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        edtPhone = findViewById(R.id.edtPhone);
        btnCall = findViewById(R.id.btnCall);
        btnBack = findViewById(R.id.btnBack_1);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent ẩn:
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + edtPhone.getText().toString()));

                // Yêu cầu sự đồng ý của người dùng để truy cập tính năng gọi điện:
                if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallPhoneActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                    return;
                }

                startActivity(callIntent);
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