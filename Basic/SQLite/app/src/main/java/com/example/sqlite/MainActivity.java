package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMaLop, edtTenLop, edtSiSo;
    Button btnInsert, btnUpdate, btnDelete, btnQuery;
    ListView listView;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;
    SQLiteDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMaLop = findViewById(R.id.edtMaLop);
        edtTenLop = findViewById(R.id.edtTenLop);
        edtSiSo = findViewById(R.id.edtSiSo);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnQuery = findViewById(R.id.btnQuery);

        listView = findViewById(R.id.listView);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(myAdapter);

        // Tạo và mở cơ sở dữ liệu:
        myDB = openOrCreateDatabase("QLSV.db",MODE_PRIVATE, null);

        // Tạo table chứa dữ liệu:
        try {
            String sql = "CREATE TABLE tbllop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            myDB.execSQL(sql);
        } catch (Exception e) {
            //e.printStackTrace();
            Log.e("Error", "Table đã tồn tại!");
        }

        // Chức năng Insert:
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = edtMaLop.getText().toString();
                String tenLop = edtTenLop.getText().toString();
                int siSo = Integer.parseInt(edtSiSo.getText().toString());
                ContentValues myValue = new ContentValues();
                myValue.put("malop", maLop);
                myValue.put("tenlop", tenLop);
                myValue.put("siso", siSo);

                String msg = "";
                if (myDB.insert("tbllop", null, myValue) == -1) {
                    msg = "Failed to insert record!";
                } else {
                    msg = "Insert record successful!";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        // Chức năng Delete:
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = edtMaLop.getText().toString();
                int n = myDB.delete("tbllop", "malop = ?", new String[]{maLop});
                String msg = "";
                if (n == 0)
                    msg = "No record to delete!";
                else
                    msg = "Delete record successful!";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        // Chức năng Update:
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int siSo = Integer.parseInt(edtSiSo.getText().toString());
                String maLop = edtMaLop.getText().toString();

                ContentValues myValue = new ContentValues();
                myValue.put("siso", siSo);
                int n = myDB.update("tbllop", myValue, "malop = ?", new String[]{maLop});
                String msg = "";

                if(n == 0)
                    msg = "No record to update!";
                else
                    msg = "Update record successful!";

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        // Chức năng Query:
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.clear();
                Cursor myCursor = myDB.query("tbllop", null, null, null, null, null, null);
                myCursor.moveToNext();
                String data = "";

                while (myCursor.isAfterLast() == false) {
                    data = myCursor.getString(0) + " - " + myCursor.getString(1) + " - " + myCursor.getString(2);
                    myCursor.moveToNext();
                    myList.add(data);
                }
                myCursor.close();
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}