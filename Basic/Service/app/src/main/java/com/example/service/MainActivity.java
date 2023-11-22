package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPlay, btnStop;
    Boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo intent công khai để mở service:
                Intent firstIntent = new Intent(MainActivity.this, MyService.class);
                startService(firstIntent);
                // Gọi tới hàm onCreate()
                if(flag == true) {
                    btnPlay.setImageResource(R.drawable.pause);
                    flag = false;
                }
                else {
                    btnPlay.setImageResource(R.drawable.play);
                    flag = true;
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(MainActivity.this, MyService.class);
                // Gọi tới hàm onDestroy()
                stopService(secondIntent);
                btnPlay.setImageResource(R.drawable.play);
                flag = true;
            }
        });
    }
}