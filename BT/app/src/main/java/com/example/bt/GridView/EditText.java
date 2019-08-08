package com.example.bt.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bt.R;

public class EditText extends AppCompatActivity {
    android.widget.EditText edit_text;
    Button btND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        callid();
        btND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditText.this, edit_text.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callid() {
        edit_text = (android.widget.EditText) findViewById(R.id.exittext);
        btND = (Button) findViewById(R.id.bt_noidung);

    }
}
