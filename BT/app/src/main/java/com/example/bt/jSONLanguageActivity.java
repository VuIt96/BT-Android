package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class jSONLanguageActivity extends AppCompatActivity {
    ImageView imgEnglish, imgViewNam;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_sonlanguage);
        imgEnglish = (ImageView) findViewById(R.id.imgEnglish);
        imgViewNam = (ImageView) findViewById(R.id.imgVietNam);
        txtView = (TextView) findViewById(R.id.txtView);
        new ReadJson().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");
    }

    private class ReadJson extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(jSONLanguageActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
