package com.example.bt.ex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bt.R;

import java.util.ArrayList;

public class DialogActivity extends AppCompatActivity {
    ListView lvDialog;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        lvDialog = (ListView) findViewById(R.id.lvDialog);
        arrayList = new ArrayList<>();
        addArray();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvDialog.setAdapter(arrayAdapter);
        lvDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacThuc(i);
            }
        });

    }

    private void XacThuc(final int position) {
        String nameMH = arrayList.get(position);
        final AlertDialog.Builder aler = new AlertDialog.Builder(this);
        aler.setTitle("Thong bao!");
        aler.setIcon(R.mipmap.ic_launcher);
        aler.setMessage("Ban co muon xoa mon hoc "+ nameMH +" khong?");
        aler.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        aler.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        aler.show();

    }

    private void addArray() {
        arrayList.add("Android");
        arrayList.add("Ios");
        arrayList.add("NodeJs");
        arrayList.add("Unity");
    }
}
