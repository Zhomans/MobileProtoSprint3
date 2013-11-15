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
public class TitleFeedListAdapter extends ArrayAdapter<TitleFeedItem> {

    private final Context context;
    private final List<TitleFeedItem> data;

    public TitleFeedListAdapter(Context context, List<TitleFeedItem> data){
        super(context, R.layout.smb_item, data);
        this.context = context;
        this.data = data;
    }

    private class FeedItemHolder{
        TextView userName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        FeedItemHolder holder;
        View feedRow = convertView;

        if(feedRow == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            feedRow = inflater.inflate(R.layout.smb_item, parent, false);
            holder = new FeedItemHolder();
            holder.userName = (TextView) feedRow.findViewById(R.id.category);

            feedRow.setTag(holder);
        } else {
            holder = (FeedItemHolder) feedRow.getTag();
        }

        TitleFeedItem item = data.get(position);

        holder.userName.setText(item.userName);

        return feedRow;
    }

}

