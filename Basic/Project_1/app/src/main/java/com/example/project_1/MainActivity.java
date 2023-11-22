package com.example.project_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView TextViewHello;
    private static final String TAG = "MainActivity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewHello = findViewById(R.id.tvHello);
        TextViewHello.setText(("Hello Android!"));

        Log.i(TAG, "onCreate");
    }

    public void btnRegister_OnClick(View view) {
        Intent myIntent = new Intent(this, ActivityRegister.class);

        Bundle bundle = new Bundle();
        bundle.putString("name", "TienHau");

        myIntent.putExtra("data", bundle);
        startActivity(myIntent);
    }
}