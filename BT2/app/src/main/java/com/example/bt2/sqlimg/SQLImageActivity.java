package com.example.bt2.sqlimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.bt2.R;

import java.util.ArrayList;

public class SQLImageActivity extends AppCompatActivity {
    Button btAddImg;
    ListView lvDisPlay;
    ArrayList<DoVat> arrayList;
    AdapterObjects adapter;
    public static DataBaseImage dataBaseImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlimage);
        initEvent();
        setListener();
    }

    private void setListener() {
        btAddImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SQLImageActivity.this, AddObjectActivity.class));
            }
        });
    }

    private void initEvent() {
        btAddImg = (Button) findViewById(R.id.btAddImg);
        lvDisPlay = (ListView) findViewById(R.id.lvDisPlay);
        arrayList = new ArrayList<>();
        adapter = new AdapterObjects(this, R.layout.line_object, arrayList);
        lvDisPlay.setAdapter(adapter);
        dataBaseImage = new DataBaseImage(this, "Quanli.sqlite", null, 1);

        dataBaseImage.QueryData("CREATE TABLE IF NOT EXISTS Dovat(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenDV VARCHAR(150), Mota VARCHAR(250), Hinh BLOB)");

        Cursor cursor = dataBaseImage.getData("SELECT * FROM Dovat");
        while (cursor.moveToNext()) {
            arrayList.add(new DoVat(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getBlob(3)));
        }
        adapter.notifyDataSetChanged();
    }
}
