package com.sprint3.otters;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wolflyra on 11/20/13.
 */
public class TaskListAdapter extends ArrayAdapter{

    private ArrayList<Task> tasks;
    private Activity activity;

    public TaskListAdapter(Activity a, int viewResourceId, ArrayList<Task> tasks){
        super(a, viewResourceId, tasks);
        this.tasks = tasks;
        this.activity = a;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View v = convertView;
        if (v==null){
            LayoutInflater vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.task_list_item, null);
        }
        TextView taskName = (TextView) v.findViewById(R.id.taskName);
        taskName.setText(tasks.get(position).name);

        return v;
    }
}
