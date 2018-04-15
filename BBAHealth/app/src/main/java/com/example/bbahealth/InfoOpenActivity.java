package com.example.bbahealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoOpenActivity extends AppCompatActivity {

    ImageButton closeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_open);

        setTitle("Information Open");

        closeButton = (ImageButton) findViewById(R.id.imageButtonClose);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

                //Toast.makeText(getApplicationContext(), "Closing", Toast.LENGTH_LONG).show();
            }
        });
    }
}
