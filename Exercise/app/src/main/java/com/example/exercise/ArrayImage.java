package com.example.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ArrayImage extends AppCompatActivity {
    LinearLayout lnl_image;
    ArrayList<Integer> arrayimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_image);
        lnl_image = (LinearLayout) findViewById(R.id.linear);
        arrayimage = new ArrayList<>();
        arrayimage.add(R.drawable.android);
        arrayimage.add(R.drawable.bg_android);
        arrayimage.add(R.drawable.androids);
        Random random = new Random();
//        int vtri = random.nextInt(arrayimage.size());
//        lnl_image.setBackgroundResource(arrayimage.get(vtri));
    }
}
