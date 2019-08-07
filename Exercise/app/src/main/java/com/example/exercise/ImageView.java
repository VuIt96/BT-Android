package com.example.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImageView extends AppCompatActivity {
    EditText edit_text;
    Button btND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        callid();
        btND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageView.this, edit_text.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callid() {
        edit_text = (EditText) findViewById(R.id.exittext);
        btND = (Button) findViewById(R.id.bt_noidung);

    }
}
