package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt2.AppMusic.MediaAppActivity;
import com.example.bt2.FragmentOnClick.FragmentOnclickActivity;
import com.example.bt2.FragmentRemove.FragmentRemoveActivity;
import com.example.bt2.FragmentSendReceive.FragSendReceiveActivity;
import com.example.bt2.FragmentXMl.FragmentCreateActivity;
import com.example.bt2.Media.MediaSoundActivity;
import com.example.bt2.SQLImg.SQLImageActivity;
import com.example.bt2.SQLTask.SQLiteListActivity;

public class MainActivity extends AppCompatActivity {
    Button btMediaSound, btMediaApp, btSQLine, btSQLImg, btFragmentCreate, btFrag0nClick,
            btFragSend, btFragRemove, btFragList, btFragmentDialog;

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
        btFragmentCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentCreateActivity.class);
                startActivity(intent);
            }
        });
        btFrag0nClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentOnclickActivity.class);
                startActivity(intent);
            }
        });
        btFragSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragSendReceiveActivity.class);
                startActivity(intent);
            }
        });
        btFragRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentRemoveActivity.class);
                startActivity(intent);
            }
        });
        btFragList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentListActivity.class);
                startActivity(intent);
            }
        });
        btFragmentDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentDialogActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initEvent() {
        btMediaSound = (Button) findViewById(R.id.btMediaSound);
        btMediaApp = (Button) findViewById(R.id.btMediaApp);
        btSQLine = (Button) findViewById(R.id.btSQLineList);
        btSQLImg = (Button) findViewById(R.id.btSQLineImg);
        btFragmentCreate = (Button) findViewById(R.id.btFragmentCreate);
        btFrag0nClick = (Button) findViewById(R.id.btFragmentOnClick);
        btFragSend = (Button) findViewById(R.id.btFragmentSend);
        btFragRemove = (Button) findViewById(R.id.btFragRemove);
        btFragList = (Button) findViewById(R.id.btFragList);
        btFragmentDialog = (Button) findViewById(R.id.btFragmentDialog);
    }
}
