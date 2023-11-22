package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer myPlayer;

    // Hàm này được dùng khi service trao đổi thông tin với activity:
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Hàm khởi tạo các đối tượng mà service quản lý:
    public void onCreate() {
        super.onCreate();
        myPlayer = MediaPlayer.create(MyService.this, R.raw.giacatluong);
        myPlayer.setLooping(true);
    }

    // Hàm để khởi động Service:
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    // Hàm dừng đối tượng mà Service quản lý:
    @Override
    public void onDestroy() {
        super.onDestroy();
        myPlayer.stop();
    }
}