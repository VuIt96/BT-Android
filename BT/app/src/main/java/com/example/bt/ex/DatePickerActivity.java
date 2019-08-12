package com.example.bt.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.bt.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {
    EditText etDataPic, etDataPic2;
    Button btCount;
    TextView txtHienthi, txtChonGio;
    Calendar calendar, calendar2, calendar3;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        AnhXa();
        etDataPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChonNgay();
            }
        });
        etDataPic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay2();
            }
        });
        btCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tinh = (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / (1000 * 60 * 60 * 24));

                if (tinh < 0) {
                    Toast.makeText(DatePickerActivity.this, "Vui long nhap lai ngay", Toast.LENGTH_LONG).show();
                } else {

                    txtHienthi.setText("So ngay xa nhau: " + tinh + " ngay");
                }
            }
        });
        txtChonGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonGio();
            }
        });
    }

    private void AnhXa() {
        etDataPic = (EditText) findViewById(R.id.etDataPicker1);
        etDataPic2 = (EditText) findViewById(R.id.etDataPicker2);
        btCount = (Button) findViewById(R.id.btCount);
        txtHienthi = (TextView) findViewById(R.id.txtHienthi);
        txtChonGio = (TextView) findViewById(R.id.txtChongio);
    }

    private void ChonNgay() {
        calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //gan de lay tgian chon
                calendar.set(i, i1, i2);
                simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                etDataPic.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }

    private void ChonNgay2() {
        calendar2 = Calendar.getInstance();
        int ngay = calendar2.get(Calendar.DATE);
        int thang = calendar2.get(Calendar.MONTH);
        int nam = calendar2.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //gan de lay tgian chon
                calendar2.set(i, i1, i2);
                simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                etDataPic2.setText(simpleDateFormat.format(calendar2.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }

    private void ChonGio() {
        calendar3 = Calendar.getInstance();
        int gio = calendar3.get(Calendar.HOUR_OF_DAY);
        int phut = calendar3.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar3.set(0, 0, 0, i, i1);
                txtChonGio.setText(simpleDateFormat.format(calendar3.getTime()));
            }
        }, gio, phut, true);
        timePickerDialog.show();
    }
}
