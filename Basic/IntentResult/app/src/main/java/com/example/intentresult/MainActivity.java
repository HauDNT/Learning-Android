package com.example.intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtData, edtResult;
    Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtData = findViewById(R.id.edtData);
        edtResult = findViewById(R.id.edtResult);
        btnRequest = findViewById(R.id.btnRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                float data = Float.parseFloat(edtData.getText().toString());
                myIntent.putExtra("Data", data);
                startActivityForResult(myIntent, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 99 && resultCode == 0) {
            float result = data.getFloatExtra("result", 0);
            edtResult.setText("Giá trị gốc là: " + result);
        }
        else if (requestCode == 99 && resultCode == 1) {
            float result = data.getFloatExtra("result", 0);
            edtResult.setText("Giá trị bình phương là: " + result);
        }
    }
}