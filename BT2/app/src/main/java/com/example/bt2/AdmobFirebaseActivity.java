package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AdmobFirebaseActivity extends AppCompatActivity {
    AdView madView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob_firebase);
        //ca-app-pub-7424972876687532~9275182650
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
        madView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);
    }
}
