package com.example.bbahealth;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class OldRecordingFragment extends Fragment {

    View view;

    ArrayList<String> recordingList = new ArrayList<String>();
    MediaPlayer mediaPlayer;

    public OldRecordingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_old_recording, container, false);

        final ListView listView = view.findViewById(R.id.listViewPreviousRecordings);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, recordingList);

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String fileName = "/Android/data/com.example.bbahealth/files/audio_recording_" + position + ".mp4";

                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(fileName);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();
                Toast.makeText(getActivity(), "Recording Playing" + position,Toast.LENGTH_LONG).show();
            }
        });


//
//        mediaPlayer.start();

//        playButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) throws IllegalArgumentException,
//                    SecurityException, IllegalStateException {
//
//
//                //Toast.makeText(getActivity().getApplicationContext(), "Playing Recording" ,Toast.LENGTH_LONG).show();
//            }
//        });
//
//        stopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                //Toast.makeText(getActivity().getApplicationContext(), "Paused Recording" ,Toast.LENGTH_LONG).show();
//            }
//        });

        return view;
    }
}
