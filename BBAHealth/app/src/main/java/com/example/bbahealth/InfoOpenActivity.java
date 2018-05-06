package com.example.bbahealth;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class InfoOpenActivity extends YouTubeBaseActivity {

    int i = InfoFragment.getOpenTab();

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_open);

        ImageView openImage = findViewById(R.id.imageOpen);

        if(i == 0){
            setTitle("Treatment Plan Information");
            openImage.setImageResource(R.drawable.ic_card_image_ten);
        } else if(i == 1){
            setTitle("Side Effects of Radiotherapy");
            openImage.setImageResource(R.drawable.ic_card_image_eight);
        } else if(i == 2){
            setTitle("How Radiotherapy Works");
            openImage.setImageResource(R.drawable.ic_card_image_eleven);
        } else if(i == 3){
            setTitle("Finances");
            openImage.setImageResource(R.drawable.ic_card_image_nine);
        }

        youTubePlayerView = findViewById(R.id.youtubePlayer);

        youTubePlayerView.initialize(YouTubeAPIFetch.getApiKey(), onInitializedListener);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("zoEYjt1dSsM");
                youTubePlayer.pause();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
    }
}
