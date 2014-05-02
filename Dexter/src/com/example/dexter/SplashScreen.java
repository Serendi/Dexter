package com.example.dexter;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

/**
 * PROVIDE LINK TO THE TUTORIAL WHICH WAS USED
 * @author Ivelin Bratanov
 * 
 * The SplashScreen class is an Activity which displays
 * a loading screen while the database used in the
 * application gets loaded from the database file.
 *
 */
public class SplashScreen extends Activity {
 
    String now_playing, earned;
	
    /**
     * The InputStream through which we access the DB (text file).
     */
    InputStream in;
    
    /**
     * The BufferedReader instance which reads data from the DB
     * (via the InputStream) in a character-wise manner.
     */
	BufferedReader reader;
	
    /**
     * The line of the DB text file which is currently being accessed.
     */
	String line;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        WebView view = (WebView) findViewById(R.id.webview);
//        view.loadUrl("file:///android_asset/splash-screen/splash.html");
 
        /** 
         * Displays the splash screen while the data is loaded from
         * the DB. AsyncTask is used to access the DB.
         */
        new PrefetchData().execute();
 
    }
 
    /**
     * Async Task to make http call *******************************?
     */
    private class PrefetchData extends AsyncTask<Void, Void, Void> {
 
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // before making http calls
        }
 
        @Override
        protected Void doInBackground(Void... arg0) {
            /*
             * This is where we run background activities/methods while
             * the splash screen is being displayed.
             */

        	//We'll eventually move this code to the DatabaseHelper class and simply create
        	//a helper. ((Should we move this to MyBaseSQLite?))
        	//DatabaseHelper dbHelper = DatabaseHelper.getHelper(getApplicationContext());*******************
        	
        	try {
        		
        		/*
        		 * First we retrieve the application context, then we get an asset manager
        		 * object which allows us to access all the files in the assets folder
        		 * contained in our current package.
        		 * Then we open the asset (the DB text file contained in the assets folder)
        		 * and instantiate the InputStream by associating it with this file. 
        		 */
	        	in = getApplicationContext().getAssets().open("pokemon_database.txt");
				
	        	// Instantiate the reader using the InputStream we created above.
	        	reader = new BufferedReader(new InputStreamReader(in));
				
	        	// Skips over the empty line at the start of the DB text file.
	        	line = reader.readLine();
			
		        // Create a Pokemon DB instance given the current application context.
		        PokemonBDD pokemonBDD = new PokemonBDD(getApplicationContext());
		        
		        // Open the database to write.
		        pokemonBDD.open();
		        
		        /*
		         * This while loop is where we take all of the data stored in the
		         * database file (pokemon_database.txt) and store it into a database
		         * object which can be accessed and used by the application.
		         * 
		         * We loop through each line of the database text file, create a
		         * Pokemon object with the data, and insert that Pokemon instance
		         * into the database object.
		         */
		        while ((line = reader.readLine()) != null) {
			        // Create a Pokemon instance.
			        Pokemon pokemon = new Pokemon(
			        		//pID
			        		line,
			        		//name
			        		line = reader.readLine(),
			        		//imgSrc
			        		line = reader.readLine(),
			        		//type1
			        		line = reader.readLine(),
			        		//type2
			        		line = reader.readLine(),
			        		//locX
			        		line = reader.readLine(),
			        		//locY
			   				line = reader.readLine(),
			        		//dmg_taken
			   				line = reader.readLine(),
			        		//own
			   				line = reader.readLine(),
			        		//favorite
			   				line = reader.readLine());
	
			        // Insert Pokemon in the database object.
			        pokemonBDD.insertPokemon(pokemon);
			        
			        // Skips over the empty line between each set of data.
			        line = reader.readLine();
		        }
        	}
        	catch(IOException e) {
        		/*
        		 * @TODO: Make a toast indicating that the DB could
        		 * not be accessed.
        		 */
        	}

        	return null;
        }
 
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            
            /*
             * After the DB has been loaded, this
             * activity is closed and the main
             * activity is launched.
             */
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            i.putExtra("now_playing", now_playing); //************************************* useless, but this is how extra data is sent accross activities
            i.putExtra("earned", earned);
            startActivity(i);
 
            // Close this activity.
            finish();
        }
 
    }
 
}