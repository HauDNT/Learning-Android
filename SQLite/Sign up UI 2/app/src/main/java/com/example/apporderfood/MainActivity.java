package com.example.apporderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import database.CreateDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateDatabase createDB = new CreateDatabase(this);
        createDB.Open();
    }
}