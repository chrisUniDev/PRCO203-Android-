package com.example.bbahealth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OldRecordingFragment extends Fragment {

    View view;

    String[] recordingList = {
            "Recording One",
            "Mask Explanation",
            "Recording Three"
    };

    public OldRecordingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_old_recording, container, false);

//        Button playButton = view.findViewById(R.id.buttonPlay);
//        Button stopButton = view.findViewById(R.id.buttonStop);
        ListView listView = view.findViewById(R.id.listViewPreviousRecordings);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, recordingList);

        listView.setAdapter(listViewAdapter);



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
