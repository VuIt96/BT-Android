package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {
    TextView txtMusicHappy;
    ListView lvMusicHappy;
    MediaPlayer songMusic;
    ArrayList<String> nameMusic, noteMusic;
    ArrayList<Integer> mp3Music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        txtMusicHappy = (TextView) findViewById(R.id.txtMusicHappy);
        lvMusicHappy = (ListView) findViewById(R.id.lvMusicHappy);
        songMusic = MediaPlayer.create(getApplicationContext(), R.raw.trungthu8);
        songMusic.start();
        txtMusicHappy.setText("Happy Mid-Autumn Festival");
        getAnimation();
        getData();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, nameMusic);
        lvMusicHappy.setAdapter(adapter);
        lvMusicHappy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                songMusic.stop();
                songMusic = MediaPlayer.create(getApplicationContext(), mp3Music.get(i));
                songMusic.start();

                txtMusicHappy.setText(noteMusic.get(i));
                getAnimation();
            }
        });
        txtMusicHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songMusic.stop();
                Intent intent;
                startActivity(new Intent(getApplicationContext(), HappyActivity.class));
            }
        });
    }

    public void getAnimation() {
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        zoom.reset();
        txtMusicHappy.clearAnimation();
        txtMusicHappy.startAnimation(zoom);
    }

    private void getData() {
        nameMusic = new ArrayList<String>();
        noteMusic = new ArrayList<String>();
        mp3Music = new ArrayList<Integer>();

        mp3Music.add(R.raw.cdosao);
        nameMusic.add("Ông sao trung thu");
        noteMusic.add("Ông sao trung thu");

        mp3Music.add(R.raw.cotich);
        nameMusic.add("Cổ tích");
        noteMusic.add("Cổ tích");

        mp3Music.add(R.raw.ongsao);
        nameMusic.add("Ông sao ");
        noteMusic.add("Ông sao ");

        mp3Music.add(R.raw.thangcuoi);
        nameMusic.add("Chú cuội ");
        noteMusic.add("Chú cuội");

        mp3Music.add(R.raw.van_dam_dau);
        nameMusic.add("Vạn dặm đau ");
        noteMusic.add("Vạn dặm  ");

    }

}
