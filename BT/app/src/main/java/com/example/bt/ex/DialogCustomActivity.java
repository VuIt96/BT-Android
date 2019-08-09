package com.example.bt.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bt.R;

public class DialogCustomActivity extends AppCompatActivity {
    TextView txtClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_custom);
        txtClick = (TextView) findViewById(R.id.tvclick);
        txtClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCustom();
            }
        });
    }

    private void DialogCustom() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        final EditText editTextUser = (EditText) dialog.findViewById(R.id.et_user);
        final EditText editTextPass = (EditText) dialog.findViewById(R.id.et_pass);
        Button btDnhap = (Button) dialog.findViewById(R.id.btDangNhap);
        Button btHuy = (Button) dialog.findViewById(R.id.btHuy);
        dialog.setCanceledOnTouchOutside(false);

        btDnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUser.getText().toString().trim();
                String Pass = editTextPass.getText().toString().trim();
                if (userName.equals("Vu") && Pass.equals("123")) {
                    Toast.makeText(DialogCustomActivity.this, "Dang nhap thanh cong!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DialogCustomActivity.this, "Dang nhap lai!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialog.cancel();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
