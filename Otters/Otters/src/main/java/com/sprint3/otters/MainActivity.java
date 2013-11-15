package com.sprint3.otters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.taskmaker); // creates a button b and attaching it to the UI element called button1 on the view
        b.setOnClickListener(new View.OnClickListener() { // creates and sets an onClickListener for the button b
            @Override
            public void onClick(View view) { // creates the onClick method for the listener, which controls what is done when the button is clicked
                Intent i = new Intent(getApplicationContext(), MakeTask.class); // creates a new intent i, which is how Android passes information between activities, and defines this intent as a way to navigate to the SecondActivity
                startActivity(i); // tells Android to make the intent active
            }
        });
                 /*
                * Creating some sample test data to see what the layout looks like.
                * You should eventually delete this.
                */
        TitleFeedItem item1 = new TitleFeedItem("SMALL");
        TitleFeedItem item2 = new TitleFeedItem("MEDIUM");
        TitleFeedItem item3 = new TitleFeedItem("BIG");
        List<TitleFeedItem> sampleData = new ArrayList<TitleFeedItem>();
        sampleData.add(item1);
        sampleData.add(item2);
        sampleData.add(item3);

        // Set up the ArrayAdapter for the feedList
        TitleFeedListAdapter feedListAdapter = new TitleFeedListAdapter(this.getApplicationContext(), sampleData);
        ListView feedList = (ListView) findViewById(R.id.titles);
        feedList.setAdapter(feedListAdapter);
    }
}
    

