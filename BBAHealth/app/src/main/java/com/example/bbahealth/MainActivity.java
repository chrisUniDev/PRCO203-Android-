package com.example.bbahealth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Information");
                    InfoFragment infoFragment = new InfoFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fragmentScreen, infoFragment, "FragName");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_maps:
                    setTitle("Maps");
                    MapsFragment mapsFragment = new MapsFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragmentScreen, mapsFragment, "FragName");
                    fragmentTransaction2.commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentScreen, new MapsFragment()).commit();
                    return true;
                case R.id.navigation_record:
                    setTitle("Record");
                    RecordFragment recordFragment = new RecordFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fragmentScreen, recordFragment, "FragName");
                    fragmentTransaction3.commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentScreen, new RecordFragment()).commit();

                    NewRecordingFragment newRecordingFragment = new NewRecordingFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.recordFragmentScreen, newRecordingFragment, "FragName");
                    fragmentTransaction.commit();

                    temp = false;
                    return true;
                case R.id.navigation_tracker:
                    setTitle("Tracker");
                    TrackerFragment trackerFragment = new TrackerFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.fragmentScreen, trackerFragment, "FragName");
                    fragmentTransaction4.commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentScreen, new TrackerFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InfoFragment infoFragment = new InfoFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentScreen, infoFragment, "FragName");
        fragmentTransaction.commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        NavBarHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_LONG).show();
            }
        });
    }

    boolean temp = false;

    public void changeView(View view){
        if(!temp){
            changeViewOld();
            temp = true;
        }else{
            changeViewNew();
            temp = false;
        }
    }

    public void changeViewOld(){
        setTitle("Old Recordings");
        OldRecordingFragment oldRecordingFragment = new OldRecordingFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.recordFragmentScreen, oldRecordingFragment, "FragName");
        fragmentTransaction.commit();
    }

    public void changeViewNew(){
        setTitle("Record");
        NewRecordingFragment newRecordingFragment = new NewRecordingFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.recordFragmentScreen, newRecordingFragment, "FragName");
        fragmentTransaction.commit();
    }

    public void record(View view){
        
    }
}
