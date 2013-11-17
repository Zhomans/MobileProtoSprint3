package com.sprint3.otters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by amclaughlin on 11/14/13.
 */
public class MakeTask extends Activity{

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        Bundle extras = getIntent().getExtras();
        final String size;
        if (extras != null) {
            size = extras.getString("size");
        } else {
            size = "small";
        }

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText descript = (EditText) findViewById(R.id.description);
        final SeekBar prior = (SeekBar) findViewById(R.id.priority);
        final CheckBox reoccur = (CheckBox) findViewById(R.id.checkBox);

        db = new DBHandler(this);
        db.open();

        //Button, when you click it, saves all the stuff in the textviews.


        Button b = (Button) findViewById(R.id.save); // creates a button b and attaching it to the UI element called button1 on the view
        b.setOnClickListener(new View.OnClickListener() { // creates and sets an onClickListener for the button b
            @Override
            public void onClick(View view) { // creates the onClick method for the listener, which controls what is done when the button is clicked
                String myName = name.getText().toString();
                String myDescript = descript.getText().toString();
                int reoccuring = reoccur.isChecked()? 1 : 0;

                int priority = prior.getProgress();
                Date date = new Date();

                Task task = new Task(myName, myDescript,size,priority,reoccuring,date.toString());
                task.setId("");
                db.addTask(task);

                Toast.makeText(getApplicationContext(), "The fumes make it happen", Toast.LENGTH_SHORT).show();
//                ArrayList<Task> tasks = db.getTasksBySize("small");

                Intent i = new Intent(getApplicationContext(), MainActivity.class); // creates a new intent i, which is how Android passes information between activities, and defines this intent as a way to navigate to the SecondActivity
                startActivity(i); // tells Android to make the intent active
            }
        });
    }
}
