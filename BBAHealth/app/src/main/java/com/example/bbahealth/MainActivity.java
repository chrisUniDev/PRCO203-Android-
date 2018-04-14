package com.example.bbahealth;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    InfoFragment infoFragment = new InfoFragment();
    MapsFragment mapsFragment = new MapsFragment();
    RecordFragment recordFragment = new RecordFragment();
    TrackerFragment trackerFragment = new TrackerFragment();
    SupportFragment supportFragment = new SupportFragment();

    public boolean infoViewOpen = true;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("BBA Health");
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
                    setTitle("Tracker");
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        NavBarHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        GridView gridView = findViewById(R.id.gridViewCards);

        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics());
        gridView.setMinimumWidth(px);
        gridView.setMinimumHeight(10);

        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (infoViewOpen) {
                    openInfoView();
                    Toast.makeText(MainActivity.this, "Card: " + i, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openInfoView() {
        Intent intent = new Intent(this, InfoOpenActivity.class);
        startActivity(intent);
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
