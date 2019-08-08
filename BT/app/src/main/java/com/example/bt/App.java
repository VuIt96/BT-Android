package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


public class App extends AppCompatActivity {

    EditText ed_T1, ed_T2, ed_T3;
    TextView txt_View;
    Button bt_XN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        callID();
        bt_XN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = ed_T1.getText().toString();
                String email = ed_T2.getText().toString();
                String sdt = ed_T3.getText().toString();
                String xinchao = getResources().getString(R.string.txt_hello);
                String emails = getResources().getString(R.string.txt_Email);
                String sdts = getResources().getString(R.string.txt_numberphone);
                txt_View.setText(xinchao + ": " + hoten + "\n" + emails + ": " + email + "\n" + sdts + ": " + sdt);
            }
        });
    }

    private void callID() {
        ed_T1 = (EditText) findViewById(R.id.et_t1);
        ed_T2 = (EditText) findViewById(R.id.et_t2);
        ed_T3 = (EditText) findViewById(R.id.et_t3);
        bt_XN = (Button) findViewById(R.id.bt_app);
        txt_View = (TextView) findViewById(R.id.tv_view);

    }
}
