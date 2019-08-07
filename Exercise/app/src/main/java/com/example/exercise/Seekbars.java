package com.example.exercise;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.CheckBox;

import java.util.Random;

public class Seekbars extends AppCompatActivity {
    TextView txtScores;
    CheckBox cbOne;
    CheckBox cbTwo;
    CheckBox cbthree;
    SeekBar sbOne;
    SeekBar sbTwo;
    SeekBar sbThree;
    ImageButton BTplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbars);
        callID();
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int Two = random.nextInt(number);
                int Three = random.nextInt(number);
                sbOne.setProgress(sbOne.getProgress() + one);
                sbTwo.setProgress(sbTwo.getProgress() + Two);
                sbThree.setProgress(sbThree.getProgress() + Three);
            }

            @Override
            public void onFinish() {

            }
        };
        BTplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BTplay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });
    }

    private void callID() {
        txtScores = (TextView) findViewById(R.id.txtDiem);
        cbOne = (CheckBox) findViewById(R.id.cb1);
        cbTwo = (CheckBox) findViewById(R.id.cb2);
        cbthree = (CheckBox) findViewById(R.id.cb3);
        sbOne = (SeekBar) findViewById(R.id.sb1);
        sbTwo = (SeekBar) findViewById(R.id.sb2);
        sbThree = (SeekBar) findViewById(R.id.sb3);
        BTplay = (ImageButton) findViewById(R.id.bt_play);

    }
}
