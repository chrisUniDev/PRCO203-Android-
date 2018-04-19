package com.example.bbahealth;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class OldRecordingFragment extends Fragment {

    View view;
    MediaPlayer mediaPlayer;
    String AudioSavePathInDevice = "/AudioRecordings/Recording_1.3gp";

    public OldRecordingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_old_recording, container, false);

        Button playButton = (Button) view.findViewById(R.id.buttonPlay);
        Button stopButton = (Button) view.findViewById(R.id.buttonStop);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                Toast.makeText(getActivity().getApplicationContext(), "Playing Recording" ,Toast.LENGTH_LONG).show();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity().getApplicationContext(), "Paused Recording" ,Toast.LENGTH_LONG).show();
            }
        });


        return view;

    }
}
