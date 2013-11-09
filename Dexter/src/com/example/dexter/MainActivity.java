package com.example.dexter;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageButton imgButton = (ImageButton) findViewById(R.id.imageButton);
		imgButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View view) {				
				onSearchRequested();
			}
		});
		
//		addButtonListener();
	}
	
//	public void doMySearch(String query) {
//		Toast.makeText(MainActivity.this,"ImageButton is working!", Toast.LENGTH_SHORT).show();
//	}
//	
//	public void addButtonListener() {
//
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	public void getInfo(){
		//This is where we interact with the database
		//SQLiteDatabase db = DBAdapter.sqlitedb;

		//Cursor c = db.rawQuery()...
	}

}
