package com.example.bt2.fragmentstudient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bt2.R;

public class StudientInfomation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studient_infomation);
        Intent intent = getIntent();
        StudientFrag studientFrag = (StudientFrag) intent.getSerializableExtra("thongtinsv");

        FragmentStudientInfo studientInfo = (FragmentStudientInfo) getFragmentManager().findFragmentById(R.id.fragmentinfomation);
        studientInfo.setInfoStudient(studientFrag);
    }
}
