package com.sprint3.otters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by amclaughlin on 11/14/13.
 */
public class MakeTask extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        Button b = (Button) findViewById(R.id.save); // creates a button b and attaching it to the UI element called button1 on the view
        b.setOnClickListener(new View.OnClickListener() { // creates and sets an onClickListener for the button b
            @Override
            public void onClick(View view) { // creates the onClick method for the listener, which controls what is done when the button is clicked
                Intent i = new Intent(getApplicationContext(), MainActivity.class); // creates a new intent i, which is how Android passes information between activities, and defines this intent as a way to navigate to the SecondActivity
                startActivity(i); // tells Android to make the intent active
            }
        });
    }
}
