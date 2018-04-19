package com.example.bbahealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TrackerInfoOpen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker_info_open);

        setTitle("Tracker Information Open");

        ImageButton closeButton = (ImageButton) findViewById(R.id.imageButtonCloseTracker);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

                //Toast.makeText(getApplicationContext(), "Closing", Toast.LENGTH_LONG).show();
            }
        });
    }
}
