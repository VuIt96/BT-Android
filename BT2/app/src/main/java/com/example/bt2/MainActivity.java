package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt2.AppMusic.MediaAppActivity;
import com.example.bt2.Media.MediaSoundActivity;
import com.example.bt2.SQLTask.SQLiteListActivity;

public class MainActivity extends AppCompatActivity {
    Button btMediaSound, btMediaApp, btSQLine, btSQLImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
        setListener();

    }

    private void setListener() {
        btMediaSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MediaSoundActivity.class);
                startActivity(intent);
            }
        });
        btMediaApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MediaAppActivity.class);
                startActivity(intent);
            }
        });
        btSQLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SQLiteListActivity.class);
                startActivity(intent);
            }
        });
        btSQLImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SQLImageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initEvent() {
        btMediaSound = (Button) findViewById(R.id.btMediaSound);
        btMediaApp = (Button) findViewById(R.id.btMediaApp);
        btSQLine = (Button) findViewById(R.id.btSQLineList);
        btSQLImg = (Button) findViewById(R.id.btSQLineImg);
    }
}
