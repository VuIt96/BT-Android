package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataResultActivity extends AppCompatActivity {
    Button btEdit;
    TextView txtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_result);
        btEdit = (Button) findViewById(R.id.btDataResult);
        txtName = (TextView) findViewById(R.id.txtDataresult);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataResultActivity.this, IntentDataResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
