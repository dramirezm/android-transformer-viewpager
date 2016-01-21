package com.beltranfebrer.transformerviewpagerapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by miquel on 18.01.16.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 3;
    private int leftColor;
    private int rightColor;
    private int currentColor;

    public ScreenSlidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ScreenSlidePagerFragment.newInstance(leftColor);
            case 1:
                return ScreenSlidePagerFragment.newInstance(currentColor);
            case 2:
                return ScreenSlidePagerFragment.newInstance(rightColor);
            default:
                return ScreenSlidePagerFragment.newInstance(currentColor);
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }


    public void setColorSet(int currentColor, int leftColor, int rightColor) {

        this.currentColor = currentColor;
        this.leftColor = leftColor;
        this.rightColor = rightColor;
    }
}
