package com.example.dexter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * PROVIDE LINK TO THE TUTORIAL WHICH WAS USED (youtube video about creating search activities)
 * 
 * @author Ivelin Bratanov, Francois-Xavier Lemire
 * 
 * SearchActivity is an Activity class which
 * updates the application's interface to 
 * display the data of a specific Pokemon
 * when a user searches for a Pokemon via
 * the search button. 
 */

public class SearchActivity extends Activity //Fragment
{
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		ImageButton searchButton = (ImageButton) findViewById(R.id.imageButton);
		searchButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View view) {				
				onSearchRequested();
			}
		});
		
		/*
		 * BUG FIXED:
		 * This is where the database was initially
		 * being created, and it would be recreated
		 * every time the user searched for a Pokemon.
		 * 
		 * The try block in the SplashScreen class was initially here.
		 */
		
		Intent intent = getIntent();
		if (Intent.ACTION_SEARCH.equals(intent.getAction()))
		{
			String query = intent.getStringExtra(SearchManager.QUERY);
			query = query.toLowerCase();

	        // Create and retrieve a Pokemon instance by querying the database.
			Pokemon pokemonFromBDD = PokemonBDD.getPokemonByName(query);
			
			/*
			 * If a Pokemon is returned, we Update the main activity so that
			 * it displays the data of the Pokemon searched by the user.
			 */
	        if (pokemonFromBDD != null) {
	        	
	        	/*
	        	 * Index which keeps track of which character of the
	        	 * "Damage Taken" data String is being accessed.
	        	 * This String contains numbers ranging from 0 to 4,
	        	 * separated by a space, in a specific order such
	        	 * that the first number corresponds to the damage
	        	 * taken from a Normal type attack, the second from
	        	 * a Fire type attack, and so on.
	        	 */
	        	int i = 0;
	        	String damage = ""; // Contains the damage for a specific type (ex: 0.5)
	        	char currentChar = pokemonFromBDD.getDmgTaken().charAt(i); // Retrieves the first character
	        	
	        	/*
	        	 * Setting text for Normal type.
	        	 */
	        	TextView index = (TextView) findViewById(R.id.textView3); // The TextView which we want to update.
	        	while (currentChar != ' ') { // (while we don't encounter a space)
	        		damage += currentChar; // Add the character to the damage String
	        		i++; // Increment index and read the next character.
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}
	        	index.setText("Normal x" + damage); // Update the TextView, changing the contained text.
	        	damage = ""; // Reset the damage String for the next type.
	        	i++; // Skip the space character.
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i); // Reads the next character.
	        	
	        	/*
	        	 * Setting text for Fire type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView4);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Fire x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Water type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView5);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Water x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Electric type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView6);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Electr x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Grass type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView8);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Grass x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Ice type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView7);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Ice x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Fight type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView9);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Fight x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Poison type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView10);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Poisn x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Ground type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView11);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Ground x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Flying type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView12);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Flying x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Psychic type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView13);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Psych x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Bug type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView14);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Bug x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Rock type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView15);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Rock x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Ghost type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView16);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Ghost x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Dragon type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView17);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Dragon x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Dark type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView18);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Dark x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Steel type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView19);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Steel x" + damage);
	        	damage = "";
	        	i++;
	        	currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	
	        	/*
	        	 * Setting text for Fairy type.
	        	 */
	        	index = (TextView) findViewById(R.id.textView20);
	        	while (currentChar != ' ') {
	        		damage += currentChar;
	        		i++;
	        		currentChar = pokemonFromBDD.getDmgTaken().charAt(i);
	        	}	        	
	        	index.setText("Fairy x" + damage);
	        	
	        	/*
	        	 * BUG FIXED:
	        	 * We were initially calling setContentView(R.layout.activity_main)
	        	 * here which was causing any changes made to the layout to be
	        	 * overwritten by the layout described in the activity_main XML file.
	        	 */
	        	
	        	index = (TextView) findViewById(R.id.name_and_number);
	        	String name = pokemonFromBDD.getName();
	        	name = name.substring(0, 1).toUpperCase() + name.substring(1);
	        	String number = pokemonFromBDD.getPID();
	        	index.setText(name + " - " + number);
	        	
	        	// Update the UI with the new pokemon's type
	        	index = (TextView) findViewById(R.id.type01);
	        	String type = pokemonFromBDD.getType1();
	        	index.setBackgroundColor(getColorValue(type));
	        	type = type.substring(0, 1).toUpperCase() + type.substring(1);
	        	index.setText(type);
	        	index = (TextView) findViewById(R.id.type02);
	        	type = pokemonFromBDD.getType2();
	        	index.setBackgroundColor(getColorValue(type));
	        	if (type.length() > 0) {
	        		type = type.substring(0, 1).toUpperCase() + type.substring(1);
	        	}
	        	index.setText(type);

	        	
	            WebView webview = (WebView) findViewById(R.id.webview);
	            //webview.loadUrl("file:///android_asset/xy-gifs/" + "pokemon.html");//+ query +".png"); //.gif?
	     	    	     	    
	     	    String htmlpage = "<html><body style=\"background:#000000\"><div style=\"height:150px; width:150px; background:#000000 url(\'file:///android_asset/xy-gifs/" + query + ".png" + "\') no-repeat center center;\"></div></body></html>";

	     	    // Below doesn't work.
	     	    // webview.loadData(htmlpage, "text/html", "UTF-8");
	     	    webview.loadDataWithBaseURL("", htmlpage, "text/html","utf-8", "");  	     	    
	     	    
	     	    // Only hides the scroll bar, doesn't disable the scrolling:
	     	    webview.setVerticalScrollBarEnabled(false);
	     	    webview.setHorizontalScrollBarEnabled(false);

	     	    // Actually disable the horizontal and vertical scrolling:
	     	    webview.setOnTouchListener(new View.OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
	     	    		return (event.getAction() == MotionEvent.ACTION_MOVE);
					}
	     	    });
	     	    
	     	    Toast.makeText(SearchActivity.this, pokemonFromBDD.toString(), Toast.LENGTH_LONG).show();
	        }
	        // Else inform the user that the query does not correspond to a Pokemon in the Database, via a Toast.
	        else {
	            Toast.makeText(this, "This Pokemon does not exist in the database.", Toast.LENGTH_LONG).show();
	        }
		}
	}
	
	public int getColorValue(String color) 
	{
		Resources colors = getResources();
		if (color.equals("")) {
			return colors.getColor(R.color.background);
		} else if (color.equals("normal")) {
			return colors.getColor(R.color.normal);
		} else if (color.equals("fire")) {
			return colors.getColor(R.color.fire);
		} else if (color.equals("water")) {
			return colors.getColor(R.color.water);
		} else if (color.equals("electric")) {
			return colors.getColor(R.color.electric);
		} else if (color.equals("grass")) {
			return colors.getColor(R.color.grass);
		} else if (color.equals("ice")) {
			return colors.getColor(R.color.ice);
		} else if (color.equals("fight")) {
			return colors.getColor(R.color.fight);
		} else if (color.equals("poison")) {
			return colors.getColor(R.color.poison);
		} else if (color.equals("ground")) {
			return colors.getColor(R.color.ground);
		} else if (color.equals("flying")) {
			return colors.getColor(R.color.flying);
		} else if (color.equals("psychic")) {
			return colors.getColor(R.color.psychic);
		} else if (color.equals("bug")) {
			return colors.getColor(R.color.bug);
		} else if (color.equals("rock")) {
			return colors.getColor(R.color.rock);
		} else if (color.equals("ghost")) {
			return colors.getColor(R.color.ghost);
		} else if (color.equals("dragon")) {
			return colors.getColor(R.color.dragon);
		} else if (color.equals("dark")) {
			return colors.getColor(R.color.dark);
		} else if (color.equals("steel")) {
			return colors.getColor(R.color.steel);
		} else if (color.equals("fairy")) {
			return colors.getColor(R.color.fairy);
		} else {
			return colors.getColor(R.color.background);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
