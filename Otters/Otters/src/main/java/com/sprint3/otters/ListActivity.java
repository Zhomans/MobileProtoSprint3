package com.sprint3.otters;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by wolflyra on 11/20/13.
 */
public class ListActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final TextView title = (TextView) findViewById(R.id.typeTextView);
        title.setText("Type of Task");

        this.deleteDatabase("OttersDB");
        final DatabaseModel DbHelper = new DatabaseModel(this);


        List<String> files = new ArrayList<String>(Arrays.asList(fileList()));

        final TaskListAdapter aa = new TaskListAdapter(this, android.R.layout.simple_list_item_1, files);

        final ListView tasks = (ListView) findViewById(R.id.taskList);

        tasks.setAdapter(aa);


        tasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final TextView title = (TextView) view.findViewById(R.id.titleTextView);
                String fileName = title.getText().toString();
                Intent in = new Intent(getApplicationContext(), TaskDetailActivity.class);
                in.putExtra("file", fileName);
                startActivity(in);
            }
        });
    }
}