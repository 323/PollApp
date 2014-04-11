package com.shantystudios.polltime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	int yes = 0; // Record vote counts for yes, may not be needed after database is up and running
	int no = 0; // Record vote counts for no, may not be needed after database is up and running
	int voted = 0; // If they've voted in this poll or not
	String pollname = "Do you like this app?"; // The poll name, will later be populated by database
	int pollid = 1; // The poll ID, will later be populated by database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(plusOneYes); // Register the OnClick listener with the "Yes" button
        
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(plusOneNo); // Register the OnClick listener with the "No" button
        
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(viewResults); // Register the OnClick listener with the "View Results" button
    }

    private OnClickListener plusOneYes = new OnClickListener() {
    	public void onClick(View v) {
    		if (voted == 1) {
    			// People see this toast if they've already voted in this poll
    			Toast.makeText(MainActivity.this, "Error: You've already voted.", Toast.LENGTH_LONG).show();
    		} else  if (voted == 0) {
    			yes++; // Add one yes vote to the current voting, will later be synced with DB
    			voted = 1; // Record that they've voted for this poll
    			Toast.makeText(MainActivity.this, "You Voted Yes.", Toast.LENGTH_SHORT).show();
    		} 
    	}
    };
    
    private OnClickListener plusOneNo = new OnClickListener() {
    	public void onClick(View v) {
    		if (voted == 1) {
    			// People see this toast if they've already voted in this poll
    			Toast.makeText(MainActivity.this, "Error: You've already voted.", Toast.LENGTH_LONG).show();
    		} else if (voted == 0) {
    			no++; // Add one no vote to the current voting, will later by synced with DB
    			voted = 1; // Record that they've voted for this poll
        		Toast.makeText(MainActivity.this, "You Voted No.", Toast.LENGTH_SHORT).show();
    		} else {
    			// People will only see this toast if voted doesn't equal true or false, which would be an error
        		Toast.makeText(MainActivity.this, "Error: Something went wrong. Contact us.", Toast.LENGTH_LONG).show();
    		}
    	}
    };
    
    private OnClickListener viewResults = new OnClickListener() {
    	public void onClick(View v) {
    		// Warn the user that my terrible coding is ahead
    		Toast.makeText(MainActivity.this, "This button may or may not work.", Toast.LENGTH_LONG).show();
    		// Switch the poll results activity
    		Intent i = new Intent(getApplicationContext(), PollResults.class);
    		// Pass the name of the current poll to the poll results activity
    		i.putExtra("pollname", pollname);
    		i.putExtra("pollid", pollid);
            startActivity(i);
    	}
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
