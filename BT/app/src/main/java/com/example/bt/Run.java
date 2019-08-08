package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Run extends AppCompatActivity {
    TextView txtScores;
    RadioButton cbOne;
    RadioButton cbTwo;
    RadioButton cbthree;
    SeekBar sbOne;
    SeekBar sbTwo;
    SeekBar sbThree;
    ImageButton BTplay;
    int SoDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);
        callID();
        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThree.setEnabled(false);
        txtScores.setText(SoDiem + "");
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int Two = random.nextInt(number);
                int Three = random.nextInt(number);
                if (sbOne.getProgress() >= sbOne.getMax()) {
                    this.cancel();
                    BTplay.setVisibility(View.VISIBLE);
                    if (cbOne.isChecked()) {
                        SoDiem += 10;
                        Toast.makeText(Run.this, "WIN!", Toast.LENGTH_SHORT).show();
                    } else {
                        SoDiem -= 5;
                        Toast.makeText(Run.this, "LOSS!", Toast.LENGTH_SHORT).show();
                    }
                    txtScores.setText(SoDiem + "");
                    EnabaleCheckBox();
                }
                if (sbTwo.getProgress() >= sbTwo.getMax()) {
                    this.cancel();
                    BTplay.setVisibility(View.VISIBLE);
                    if (cbTwo.isChecked()) {
                        SoDiem += 10;
                        Toast.makeText(Run.this, "WIN!", Toast.LENGTH_SHORT).show();
                    } else {
                        SoDiem -= 5;
                        Toast.makeText(Run.this, "LOSS!", Toast.LENGTH_SHORT).show();
                    }
                    txtScores.setText(SoDiem + "");
                    EnabaleCheckBox();
                }
                if (sbThree.getProgress() >= sbThree.getMax()) {
                    this.cancel();
                    BTplay.setVisibility(View.VISIBLE);
                    if (cbthree.isChecked()) {
                        SoDiem += 10;
                        Toast.makeText(Run.this, "WIN!", Toast.LENGTH_SHORT).show();
                    } else {
                        SoDiem -= 5;
                        Toast.makeText(Run.this, "LOSS!", Toast.LENGTH_SHORT).show();
                    }
                    txtScores.setText(SoDiem + "");
                    EnabaleCheckBox();
                }
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
                if (cbOne.isChecked() || cbTwo.isChecked() || cbthree.isChecked()) {
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThree.setProgress(0);
                    BTplay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisabaleCheckBox();
                } else {
                    Toast.makeText(Run.this, "Vui lòng dự đoán đg đua!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbTwo.setChecked(false);
                    cbthree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbOne.setChecked(false);
                    cbthree.setChecked(false);
                }
            }
        });
        cbthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });

    }

    private void EnabaleCheckBox() {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbthree.setEnabled(true);
    }

    private void DisabaleCheckBox() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbthree.setEnabled(false);
    }

    private void callID() {
        txtScores = (TextView) findViewById(R.id.txtDiem);
        cbOne = (RadioButton) findViewById(R.id.cb1);
        cbTwo = (RadioButton) findViewById(R.id.cb2);
        cbthree = (RadioButton) findViewById(R.id.cb3);
        sbOne = (SeekBar) findViewById(R.id.sb1);
        sbTwo = (SeekBar) findViewById(R.id.sb2);
        sbThree = (SeekBar) findViewById(R.id.sb3);
        BTplay = (ImageButton) findViewById(R.id.bt_play);

    }
}
