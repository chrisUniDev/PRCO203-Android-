package com.example.bbahealth;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterMaps extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterMaps(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HospitalFragment();
            case 1:
                return new BeaconCenterFragment();
            case 2:
                return new TransportFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
