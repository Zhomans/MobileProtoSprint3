package com.sprint3.otters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        ViewGroup root;
        tasks = ((ViewPagerActivity) getActivity()).getTasks();

        if (tasks.size() > 0) {
            root = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, null);
            final Task task = tasks.get(position);
            ((TextView) root.findViewById(R.id.TaskTitle)).setText(
                    task.name);
            ((TextView) root.findViewById(R.id.TaskDescription)).setText(
                    task.description);
            ((TextView) root.findViewById(R.id.TaskDate)).setText(
                    "Date Added: " + task.date);

            final DBHandler db = new DBHandler(this.getActivity());
            db.open();

            Button accept = (Button) root.findViewById(R.id.acceptButton);
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (task.reoccuring == 0){
                        db.deleteTaskById(task.id);
                        Toast.makeText(getActivity(), "Accepted non-recurring task: " + task.name, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Accepted recurring task: " + task.name, Toast.LENGTH_SHORT).show();
                    }

                    Intent i = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                    startActivity(i);
                };
            });



        }

        else { root = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_empty_page, null); }

        return root;
    }

}
