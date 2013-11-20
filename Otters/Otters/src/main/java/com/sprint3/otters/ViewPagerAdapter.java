package com.sprint3.otters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by zach on 11/20/13.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context _context;
    private int NUM_PAGES;

    public ViewPagerAdapter(Context context, FragmentManager fm, int NUM_PAGES) {
        super(fm);
        _context=context;
        this.NUM_PAGES=(NUM_PAGES==0) ? 1 : NUM_PAGES;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();
        f= new ViewPagerFragment(position);
        return f;
    }
    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}