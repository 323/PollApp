package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class PollResults extends Activity {
	
	String pollname;
	int pollid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    pollname = extras.getString("pollname");
		    pollid = extras.getInt("pollid");
		}
		
		TextView PollName = (TextView)findViewById(R.id.PollName);
		PollName.setText(pollname);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}