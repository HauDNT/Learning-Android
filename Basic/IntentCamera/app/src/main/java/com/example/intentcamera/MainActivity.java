package com.example.intentcamera;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView myImg;
    ImageButton btnCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImg = findViewById(R.id.miImg);
        btnCapture = findViewById(R.id.btnCapture);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent ẩn để gọi đến ACTION_IMAGE_CAPTURE:
                Intent captureIntent = new Intent(ACTION_IMAGE_CAPTURE);
                // Yêu cầu quyền truy cập vào camera:
                if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // Yêu cầu quyền gọi điện
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CAMERA}, 1);
                    return;
                }
                // Khởi động Intent và chờ kết quả trả về:
                startActivityForResult(captureIntent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            myImg.setImageBitmap(photo);
        }
    }
}