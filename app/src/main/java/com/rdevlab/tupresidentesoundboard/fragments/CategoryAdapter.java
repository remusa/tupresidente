package com.rdevlab.tupresidentesoundboard.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.rdevlab.tupresidentesoundboard.MainActivity.adCounter;

/**
 *
 * @author rms
 * @date 25/02/2018
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        adCounter();
        switch (position) {
            case 0:
                return new AllPresidentsFragment();
            case 1:
                return new PenaFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Todos";
            case 1:
                return "Peña Nieto";
            default:
                return null;
        }
    }
}
