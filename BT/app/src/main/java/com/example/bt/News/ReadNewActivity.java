package com.example.bt.News;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.bt.R;

public class ReadNewActivity extends AppCompatActivity {
    WebView wbReadNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_new);
        wbReadNew = (WebView) findViewById(R.id.wbReadNew);
        Intent intent = getIntent();
        String link = intent.getStringExtra("linkTinTuc");
        wbReadNew.loadUrl(link);
        wbReadNew.setWebChromeClient(new WebChromeClient());

    }
}
