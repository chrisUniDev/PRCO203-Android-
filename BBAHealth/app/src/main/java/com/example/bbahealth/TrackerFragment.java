package com.example.bbahealth;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TabHost;

public class TrackerFragment extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tracker, container, false);


        TabHost tabHost = (TabHost) view.findViewById(R.id.TabHostStages);
        ImageButton trackerButton = (ImageButton) view.findViewById(R.id.trackerInfoOpenButton);
        tabHost.setup();


        // Stage/tab 1
        TabHost.TabSpec spec = tabHost.newTabSpec("Tab One");
        spec.setContent(R.id.Stage_1);
        spec.setIndicator("1");
        tabHost.addTab(spec);

        // Stage/tab 2
        spec = tabHost.newTabSpec("Tab Two");
        spec.setContent(R.id.Stage_2);
        spec.setIndicator("2");
        tabHost.addTab(spec);

        // Stage/tab 3
        spec = tabHost.newTabSpec("Tab Three");
        spec.setContent(R.id.Stage_3);
        spec.setIndicator("3");
        tabHost.addTab(spec);

        // Stage/tab 4
        spec = tabHost.newTabSpec("Tab Four");
        spec.setContent(R.id.Stage_4);
        spec.setIndicator("4");
        tabHost.addTab(spec);

        // Stage/tab 5
        spec = tabHost.newTabSpec("Tab Five");
        spec.setContent(R.id.Stage_5);
        spec.setIndicator("5");
        tabHost.addTab(spec);

        // Stage/tab 6
        spec = tabHost.newTabSpec("Tab Six");
        spec.setContent(R.id.Stage_6);
        spec.setIndicator("6");
        tabHost.addTab(spec);

        // Stage/tab 7
        spec = tabHost.newTabSpec("Tab Seven");
        spec.setContent(R.id.Stage_7);
        spec.setIndicator("7");
        tabHost.addTab(spec);

        // Stage/tab 8
        spec = tabHost.newTabSpec("Tab Eight");
        spec.setContent(R.id.Stage_8);
        spec.setIndicator("8");
        tabHost.addTab(spec);

        trackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TrackerInfoOpen.class);
                startActivity(intent);
                //Toast.makeText(getActivity().getApplicationContext(), "Opening", Toast.LENGTH_LONG).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}

