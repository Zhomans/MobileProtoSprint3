package com.sprint3.otters;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by zach on 11/20/13.
 */


public class ViewPagerActivity extends FragmentActivity {
    private ViewPager _mViewPager;
    private ViewPagerAdapter _adapter;
    public ArrayList<Task> tasks;
    private static int NUM_PAGES;
    public String size;
    public int startPage;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            size = extras.getString("size");
            startPage = extras.getInt("start");
        } else {
            size = "small";
            startPage = 0;
        }

        DBHandler db = new DBHandler(this);
        db.open();
        tasks = db.getTasksBySize(size);
        final int NUM_PAGES = tasks.size();

        setContentView(R.layout.activity_screen_slide);
        _mViewPager = (ViewPager) findViewById(R.id.viewPager);
        _adapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager(), NUM_PAGES);
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(startPage);
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

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_screen_slide, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
                NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
                return true;
            case R.id.action_list:
                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                i.putExtra("size", size);
                startActivityForResult(i, 1);
            case R.id.action_random:

                DBHandler db = new DBHandler(this);
                db.open();
                int MAX = db.getTasksBySize(size).size();
                int currentPage = _mViewPager.getCurrentItem();
                int randomInt = (int)(Math.random() * MAX);
                while (randomInt == currentPage){
                    randomInt = (int)(Math.random() * MAX);
                }
                _mViewPager.setCurrentItem(randomInt);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                int startPage = data.getExtras().getInt("start");
                _mViewPager.setCurrentItem(startPage);
            }
        }
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }


}