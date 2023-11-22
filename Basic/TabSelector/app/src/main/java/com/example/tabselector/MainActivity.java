package com.example.tabselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnTong;
    TabHost myTab;

    // Khai báo Listview:
    ListView listView;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberA = Integer.parseInt(edtA.getText().toString());
                int numberB = Integer.parseInt(edtB.getText().toString());
                int tong = numberA + numberB;

                myList.add(numberA + " + " + numberB + " = " + tong);   // Thêm dữ liệu vào cho mảng.
                myAdapter.notifyDataSetChanged();                       // Cập nhật lại Adapter.

                // Bổ sung thêm: xuất ra thông báo
                Toast.makeText(MainActivity.this, numberA + " + " + numberB + " = " + tong, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControl() {
        // Ánh xạ ID:
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnTong = findViewById(R.id.btnTong);

        // Xử lý listview:
        listView = findViewById(R.id.listview);
        myList = new ArrayList<>(); // Tạo mảng rỗng
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myList);     // Tạo adapter
        listView.setAdapter(myAdapter);

        // Xử lý TabHost:
        myTab = findViewById(R.id.myTab);
        myTab.setup();

        // Khai báo các Tab con (TabSpec):
        TabHost.TabSpec spec1, spec2;

        // Ứng với mỗi tab con, chúng ta thực hiện 4 công việc:
        // Tab1:
        spec1 = myTab.newTabSpec("tab1");   // Tạo mới Tab
        spec1.setContent(R.id.tab1);            // Tham chiếu id cho tab1
        spec1.setIndicator("", getResources().getDrawable(R.drawable.cong));    // Tạo ảnh đại diện/nhãn/icon cho tab.
        myTab.addTab(spec1);    // Thêm tab1 vào tab chính.

        spec2 = myTab.newTabSpec("tab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("", getResources().getDrawable(R.drawable.lichsu));
        myTab.addTab(spec2);
    }
}