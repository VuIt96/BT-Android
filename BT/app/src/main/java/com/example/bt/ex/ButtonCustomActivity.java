package com.example.bt.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bt.R;

public class ButtonCustomActivity extends AppCompatActivity {
    ImageView ivView;
    Button btAdd;
    Button btSub;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_custom);
        ivView = (ImageView) findViewById(R.id.imgview);
        btAdd = (Button) findViewById(R.id.bt);
        btSub = (Button) findViewById(R.id.bt_color);
        ivView.setImageLevel(1000);
        final ClipDrawable clipDrawable = (ClipDrawable) ivView.getDrawable();
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {
                    private int countRun;
                    private int runablecount = count;

                    @Override
                    public void run() {
                        int customlevel = clipDrawable.getLevel();
//                        if (customlevel >= 10000) {
//                            customlevel = 0;
//                        }
//                        ivView.setImageLevel(customlevel + 1000);
//                        handler.postDelayed(this, 500);
//                        Log.d("ButtonCustomActivity ", "r: " + count + " - Run: " + ++countRun);
//                        //de quy
                        if (customlevel < 10001) {
                            int temp = 3000/(count*2);
                            ivView.setImageLevel(customlevel + temp);
                            handler.postDelayed(this,500);
                            Log.d("ButtonCustomActivity ", "r: " + runablecount + " - Run: " + ++countRun + " custom: " + customlevel  + "temp : "+temp);
                        }

                    }
                };
                handler.postDelayed(runnable, 2000);
            }
        });
        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int coutlevelssub = clipDrawable.getLevel();
                if (coutlevelssub > 1000) {
                    ivView.setImageLevel(coutlevelssub - 1000);
                }

            }
        });
    }
}
