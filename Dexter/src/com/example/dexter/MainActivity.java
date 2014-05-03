package com.example.dexter;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * 
 * @author Ivelin Bratanov
 * 
 * The Main Activity class which displays
 * all the data related to the currently
 * searched Pokemon.
 *
 */

public class MainActivity extends Activity //FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        WebView view = (WebView) findViewById(R.id.webview);
        view.loadUrl("file:///android_asset/xy-gifs/pikachu.png"); //.gif?
		
		ImageButton searchButton = (ImageButton) findViewById(R.id.imageButton);
		searchButton.setOnClickListener(new View.OnClickListener() 
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
