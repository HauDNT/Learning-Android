package com.example.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView myWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebview = findViewById(R.id.myWebview);
        Intent myIntent = getIntent();
        Uri myLink = myIntent.getData();
        try {
            myWebview.loadUrl(myLink.toString());
        } catch (Exception e)
        {
//            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}