package com.sprint3.otters;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wolflyra on 11/20/13.
 */
public class TaskDetailActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        Intent intent = getIntent();

        String fileName = intent.getStringExtra("file");
        TextView title = (TextView) findViewById(R.id.noteTitle);
        TextView noteText = (TextView) findViewById(R.id.noteText);

        final DatabaseModel DbHelper = new DatabaseModel(this);
        title.setText(fileName);

        SQLiteDatabase db = DbHelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM NOTES WHERE " + DatabaseModel.TASK_NAME + " LIKE "+ "'"+fileName +"';", null);
        Log.d("Lyra", "I made the cursor");
        List<String> listContents = new ArrayList<String>();
        List<String> listNames = new ArrayList<String>();

        c.moveToFirst();
        while (!c.isAfterLast()) {
            String itemContent = c.getString(
                    c.getColumnIndexOrThrow(DatabaseModel.TASK_DESCRIPTION));
            String itemName = c.getString(
                    c.getColumnIndexOrThrow(DatabaseModel.TASK_NAME)
            );
            listContents.add(itemContent);
            listNames.add(itemName);
            c.moveToNext();

        }
        // Make sure to close the cursor
        c.close();
        String listContent = listContents.get(0);
        String listName = listNames.get(0);


        Log.d("Lyra", listContent);
        Log.d("Lyra", listName);
        noteText.setText(listContent);



    }
}
