package com.example.bt.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.bt.R;

public class GridView1 extends AppCompatActivity {
    GridView GV_ten;
    String[] ten = {"A", "B", "C", "D", "E", "F", "G", "A", "B", "C", "D", "E", "F", "G", "A", "B", "C", "D", "E", "F", "G"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view1);
        GV_ten = (GridView) findViewById(R.id.gv_ten);
        ArrayAdapter arrayAdapter = new ArrayAdapter(GridView1.this, android.R.layout.simple_list_item_1, ten);
        GV_ten.setAdapter(arrayAdapter);
        GV_ten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridView1.this, ten[i],Toast.LENGTH_LONG ).show();
            }
        });
    }
}
