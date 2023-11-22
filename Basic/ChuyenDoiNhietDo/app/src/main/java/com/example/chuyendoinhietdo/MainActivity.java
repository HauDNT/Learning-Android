package com.example.chuyendoinhietdo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Khai bao cac bien giao dien:
    EditText txtF, txtC;
    Button btnCF, btnFC, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anh xa ID:
        txtF = findViewById(R.id.txtF);
        txtC = findViewById(R.id.txtC);
        btnCF = findViewById(R.id.btnCF);
        btnFC = findViewById(R.id.btnFC);
        btnClear = findViewById(R.id.btnClear);

        // Xu ly click:
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtC.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this,"Your celsius value can't be null!", Toast.LENGTH_SHORT).show();
                else {
                    DecimalFormat dcFormat = new DecimalFormat("0.000");

                    int C = Integer.parseInt(txtC.getText().toString());
                    double F = C * 1.8 + 32;
                    txtF.setText(dcFormat.format(F) + "");
                }
            }
        });

        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtF.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this,"Your farenheit value can't be null!", Toast.LENGTH_SHORT).show();
                else {
                    DecimalFormat dcFormat = new DecimalFormat("0.000");

                    float F = Integer.parseInt(txtF.getText().toString());
                    double C = (F - 32) / 1.8;
                    txtC.setText(dcFormat.format(C) + "");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtC.setText("");
                txtF.setText("");
            }
        });
    }
}