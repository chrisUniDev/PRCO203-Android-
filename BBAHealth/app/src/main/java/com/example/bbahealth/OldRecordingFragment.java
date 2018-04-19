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
    String AudioSavePathInDevice = null;

    public OldRecordingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_old_recording, container, false);

//        playButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) throws IllegalArgumentException,
//                    SecurityException, IllegalStateException {
//
//                stopButton.setEnabled(true);
//
//                mediaPlayer = new MediaPlayer();
//                try {
//                    mediaPlayer.setDataSource(AudioSavePathInDevice);
//                    mediaPlayer.prepare();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                mediaPlayer.start();
//
//                Toast.makeText(getActivity().getApplicationContext(), "Playing Recording" ,Toast.LENGTH_LONG).show();
//            }
//        });
//
//        stopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stopButton.setEnabled(false);
//                playButton.setEnabled(true);
//
//                if(mediaPlayer != null){
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                }
//
//                Toast.makeText(getActivity().getApplicationContext(), "Paused Recording" ,Toast.LENGTH_LONG).show();
//            }
//        });


        return view;

    }
}
