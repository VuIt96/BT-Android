package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderActivity extends AppCompatActivity {
    TextView txtCaleder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        txtCaleder = (TextView) findViewById(R.id.tvCaleder);
        Calendar calendar = Calendar.getInstance();
        txtCaleder.append(calendar.getTime() + "\n");
        txtCaleder.append(calendar.get(Calendar.DATE) + "\n");
        txtCaleder.append(calendar.get(Calendar.MONTH) + "\n");
        txtCaleder.append(calendar.get(Calendar.YEAR) + "\n");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        txtCaleder.append(simpleDateFormat.format(calendar.getTime()) + "\n");
    }
}
