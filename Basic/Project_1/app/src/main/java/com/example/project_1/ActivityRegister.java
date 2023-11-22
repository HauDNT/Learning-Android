package com.example.project_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*
        - Nhận intent được gửi đến.
        - Lấy bundle được gửi kèm theo và đọc giá trị key "name".
        - Dùng kỹ thuật Toast để hiển thị thông tin.
         */
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("data");
        String name = bundle.getString("name");

        // Kỹ thuật hiển thị thông tin:
        Toast.makeText(this, "Your name is: " + name, Toast.LENGTH_LONG).show();
    }
}