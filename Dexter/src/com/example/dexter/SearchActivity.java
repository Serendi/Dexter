package com.example.dexter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SearchActivity extends Activity
{
	InputStream in;
	BufferedReader reader;
	String line;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//build file/database here if not done already
		
		super.onCreate(savedInstanceState);
		
		/* create database */
		try {
			in = this.getAssets().open("pokemon_database.txt");
			reader = new BufferedReader(new InputStreamReader(in));
			line = reader.readLine();
		
	        //Create a Pokemon instance
	        PokemonBDD pokemonBDD = new PokemonBDD(this);
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
		
		        //open database to write
		        pokemonBDD.open();
		        //insert pokemon in
		        pokemonBDD.insertPokemon(pokemon);
//		        i++;
		        line = reader.readLine();
//		        Toast.makeText(this, i, Toast.LENGTH_SHORT).show();
	        }
		
		
		Intent intent = getIntent();
		if (Intent.ACTION_SEARCH.equals(intent.getAction()))
		{
			String query = intent.getStringExtra(SearchManager.QUERY);
			// Search DB for query here
			/* to verify pokemon has been correctly created, extract the pokemon from BDD
	        with the name of pokemon that we just created */
	        Pokemon pokemonFromBDD = pokemonBDD.getPokemonByName(query);
			
	      //if a pokemon is returned:
	        if (pokemonFromBDD != null) {
	            // Update the main activity so that it has the data of the new pokemon searched by
	        	// the user.
	        	Toast.makeText(SearchActivity.this,pokemonFromBDD.toString(), Toast.LENGTH_LONG).show();
	        }
	      //else say it does not exist
	        else {
	            Toast.makeText(this, "This pokemon does not exist in the database", Toast.LENGTH_LONG).show();
	        }
//	        //extract pokemon from BDD with its new name
//	        pokemonFromBDD = pokemonBDD.getPokemonByName("Dummy Voltorb");
//	        //if pokemon exists
//	        if (pokemonFromBDD != null) {
//	        	//display new info to check pokemon has correctly been updated
//	        	Toast.makeText(this, pokemonFromBDD.toString(), Toast.LENGTH_LONG).show();
//	        	//delete the pokemon through its ID
//	        	pokemonBDD.removePokemonWithID(pokemonFromBDD.getID());
//	        }
	
	        //Try to re-extract the pokemon from the BDD with its new name
//	        pokemonFromBDD = pokemonBDD.getPokemonByName(pokemon.getName());
	        //If no pokemon is returned:
//	        if (pokemonFromBDD == null) {
//	            //Display a message indicating the pokemon doesn't exist in BDD
//	            Toast.makeText(this, "This pokemon does not exist inside the BDD", Toast.LENGTH_LONG).show();
//	        }
//	        //else if the pokemon exists (normally it shouldn't):
//	        else {
//	            //we display a message indicating the pokemon exists in BDD
//	            Toast.makeText(this, "This pokemon exists inside the BDD", Toast.LENGTH_LONG).show();
//	        }
	
	        pokemonBDD.close();
	        in.close();
	        
	        Intent toMain = new Intent(SearchActivity.this, MainActivity.class); 
	        startActivity(toMain);
		}
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
