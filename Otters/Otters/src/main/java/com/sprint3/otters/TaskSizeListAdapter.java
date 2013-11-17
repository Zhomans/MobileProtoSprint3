package com.sprint3.otters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by evan on 9/25/13.
 */
public class TaskSizeListAdapter extends ArrayAdapter<TaskSizeItem> {

    private final Context context;
    private final List<TaskSizeItem> data;

    public TaskSizeListAdapter(Context context, List<TaskSizeItem> data){
        super(context, R.layout.smb_item, data);
        this.context = context;
        this.data = data;
    }

    private class FeedItemHolder{
        TextView name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        FeedItemHolder holder;
        View feedRow = convertView;

        if(feedRow == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            feedRow = inflater.inflate(R.layout.smb_item, parent, false);
            holder = new FeedItemHolder();
            holder.name = (TextView) feedRow.findViewById(R.id.category);

            feedRow.setTag(holder);
        } else {
            holder = (FeedItemHolder) feedRow.getTag();
        }

        TaskSizeItem item = data.get(position);

        holder.name.setText(item.name);

        return feedRow;
    }

}

