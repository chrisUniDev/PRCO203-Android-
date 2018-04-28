package com.example.bbahealth;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Record {

    private String outputFileName;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;

    public static final int RequestPermissionCode = 1;

    public void StartRecording(){
        outputFileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AudioRecording.3gp";

        MediaRecorderReady();

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void StopRecording(){
        mediaRecorder.stop();
    }

    public void PlayRecording(){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(outputFileName);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PauseRecording(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            MediaRecorderReady();
        }
    }

    public void MediaRecorderReady(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(outputFileName);
    }

//    public String CreateRandomAudioFileName(int string){
//        StringBuilder stringBuilder = new StringBuilder( string );
//        int i = 0 ;
//        while(i < string ) {
//            stringBuilder.append(RandomAudioFileName.charAt(random.nextInt(RandomAudioFileName.length())));
//
//            i++ ;
//        }
//        return stringBuilder.toString();
//    }

//    private void requestPermission() {
//        ActivityCompat.requestPermissions(getActivity(), new String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case RequestPermissionCode:
//                if (grantResults.length> 0) {
//                    boolean StoragePermission = grantResults[0] ==
//                            PackageManager.PERMISSION_GRANTED;
//                    boolean RecordPermission = grantResults[1] ==
//                            PackageManager.PERMISSION_GRANTED;
//
//                    if (StoragePermission && RecordPermission) {
//                        Toast.makeText(getActivity(), "Permission Granted",
//                                Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(getActivity(),"Permission Denied",Toast.LENGTH_LONG).show();
//                    }
//                }
//                break;
//        }
//    }
//
//    public boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(getActivity.getApplicationContext(), WRITE_EXTERNAL_STORAGE);
//        int result1 = ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), RECORD_AUDIO);
//        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
//    }
}