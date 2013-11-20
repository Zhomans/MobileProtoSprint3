package com.sprint3.otters;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import java.util.ArrayList;

/**
 * Created by zach on 11/20/13.
 */


public class ViewPagerActivity extends FragmentActivity {
    private ViewPager _mViewPager;
    private ViewPagerAdapter _adapter;
    public ArrayList<Task> tasks;
    private static int NUM_PAGES;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        final String size;
        if (extras != null) {
            size = extras.getString("size");
        } else {
            size = "small";
        }

        DBHandler db = new DBHandler(this);
        db.open();
        tasks = db.getTasksBySize(size);
        final int NUM_PAGES = tasks.size();

        setContentView(R.layout.activity_screen_slide);
        _mViewPager = (ViewPager) findViewById(R.id.viewPager);
        _adapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager(), NUM_PAGES);
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(0);
        setTab();
    }

    private void setTab(){
        _mViewPager.setOnPageChangeListener(new OnPageChangeListener(){

            @Override
            public void onPageScrollStateChanged(int position) {}
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageSelected(int position) {}

        });

    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }


}