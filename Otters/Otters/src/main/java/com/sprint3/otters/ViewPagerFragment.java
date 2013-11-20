package com.sprint3.otters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zach on 11/20/13.
 */

public class ViewPagerFragment extends Fragment {

    public ArrayList<Task> tasks;
    public int position;

    public ViewPagerFragment(int position){
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, null);
        tasks = ((ViewPagerActivity) getActivity()).getTasks();

        if (tasks.size() > 0) {
        ((TextView) root.findViewById(R.id.TaskTitle)).setText(
                tasks.get(position).name);
        } else {
            ((TextView) root.findViewById(R.id.TaskTitle)).setText("Error: Nothing in DB of this size.");
        }

        return root;
    }

}
