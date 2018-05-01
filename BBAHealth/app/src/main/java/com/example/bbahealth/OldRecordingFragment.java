package com.example.bbahealth;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OldRecordingFragment extends Fragment {

    View view;

    ArrayList<String> recordingList = new ArrayList<String>();
    MediaPlayer mediaPlayer;

    Button stopButton;

    boolean playing = false;

    public OldRecordingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_old_recording, container, false);

        stopButton = view.findViewById(R.id.buttonStopPlaying);

        final ListView listView = view.findViewById(R.id.listViewPreviousRecordings);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, recordingList);

        listView.setAdapter(listViewAdapter);

        recordingList.add("Recording One");
        recordingList.add("Recording Two");
        recordingList.add("Recording Three");
        recordingList.add("Recording Four");
        recordingList.add("Recording Five");
        recordingList.add("Recording Six");
        recordingList.add("Recording Seven");
        recordingList.add("Recording Eight");
        recordingList.add("Recording Nine");
        recordingList.add("Recording Ten");
        recordingList.add("Recording Eleven");
        recordingList.add("Recording Twelve");
        recordingList.add("Recording Thirteen");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(!playing){
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.coffee_bear_ben);
                    mediaPlayer.start();
                    Toast.makeText(getActivity(), "Playing Recording: " + (position + 1),Toast.LENGTH_LONG).show();
                    playing = true;
                }

//                String fileName = "/Android/data/com.example.bbahealth/files/audio_recording_" + position + ".mp4";
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    playing = false;
                    Toast.makeText(getActivity(), "Playback Stopped",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
