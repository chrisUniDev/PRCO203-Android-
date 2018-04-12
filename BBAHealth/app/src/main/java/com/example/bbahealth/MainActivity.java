package com.example.bbahealth;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    InfoFragment infoFragment = new InfoFragment();
    MapsFragment mapsFragment = new MapsFragment();
    RecordFragment recordFragment = new RecordFragment();
    TrackerFragment trackerFragment = new TrackerFragment();
    SupportFragment supportFragment = new SupportFragment();
    OldRecordingFragment oldRecordingFragment = new OldRecordingFragment();
    NewRecordingFragment newRecordingFragment = new NewRecordingFragment();
    InfoOpenFragment infoOpenFragment = new InfoOpenFragment();

    public boolean infoViewOpen = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("BBA Health");
                    android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fragmentScreen, infoFragment, "FragName");
                    fragmentTransaction1.commit();
                    infoViewOpen = true;
                    return true;
                case R.id.navigation_maps:
                    setTitle("Maps");
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragmentScreen, mapsFragment, "FragName");
                    fragmentTransaction2.commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentScreen, new MapsFragment()).commit();
                    infoViewOpen = false;
                    return true;
                case R.id.navigation_record:
                    setTitle("Record");
                    android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fragmentScreen, recordFragment, "FragName");
                    fragmentTransaction3.commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentScreen, new RecordFragment()).commit();

                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.recordFragmentScreen, newRecordingFragment, "FragName");
                    fragmentTransaction.commit();

                    temp = false;
                    infoViewOpen = false;
                    return true;
                case R.id.navigation_tracker:
                    setTitle("Tracker");
                    android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.fragmentScreen, trackerFragment, "FragName");
                    fragmentTransaction4.commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentScreen, new TrackerFragment()).commit();
                    infoViewOpen = false;
                    return true;
                case R.id.navigation_support:
                    setTitle("Support");
                    android.support.v4.app.FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction5.replace(R.id.fragmentScreen, supportFragment, "FragName");
                    fragmentTransaction5.commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentScreen, new SupportFragment()).commit();
                    infoViewOpen = false;
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
        infoViewOpen = true;

        BottomNavigationView navigation = findViewById(R.id.navigation);
        NavBarHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        GridView gridView = findViewById(R.id.gridViewCards);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (infoViewOpen) {
                    openInfoView();
                    Toast.makeText(MainActivity.this, "Card: " + i, Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });

        //ImageButton exit= (ImageButton) findViewById(R.id.imageButtonClose);
        //exit.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //       MainActivity.this.finish();
        //    }
        //});
    }

    public void openInfoView() {
        setTitle("Test");
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentScreen, infoOpenFragment, "FragName");
        fragmentTransaction.commit();
    }

    //Recording Area

    boolean temp = false;

    public void changeView(View view) {
        if (!temp) {
            changeViewOld();
            temp = true;
        } else {
            changeViewNew();
            temp = false;
        }
    }

    public void changeViewOld() {
        setTitle("Old Recordings");
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.recordFragmentScreen, oldRecordingFragment, "FragName");
        fragmentTransaction.commit();
    }

    public void changeViewNew() {
        setTitle("Record");
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.recordFragmentScreen, newRecordingFragment, "FragName");
        fragmentTransaction.commit();
    }

    protected boolean hasMicrophone() {
        PackageManager packageManager = this.getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }
}
