package com.example.exercise;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Progressbars extends AppCompatActivity {
    Button BTproBar;
    ProgressBar probar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbars);
        callID();
        BTproBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(10000, 500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int a = probar.getProgress();
                        if (a > probar.getMax()) {
                            a = 0;
                        }
                        probar.setProgress(a + 10);
                    }

                    @Override
                    public void onFinish() {
                        //chạy tiếp.
                        //this.start();
                        Toast.makeText(Progressbars.this, "Doadload xong", Toast.LENGTH_SHORT).show();

                    }
                };
                countDownTimer.start();
            }
        });
    }

    private void callID() {
        BTproBar = (Button) findViewById(R.id.bt_proBar);
        probar = (ProgressBar) findViewById(R.id.progressBar);
    }
}
