package com.example.bbahealth;

import android.content.pm.PackageManager;
import android.media.Image;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class NewRecordingFragment extends Fragment {

    View view;
    ImageButton imageRecordButton;
    String AudioSavePathInDevice = null;
    MediaRecorder mediaRecorder;
    public static final int RequestPermissionCode = 1;
    boolean recording = false;

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
                    //RecordAudio();
                    recording = true;
                }else{
                    imageRecordButton.setBackgroundResource(R.drawable.ic_record_button);
                    //StopRecordingAudio();
                    recording = false;
                }

                Toast.makeText(getActivity().getApplicationContext(), "Testing", Toast.LENGTH_LONG).show();
            }

            private void StopRecordingAudio() {

                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;

                //Toast.makeText(getActivity().getApplicationContext(), "Stopped Recording", Toast.LENGTH_LONG).show();
            }

            private void RecordAudio(){
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


                //Toast.makeText(getActivity().getApplicationContext(), "Started Recording", Toast.LENGTH_LONG).show();
                //} else {
                //requestPermission();
                //}
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
