package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt.CustomListView.custum;
import com.example.bt.GridView.EditText;
import com.example.bt.GridView.GView2;
import com.example.bt.GridView.GridView1;
import com.example.bt.ListView.ImgView;
import com.example.bt.ListView.ListView1;
import com.example.bt.ex.App;
import com.example.bt.ex.ButtonCustomActivity;
import com.example.bt.ex.CheckBox;
import com.example.bt.ex.CheckWF;
import com.example.bt.ex.DrawbleActivity;
import com.example.bt.ex.MenuDemoActivity;
import com.example.bt.ex.ProBars;

public class MainActivity extends AppCompatActivity {
    Button Run;
    Button ProBar;
    Button EText;
    Button CBox;
    Button CBoximg;
    Button db_activity;
    Button APP;
    Button BT1;
    Button BT2;
    Button BT3;
    Button BT4;
    Button BT5;
    Button BT6;
    Button mnDemo;
    Button Popup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callID();
        APP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, App.class);
                startActivity(intent);
            }
        });
        EText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditText.class);
                startActivity(intent);
            }
        });
        ProBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProBars.class);
                startActivity(intent);
            }
        });
        CBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckWF.class);
                startActivity(intent);
            }
        });
        CBoximg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckBox.class);
                startActivity(intent);
            }
        });
        Run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.bt.ex.Run.class);
                startActivity(intent);
            }
        });
        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListView1.class);
                startActivity(intent);
            }
        });
        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridView1.class);
                startActivity(intent);
            }
        });
        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GView2.class);
                startActivity(intent);
            }
        });
        BT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, custum.class);
                startActivity(intent);
            }
        });
        BT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImgView.class);
                startActivity(intent);
            }
        });
        BT6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ButtonCustomActivity.class);
                startActivity(intent);
            }
        });
        db_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawbleActivity.class);
                startActivity(intent);
            }
        });
        mnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuDemoActivity.class);
                startActivity(intent);
            }
        });
        Popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PopupMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void callID() {
        Run = (Button) findViewById(R.id.run);
        EText = (Button) findViewById(R.id.edtext);
        CBox = (Button) findViewById(R.id.cbwf);
        CBoximg = (Button) findViewById(R.id.cboximg);
        ProBar = (Button) findViewById(R.id.Progressbars);
        db_activity = (Button) findViewById(R.id.sheapselect);
        APP = (Button) findViewById(R.id.app);
        BT1 = (Button) findViewById(R.id.bai1);
        BT2 = (Button) findViewById(R.id.bai2);
        BT3 = (Button) findViewById(R.id.bai3);
        BT4 = (Button) findViewById(R.id.bai4);
        BT5 = (Button) findViewById(R.id.bai5);
        BT6 = (Button) findViewById(R.id.bai6);
        mnDemo = (Button) findViewById(R.id.menuDemo);
        Popup = (Button) findViewById(R.id.menuPopup);
    }
}