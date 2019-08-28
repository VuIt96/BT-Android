package com.example.bt2.fragmentstudient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.bt2.R;

public class FragmentDisplayActivity extends AppCompatActivity implements TransferStudents {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_display);
    }

    @Override
    public void DataStudien(StudientFrag studientFrag) {
        FragmentStudientInfo studientInfo = (FragmentStudientInfo) getFragmentManager().findFragmentById(R.id.fragmentInfo);
        Configuration configuration = getResources().getConfiguration();
        if (studientInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {//&& studientInfo.isInLayout()
            studientInfo.setInfoStudient(studientFrag);
        } else {
            Intent intent = new Intent(FragmentDisplayActivity.this, StudientInfomation.class);
            intent.putExtra("thongtinsv", studientFrag);
            startActivity(intent);
        }

    }
}
