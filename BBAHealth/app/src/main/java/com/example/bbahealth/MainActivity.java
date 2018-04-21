package com.example.bbahealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static boolean firstTime = false;
    public static boolean infoViewOpen = true;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Radiotherapy");
                    switchToFragmentInfo();
                    infoViewOpen = true;
                    return true;
                case R.id.navigation_maps:
                    setTitle("Maps");
                    switchToFragmentMaps();
                    infoViewOpen = false;
                    return true;
                case R.id.navigation_record:
                    setTitle("Record");
                    switchToFragmentRecord();
                    infoViewOpen = false;
                    return true;
                case R.id.navigation_tracker:
                    setTitle("Journey");
                    switchToFragmentTracker();
                    infoViewOpen = false;
                    return true;
                case R.id.navigation_support:
                    setTitle("Support");
                    switchToFragmentSupport();
                    infoViewOpen = false;
                    return true;
            }
            return false;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent (this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!firstTime){
            Intent intent = new Intent (this, InitialActivity.class);
            startActivity(intent);
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        NavBarHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void switchToFragmentInfo() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentScreen, new InfoFragment()).commit();
    }

    public void switchToFragmentMaps() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentScreen, new MapsFragment()).commit();
    }

    public void switchToFragmentRecord() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentScreen, new RecordFragment()).commit();
    }

    public void switchToFragmentTracker() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentScreen, new TrackerFragment()).commit();
    }

    public void switchToFragmentSupport() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentScreen, new SupportFragment()).commit();
    }
}
