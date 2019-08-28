package com.example.bt2.videolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bt2.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideoListActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerView ytVideoList;
    String id = "";
    int REQUEST_VIDEO = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video_list);
        ytVideoList = (YouTubePlayerView) findViewById(R.id.ytVideoList);
        Intent intent = getIntent();
        id = intent.getStringExtra("idVideoList");
        ytVideoList.initialize(YoutubeListActivity.API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadPlaylist(id);
        youTubePlayer.setFullscreen(true);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(PlayVideoListActivity.this, REQUEST_VIDEO);
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO) {
            ytVideoList.initialize(YoutubeListActivity.API_KEY, PlayVideoListActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
