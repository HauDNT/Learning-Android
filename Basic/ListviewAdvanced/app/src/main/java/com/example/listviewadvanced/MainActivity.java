package com.example.listviewadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.samsung, R.drawable.ip, R.drawable.htc, R.drawable.wp, R.drawable.lg, R.drawable.sky};
    String name[] = {"Samsung", "Iphone", "HTC Phone", "Windows Phone", "LG Phone", "Sky Phone"};

    // Khai báo Listview:
    ArrayList<Phone> myList;
    MyArrayAdapter myAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        myList = new ArrayList<>(); // Tạo mới mảng rỗng
        for (int i = 0; i < name.length; i++) {
            myList.add(new Phone(image[i], name[i]));
        }
        myAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, myList);
        listView.setAdapter(myAdapter);

        // Xử lý onClick:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myItent = new Intent(MainActivity.this, SubActivity.class);
                myItent.putExtra("name", name[position]);
                startActivity(myItent);
            }
        });
    }
}