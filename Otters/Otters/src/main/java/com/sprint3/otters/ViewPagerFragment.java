package com.sprint3.otters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
            try{
                Date date = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(task.date);
                String formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
                ((TextView) root.findViewById(R.id.TaskDate)).setText(
                        "Date Added: " + formattedDate);
            } catch (ParseException e){
                Log.e("Parse Exception", e.toString());
            }


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

                    Activity activity = getActivity();
                    Intent i = new Intent(activity.getApplicationContext(), MainActivity.class);
                    activity.setResult(activity.RESULT_OK, i);
                    activity.finish();

            };
            });

            Button firstStep = (Button) root.findViewById(R.id.firstStep);
            firstStep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = "http://google.com/#q=" + tasks.get(position).name.replace(' ', '+');
                    Uri uriUrl = Uri.parse(url);
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);

                }

                ;
            });



        }

        else { root = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_empty_page, null); }

        return root;
    }



}
