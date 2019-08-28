package com.example.bt2.media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.bt2.R;

public class MediaSoundActivity extends AppCompatActivity {
    Button btMediaPlay, btVideoPlay;
    VideoView vvVideoPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_sound);
        btMediaPlay = (Button) findViewById(R.id.btMediaPlay);
        btVideoPlay = (Button) findViewById(R.id.btVideoPlay);
        vvVideoPlay = (VideoView) findViewById(R.id.vvPlayVideo);
        btMediaPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MediaSoundActivity.this, R.raw.do_ta_khong_do_nang);
                mediaPlayer.start();
            }
        });
        btVideoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("https://khoapham.vn/download/vuoncaovietnam.mp4");
                vvVideoPlay.setVideoURI(url);
                MediaController mediaController = new MediaController(MediaSoundActivity.this);
                vvVideoPlay.setMediaController(mediaController);
                vvVideoPlay.start();
            }
        });
    }
}
