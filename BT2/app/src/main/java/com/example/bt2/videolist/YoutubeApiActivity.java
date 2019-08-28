package com.example.bt2.videolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bt2.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeApiActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    String API_KEY = "AIzaSyAWnm9jj-3RfUNswYw3KggQKhw6lKdq_kA";
    YouTubePlayerView ytPlayerApi;
    int REQUEST_VIDEO = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_api);
        ytPlayerApi = (YouTubePlayerView) findViewById(R.id.ytPlayerApi);
        ytPlayerApi.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo("966pA87ED4s");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(YoutubeApiActivity.this, REQUEST_VIDEO);

        } else {
            Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO) {
            ytPlayerApi.initialize(API_KEY, YoutubeApiActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
