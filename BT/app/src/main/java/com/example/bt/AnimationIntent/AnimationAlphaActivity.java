package com.example.bt.AnimationIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bt.R;

public class AnimationAlphaActivity extends AppCompatActivity {
    ImageView imgAlpha, imgRotate, imgScale, imgTranslate;
    Button btAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_alpha);
        imgAlpha = (ImageView) findViewById(R.id.imgAlpha);
        imgRotate = (ImageView) findViewById(R.id.imgRotate);
        imgScale = (ImageView) findViewById(R.id.imgScale);
        imgTranslate = (ImageView) findViewById(R.id.imgTranslate);
        btAnimation = (Button) findViewById(R.id.btAnimation);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        final Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        imgAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation);

            }
        });
        imgRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation2);

            }
        });
        imgScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation3);

            }
        });
        imgTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation4);

            }
        });
        btAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimationAlphaActivity.this, AnimationIntentActivity.class));
                overridePendingTransition(R.anim.amin_enter, R.anim.anim_exit);
            }
        });
    }
}
