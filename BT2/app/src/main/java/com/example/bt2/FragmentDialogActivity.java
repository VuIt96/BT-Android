package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentDialogActivity extends AppCompatActivity {
    Button btDeleteDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dialog);
        btDeleteDialog = (Button) findViewById(R.id.btDeleteDialog);
        btDeleteDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentDialog fragmentDialog = new FragmentDialog();
                fragmentDialog.show(getFragmentManager(), "dialog");
            }
        });
    }
}
