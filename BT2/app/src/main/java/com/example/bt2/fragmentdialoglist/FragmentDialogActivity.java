package com.example.bt2.fragmentdialoglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bt2.R;

public class FragmentDialogActivity extends AppCompatActivity implements DialogDeleteData {
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

    @Override
    public void deleteValue(boolean delete) {
        if (delete) {
            Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No", Toast.LENGTH_SHORT).show();
        }
    }
}
