package com.example.bbahealth;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class NewRecordingFragment extends Fragment {

    View view;
    Button recordButton, playButton, stopButton, stopRecordButton;
    String AudioSavePathInDevice = null;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    public static final int RequestPermissionCode = 1;

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
        recordButton = (Button) view.findViewById(R.id.buttonRecord);
        playButton = (Button) view.findViewById(R.id.buttonPlay);
        stopButton = (Button) view.findViewById(R.id.buttonStop);
        stopRecordButton = (Button) view.findViewById(R.id.buttonStopRecord);

        stopRecordButton.setEnabled(false);
        playButton.setEnabled(false);
        stopButton.setEnabled(false);

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if(checkPermission()) {

                AudioSavePathInDevice = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AudioRecordings/Recording" + 1 + ".3gp";

                MediaRecorderReady();

                try {
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Log.d("test","State Issue");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Log.d("test","IO Issue");
                }

                recordButton.setEnabled(false);
                stopRecordButton.setEnabled(true);

                Toast.makeText(getActivity().getApplicationContext(), "Started Recording", Toast.LENGTH_LONG).show();
                //} else {
                //requestPermission();
                //}

            }
        });

        stopRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;

                stopRecordButton.setEnabled(false);
                playButton.setEnabled(true);
                recordButton.setEnabled(true);
                stopButton.setEnabled(false);

                Toast.makeText(getActivity().getApplicationContext(), "Stopped Recording", Toast.LENGTH_LONG).show();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                stopRecordButton.setEnabled(false);
                recordButton.setEnabled(false);
                stopButton.setEnabled(true);

                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(AudioSavePathInDevice);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();

                Toast.makeText(getActivity().getApplicationContext(), "Playing Recording" ,Toast.LENGTH_LONG).show();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRecordButton.setEnabled(false);
                recordButton.setEnabled(true);
                stopButton.setEnabled(false);
                playButton.setEnabled(true);

                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    MediaRecorderReady();
                }


                Toast.makeText(getActivity().getApplicationContext(), "Paused Recording" ,Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public void MediaRecorderReady(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(AudioSavePathInDevice);
    }

    //public String CreateRandomAudioFileName(int string){
    //    StringBuilder stringBuilder = new StringBuilder( string );
    //    int i = 0 ;
    //    while(i < string ) {
    //        stringBuilder.append(RandomAudioFileName.
    //                charAt(random.nextInt(RandomAudioFileName.length())));

    //        i++ ;
    //    }
    //    return stringBuilder.toString();
    //}

    //private void requestPermission() {
    //    ActivityCompat.requestPermissions(getActivity(), new String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
    //}

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length> 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(getActivity().getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }
}
