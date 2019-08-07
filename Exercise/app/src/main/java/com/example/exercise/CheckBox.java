package com.example.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class CheckBox extends AppCompatActivity {
    Switch sw_wifi;
    android.widget.CheckBox cbA;
    android.widget.CheckBox cbI;
    android.widget.CheckBox cbP;
    Button bt_xn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        callID();
        sw_wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(CheckBox.this, "Bạn đã bật wf", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CheckBox.this, "Bạn đã tắt wf", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(CheckBox.this, "Bạn đã bật wf", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CheckBox.this, "Bạn đã tắt wf", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_xn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MH = " ";
                if (cbA.isChecked()) {
                    MH += cbA.getText();
                }
                if (cbI.isChecked()) {
                    MH += cbI.getText();
                }
                if (cbP.isChecked()) {
                    MH += " " + cbP.getText();
                }
                Toast.makeText(CheckBox.this, "Bạn đã chọn " + MH, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callID() {
        sw_wifi = (Switch) findViewById(R.id.sw_wf);
        cbA = (android.widget.CheckBox) findViewById(R.id.cbAndroid);
        cbI = (android.widget.CheckBox) findViewById(R.id.cbIos);
        cbP = (android.widget.CheckBox) findViewById(R.id.cbPhp);
        bt_xn = (Button) findViewById(R.id.btXacnhan);
    }
}
