package com.example.bt.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bt.R;

public class ProBars extends AppCompatActivity {
    Button BTproBar;
    ProgressBar probar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_bars);
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
                        Toast.makeText(ProBars.this, "Doadload xong", Toast.LENGTH_SHORT).show();

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
