package com.sprint3.otters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by amclaughlin on 11/14/13.
 */
public class MakeTask extends Activity{

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText descript = (EditText) findViewById(R.id.description);
        final SeekBar prior = (SeekBar) findViewById(R.id.priority);

        db = new DBHandler(this);
        db.open();

        //Button, when you click it, saves all the stuff in the textviews.


        Button b = (Button) findViewById(R.id.save); // creates a button b and attaching it to the UI element called button1 on the view
        b.setOnClickListener(new View.OnClickListener() { // creates and sets an onClickListener for the button b
            @Override
            public void onClick(View view) { // creates the onClick method for the listener, which controls what is done when the button is clicked
                String myName = name.getText().toString();
                String myDescript = descript.getText().toString();

                Task task = new Task(myName, myDescript,"small",93,1,"10/10/2010");
                int value = prior.getProgress();
                Toast.makeText(getApplicationContext(), String.valueOf(value), Toast.LENGTH_SHORT).show();

                db.addTask(task);

                Toast.makeText(getApplicationContext(), "The fumes make it happen", Toast.LENGTH_SHORT).show();
//                ArrayList<Task> tasks = db.getTasksBySize("small");

                Intent i = new Intent(getApplicationContext(), MainActivity.class); // creates a new intent i, which is how Android passes information between activities, and defines this intent as a way to navigate to the SecondActivity
                startActivity(i); // tells Android to make the intent active
            }
        });
    }
}
