package com.example.spp_15112023_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Khai bao cac bien giao dien:
    EditText txtA, txtB, txtResult;
    Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anh xa id cho cac bien giao dien:
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtResult = findViewById(R.id.txtResult);
        btnSum = findViewById(R.id.btnSum);

        // Xu ly tuong tac voi nguoi dung (click):
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lay du lieu tu txtA => int:
                int getNumberInEditText_A = Integer.parseInt(txtA.getText().toString());
                int getNumberInEditText_B = Integer.parseInt(txtB.getText().toString());
                int result = getNumberInEditText_A + getNumberInEditText_B;
                // Hien thi ket qua:
                txtResult.setText(result + "");
            }
        });
    }
}