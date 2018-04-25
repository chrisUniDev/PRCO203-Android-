package com.example.bbahealth;

import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class NewRecordingFragment extends Fragment {

    View view;
    ImageButton imageRecordButton;
    boolean recording = false;
    String audioFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AudioRecordingTest.3gp";
    private static MediaRecorder mediaRecorder;

    public NewRecordingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new_recording, container, false);

        view = inflater.inflate(R.layout.fragment_new_recording, container, false);

        // get the reference of Button
        imageRecordButton = (ImageButton) view.findViewById(R.id.imageViewRecordButton);

        imageRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!recording){
                    imageRecordButton.setBackgroundResource(R.drawable.ic_stop_recording_button);
                    //

                    //
                    recording = true;
                }else{
                    imageRecordButton.setBackgroundResource(R.drawable.ic_record_button);
                    //

                    //
                    recording = false;
                }

                //Toast.makeText(getActivity().getApplicationContext(), "Testing", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
