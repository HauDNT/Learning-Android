package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String myPhone[] = {"Điện thoại Samsung",
                        "Điện thoại Iphone",
                        "Điện thoại Oppo",
                        "Điện thoại Nokia",
                        "Điện thoại Bphone"};
    ArrayAdapter<String> myAdapter;
    ListView listView;
    TextView txtSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID:
        txtSelect = findViewById(R.id.txtSelect);
        listView = findViewById(R.id.listView);

        // Thiết lập dữ liệu cho listview:
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myPhone);
        listView.setAdapter(myAdapter);

        // Bắt sự kiện cho từng item của listview:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Hiển thị vị trí và nội dung tại item được click chọn:
                txtSelect.setText("Vị trí: " + i + "\n" + myPhone[i]);
            }
        });

    }
}