package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HappyActivity extends AppCompatActivity {
    RelativeLayout rlHappy;
    MediaPlayer songHappy;
    ImageView imgHappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);
        //anh xa
        rlHappy = (RelativeLayout) findViewById(R.id.rlHappy);
        imgHappy = (ImageView) findViewById(R.id.imgHappy);
        //mau nen
        rlHappy.setBackgroundResource(R.drawable.tt1);
        //nhac
        songHappy = MediaPlayer.create(getApplicationContext(), R.raw.trungthu8);
        songHappy.start();
        //
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        animation.reset();
        imgHappy.clearColorFilter();
        imgHappy.startAnimation(animation);
        //
        imgHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songHappy.stop();
                Intent intent = new Intent(HappyActivity.this, MusicActivity.class);
                startActivity(intent);
            }
        });
    }
}
