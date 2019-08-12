package com.example.bt.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.bt.R;

public class LifecycleActivity extends Activity {
    TextView txtNhan;

    public LifecycleActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        txtNhan = (TextView) findViewById(R.id.txtNhan);
        Intent intent = getIntent();
        String noidungString = intent.getStringExtra("11");
        int nd = intent.getIntExtra("name", 123);
        String[] arraycount = intent.getStringArrayExtra("Mang");
        StudientActivity hs = (StudientActivity) intent.getSerializableExtra("obj");
        Bundle bundle = intent.getBundleExtra("data");
        if (bundle != null) {
            String chuoi1 = bundle.getString("chuoi");
            int chuoi2 = bundle.getInt("so");
            String[] chuoi3 = bundle.getStringArray("mangten");
            StudientActivity chuoi4 = (StudientActivity) bundle.getSerializable("objs");
            txtNhan.setText(noidungString + " " + nd + " " + arraycount.length + " " + arraycount[2] + " " + hs.getTen() + "_" + hs.getNS() + chuoi1 + chuoi2 + chuoi3[0] + chuoi4.getNS()+ chuoi4.getTen());
        }

        Log.d("AAA", "OnCreate");
    }
}
