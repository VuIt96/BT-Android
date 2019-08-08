package com.example.bt.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.bt.R;

import java.util.ArrayList;

public class GView2 extends AppCompatActivity {
    GridView GV_img;
    ArrayList<Images> arrayimg;
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gview2);
        callID();

        adapter = new ImageAdapter(this,R.layout.dong_layout, arrayimg);
        GV_img.setAdapter(adapter);
    }

    private void callID() {
        GV_img = (GridView)findViewById(R.id.gv_img);
        arrayimg = new ArrayList<>();
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay1));
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay2));
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay3));
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay4));
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay1));
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay2));
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay3));
        arrayimg.add(new Images("Hinh 1",R.drawable.traicay4));
    }
}
