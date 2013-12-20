package com.example.dexter;

//import info.androidhive.androidsplashscreennetwork.R;
//import info.androidhive.network.JsonParser;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
 
public class SplashScreen extends Activity {
 
    String now_playing, earned;
	InputStream in;
	BufferedReader reader;
	String line;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
 
        /**
         * Showing splashscreen while making network calls to download necessary
         * data before launching the app Will use AsyncTask to make http call
         */
        new PrefetchData().execute();
 
    }
 
    /**
     * Async Task to make http call
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
             * Will make http call here This call will download required data
             * before launching the app 
             * example: 
             * 1. Downloading and storing in SQLite 
             * 2. Downloading images 
             * 3. Fetching and parsing the xml / json 
             * 4. Sending device information to server 
             * 5. etc.,
             */
        	
        	//This is where we run any splash screen background stuff
        	//We'll eventually move this code to the DatabaseHelper class and simply create
        	//a helper.
        	
        	//DatabaseHelper dbHelper = DatabaseHelper.getHelper(getApplicationContext());*******************
        	
        	try {
        	in = getApplicationContext().getAssets().open("pokemon_database.txt");
			reader = new BufferedReader(new InputStreamReader(in));
			line = reader.readLine();
		
	        //Create a Pokemon instance
	        PokemonBDD pokemonBDD = new PokemonBDD(getApplicationContext());
	        
	        //open database to write
	        pokemonBDD.open();
	        
	        int i=0;
	        while ((line = reader.readLine()) != null) {
		        //Create a pokemon
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
		

		        //insert pokemon in
		        pokemonBDD.insertPokemon(pokemon);
//		        i++;
		        line = reader.readLine();
//		        Toast.makeText(this, i, Toast.LENGTH_SHORT).show();
		        
//	        	dbHelper.onCreate(pokemonBDD);
	        }
        	}
        	catch(IOException e) {
        		
        	}

        	return null;
        }
 
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // After completing http call
            // will close this activity and lauch main activity
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            i.putExtra("now_playing", now_playing);
            i.putExtra("earned", earned);
            startActivity(i);
 
            // close this activity
            finish();
        }
 
    }
 
}