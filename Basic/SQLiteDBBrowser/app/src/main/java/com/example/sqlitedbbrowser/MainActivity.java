package com.example.sqlitedbbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Khai báo các biến liên quan đến Database:
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;
    String DATABASE_NAME = "QLSach.db";

    // Khai báo Listview:
    ListView listView;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo các tham số cho Listview:
        listView = findViewById(R.id.listView);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(myAdapter);

        // Kiểm tra và yêu cầu quyền truy cập bộ nhớ ngoài
        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        } else {
            // Quyền đã được cấp, tiếp tục thực hiện công việc
            processCopy();
            queryData();
        }
    }

    private void queryData() {
        // Truy vấn:
        database = openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);
        Cursor myCursor = database.query("tbsach",null,null,null,null,null,null);
        String data = "";
        myCursor.moveToFirst();

        while (myCursor.isAfterLast() == false) {
            data = myCursor.getString(0) + " - " + myCursor.getString(1) + " - " + myCursor.getString(2) + myCursor.getString(3);
            myList.add(data);
            myCursor.moveToNext();
        }
        myCursor.close();
        myAdapter.notifyDataSetChanged();
    }

    private void processCopy() {
        // Private app:
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            try {
                CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying success from Assets folder!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    public void CopyDataBaseFromAsset() {
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);

            // Path to the just created empty db:
            String outFileName = getDatabasePath();

            // If the path doesn't exist first, create it:
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!f.exists())
                f.mkdir();

            // Open the empty database as the output stream:
            OutputStream myOutPut = new FileOutputStream(outFileName);

            // Trasfer bytes from the input file to the output file
            // Truyền bytes dữ liệu từ input đến output:
            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutPut.write(buffer);

            // Close the stream:
            myOutPut.flush();
            myOutPut.close();
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}