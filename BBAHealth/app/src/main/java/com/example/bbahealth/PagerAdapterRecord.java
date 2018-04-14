package com.example.bbahealth;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import junit.framework.Test;

public class PagerAdapterRecord extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterRecord(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new NewRecordingFragment();
            case 1:
                return new OldRecordingFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
