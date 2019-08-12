package com.example.bt.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bt.R;

public class ActionViewActivity extends AppCompatActivity {
    ImageView imgBrowser, imgInbox, imgCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_view);
        imgBrowser = (ImageView) findViewById(R.id.imgActionview);
        imgInbox = (ImageView) findViewById(R.id.imgActionsendto);
        imgCall = (ImageView) findViewById(R.id.imgActioncall);
        imgBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://khoapham.vn"));
                startActivity(intent);
            }
        });
        imgInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "xin chao ....");
                intent.setData(Uri.parse("sms:0327805806"));
                startActivity(intent);
            }
        });
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0327805806"));
                startActivity(intent);
            }
        });
    }
}
