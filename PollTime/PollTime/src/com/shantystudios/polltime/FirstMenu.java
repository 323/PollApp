package com.shantystudios.polltime;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FirstMenu extends ListActivity {
String[] Options = {"Polls","Settings", "Options", "Future Updates"};
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String locationOfItem = Options[position];
		try {
			Class ourClass = Class.forName("com.shantystudios.polltime." + locationOfItem);
			Intent ourIntent = new Intent(FirstMenu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.label, Options));
	}

	
	

}
