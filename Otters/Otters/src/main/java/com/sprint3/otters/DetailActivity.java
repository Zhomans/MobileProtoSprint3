package com.sprint3.otters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by wolflyra on 11/13/13.
 */
public class DetailActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("previousName");
        final String contents = intent.getStringExtra("previousContents");

        TextView title = (TextView) findViewById(R.id.detailViewName);
        TextView noteText = (TextView) findViewById(R.id.detailViewInfo);

        title.setText(name);
        noteText.setText(contents);

        final ImageButton previous = (ImageButton) findViewById(R.id.leftOtter);
        ImageButton next = (ImageButton) findViewById(R.id.rightOtter);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go back to the last thing you looked at
                Intent in = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(in);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the next (random) thing in the database
                Intent in = new Intent(getApplicationContext(), DetailActivity.class);
                in.putExtra("previousName", name);
                in.putExtra("previousContents", contents);
                //things to put into the intent: the thing that the person is currently
                //viewing for the next previous button
                startActivity(in);
            }
        });
    }
}