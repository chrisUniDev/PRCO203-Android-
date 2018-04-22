package com.example.bbahealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class InfoOpenActivity extends AppCompatActivity {

    int i = InfoFragment.getOpenTab();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_open);

        ImageView openImage = findViewById(R.id.imageOpen);

        if(i == 0){
            setTitle("Treatment Plan Information");
            openImage.setImageResource(R.drawable.ic_card_image_four);
        } else if(i == 1){
            setTitle("Side Effects of Radiotherapy");
            openImage.setImageResource(R.drawable.ic_card_image_eight);
        } else if(i == 2){
            setTitle("How Radiotherapy Works");
            openImage.setImageResource(R.drawable.ic_card_image_six);
        } else if(i == 3){
            setTitle("Finances");
            openImage.setImageResource(R.drawable.ic_card_image_five);
        }
    }
}
