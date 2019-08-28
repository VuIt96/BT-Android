package com.example.bt2.appmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.bt2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MediaAppActivity extends AppCompatActivity {
    TextView txtNameSong, txtTimeMin, txtTimeMax;
    SeekBar sbPlay;
    ImageButton iconNext, iconStop, iconPlay, iconPrevious;
    ArrayList<SongActivity> arrayList;
    int Temp = 0;
    MediaPlayer mediaPlayer;
    ImageView imgView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_app);
        initEvent();
        addSong();
        initStart();
        setListener();
    }

    private void setListener() {
        iconPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    iconPlay.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                } else {
                    mediaPlayer.start();
                    iconPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                }
                setTimeMax();
                updateTimeMin();
                imgView.startAnimation(animation);
            }
        });
        iconStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                iconPlay.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                initStart();
            }
        });
        iconNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Temp++;
                if (Temp > arrayList.size() - 1) {
                    Temp = 0;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                initStart();
                mediaPlayer.start();
                iconPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                setTimeMax();
                updateTimeMin();
            }
        });
        iconPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Temp--;
                if (Temp < 0) {
                    Temp = 0;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                initStart();
                mediaPlayer.start();
                iconPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                setTimeMax();
                updateTimeMin();
            }
        });
        sbPlay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(sbPlay.getProgress());
            }
        });
    }

    private void addSong() {
        arrayList = new ArrayList<>();

        arrayList.add(new SongActivity("Do ta khong do nang", R.raw.do_ta_khong_do_nang));
        arrayList.add(new SongActivity("Anh dang o dau the", R.raw.anhdangodau));
        arrayList.add(new SongActivity("Dung thoi diem", R.raw.dung_thoi_diem));
        arrayList.add(new SongActivity("Van dam dau", R.raw.van_dam_dau));
        arrayList.add(new SongActivity("Song gio", R.raw.song_gio));
    }

    private void initEvent() {
        txtNameSong = (TextView) findViewById(R.id.txtName);
        txtTimeMax = (TextView) findViewById(R.id.txtTimeMax);
        txtTimeMin = (TextView) findViewById(R.id.txtTimeMin);
        sbPlay = (SeekBar) findViewById(R.id.sbPlay);
        iconNext = (ImageButton) findViewById(R.id.iconNext);
        iconStop = (ImageButton) findViewById(R.id.iconStop);
        iconPlay = (ImageButton) findViewById(R.id.iconPlay);
        iconPrevious = (ImageButton) findViewById(R.id.iconPrevious);
        imgView = (ImageView) findViewById(R.id.imgView);

    }

    private void initStart() {
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_icon_img);
        mediaPlayer = MediaPlayer.create(MediaAppActivity.this, arrayList.get(Temp).getFile());
        txtNameSong.setText(arrayList.get(Temp).getTitle());
    }

    private void setTimeMax() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:SS");
        txtTimeMax.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        sbPlay.setMax(mediaPlayer.getDuration());
    }

    private void updateTimeMin() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                txtTimeMin.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                //update seekbar
                sbPlay.setProgress(mediaPlayer.getCurrentPosition());
                //Test bai hat
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mPlayer) {
                        Temp++;
                        if (Temp > arrayList.size() - 1) {
                            Temp = 0;
                        }
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                        }
                        initStart();
                        mediaPlayer.start();
                        iconPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                        setTimeMax();
                        updateTimeMin();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }
}

