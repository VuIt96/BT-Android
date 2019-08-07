package com.example.exercise;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button imgView;
    Button edtText;
    Button ranDom;
    Button chBox;
    Button proBar;
    Button skbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callID();
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageView.class);
                startActivity(intent);
            }
        });
        ranDom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Random.class);
                startActivity(intent);
            }
        });
        edtText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditText.class);
                startActivity(intent);
            }
        });
        chBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheckBox.class);
                startActivity(intent);
            }
        });
        proBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Progressbars.class);
                startActivity(intent);
            }
        });
        skbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Seekbars.class);
                startActivity(intent);
            }
        });
    }

    private void callID() {
        imgView = (Button) findViewById(R.id.imageview);
        edtText = (Button) findViewById(R.id.edittext);
        ranDom = (Button) findViewById(R.id.bt_random);
        chBox = (Button) findViewById(R.id.bt_chk);
        proBar = (Button) findViewById(R.id.bt_proBar);
        skbar = (Button)findViewById(R.id.bt_sk);
    }
}
