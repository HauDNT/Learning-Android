package com.example.intentbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtLink;
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLink = findViewById(R.id.edtLink);
        btnOpen = findViewById(R.id.btnOpen);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai bao intent an:
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + edtLink.getText().toString()));
                startActivity(myIntent);
            }
        });
    }
}