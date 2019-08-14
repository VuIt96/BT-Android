package com.example.bt.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bt.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImageActivity extends AppCompatActivity {
    Button btLoadImg;
    ImageView imgLoadImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);
        btLoadImg = (Button) findViewById(R.id.btLoadImage);
        imgLoadImg = (ImageView) findViewById(R.id.imgLoadImg);
        btLoadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadImage().execute("http://blog.ripplesadvisory.com/wp-content/uploads/2018/03/android-app-icon.png");
            }
        });
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmapPhoto = null;

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmapPhoto = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmapPhoto;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgLoadImg.setImageBitmap(bitmap);
        }
    }
}
