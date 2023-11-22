package com.example.listviewadvanced;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idLayout;
    ArrayList<Phone> myList;

    //Constructor để MainActivity gọi đến để truyền các tham số vào:
    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Phone> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    // Sắp xếp và hiển thị dữ liệu:
    // Gọi hàm getView để sắp xếp dữ liệu:

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tạo một cái đế (Inflater) để chứa layout:
        LayoutInflater inflater = context.getLayoutInflater();

        // Đặt ID layout lên đế để tạo thành đối tượng View:
        convertView = inflater.inflate(idLayout, null);

        // Lấy 1 phần tử trong mảng:
        Phone myPhone = myList.get(position);   // postion là biến index của mảng dữ liệu (Tăng từ 0 -> phần tử cuối cùng)

        // Khai báo, tham chiếu ID và hiển thị lên ImageView:
        ImageView imgPhone = convertView.findViewById(R.id.imgPhone);
        imgPhone.setImageResource(myPhone.getImage());

        // Khai báo, tham chiếu ID và hiển thị tên điện thoại lên TextView:
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        txtPhone.setText(myPhone.getName());

        // Mỗi phần tử hiển thị xong thì nó sẽ return và hiển thị lên Listview:
        return convertView;
    }
}
