package com.example.dexter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PokemonBDD {
    private static final int VERSION_BDD = 1;
    private static final String NAME_BDD = "pokemon.db";

    private static final String TABLE_POKEMON = "table_pokemon";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_PID = "PID";
    private static final int NUM_COL_PID = 1;
    private static final String COL_NAME = "Name";
    private static final int NUM_COL_NAME = 2;
    private static final String COL_IMG_SRC = "ImgSrc";
    private static final int NUM_COL_IMG_SRC = 3;
    private static final String COL_TYPE1 = "Type1";
    private static final int NUM_COL_TYPE1 = 4;
    private static final String COL_TYPE2 = "Type2";
    private static final int NUM_COL_TYPE2 = 5;
    private static final String COL_LOCX = "LocationX";
    private static final int NUM_COL_LOCX = 6;
    private static final String COL_LOCY = "LocationY";
    private static final int NUM_COL_LOCY = 7;
    private static final String COL_DMG_TAKEN = "DamageTaken";
    private static final int NUM_COL_DMG_TAKEN = 8;
    private static final String COL_OWN = "Owned";
    private static final int NUM_COL_OWN = 9;
    private static final String COL_FAVORITE = "Favorite";
    private static final int NUM_COL_FAVORITE = 10;

    private static SQLiteDatabase bdd;

    private MyBaseSQLite myBaseSQLite;

    public PokemonBDD(Context context) {
        //create BDD and table
        myBaseSQLite = new MyBaseSQLite(context, NAME_BDD, null, VERSION_BDD);
    }
    
    public void open() {
    	//open BDD to write
    	bdd = myBaseSQLite.getWritableDatabase();
    }

    public void close() {
        //close access to BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public long insertPokemon(Pokemon pokemon) {
        //create ContentValues (works like HashMap)
        ContentValues values = new ContentValues();
        //add value associated to a key (which is the column number)
        values.put(COL_PID, pokemon.getPID());
        values.put(COL_NAME, pokemon.getName());
        values.put(COL_IMG_SRC, pokemon.getImgSrc());
        values.put(COL_TYPE1, pokemon.getType1());
        values.put(COL_TYPE2, pokemon.getType2());
        values.put(COL_LOCX, pokemon.getLocX());
        values.put(COL_LOCY, pokemon.getLocY());
        values.put(COL_DMG_TAKEN, pokemon.getDmgTaken());
        values.put(COL_OWN, pokemon.getOwn());
        values.put(COL_FAVORITE, pokemon.getFavorite());
        //insert object in BDD via ContentValues
        return bdd.insert(TABLE_POKEMON, null, values);
    }

    public int updatePokemon(int id, Pokemon pokemon) {
        //update is like insert
        ContentValues values = new ContentValues();

        values.put(COL_PID, pokemon.getPID());
        values.put(COL_NAME, pokemon.getName());
        values.put(COL_IMG_SRC, pokemon.getImgSrc());
        values.put(COL_TYPE1, pokemon.getType1());
        values.put(COL_TYPE2, pokemon.getType2());
        values.put(COL_LOCX, pokemon.getLocX());
        values.put(COL_LOCY, pokemon.getLocY());
        values.put(COL_DMG_TAKEN, pokemon.getDmgTaken());
        values.put(COL_OWN, pokemon.getOwn());
        values.put(COL_FAVORITE, pokemon.getFavorite());       

        return bdd.update(TABLE_POKEMON, values, COL_ID + " = " + id, null);
    }

    public int removePokemonWithID(int id) {
        //Delete pokemon of BDD with ID
        return bdd.delete(TABLE_POKEMON, COL_ID + " = " + id, null);
    }

    public static Pokemon getPokemonByName(String name) {
        //get back in a Cursor the values corresponding to the pokemon contained in the BDD
        Cursor c =  bdd.query(TABLE_POKEMON,
                new String[] {COL_ID, COL_PID, COL_NAME, COL_IMG_SRC, COL_TYPE1, COL_TYPE2, COL_LOCX, COL_LOCY, COL_DMG_TAKEN, COL_OWN, COL_FAVORITE},
                COL_NAME + " LIKE \"" + name + "\"", null, null, null, null);
        return cursorToPokemon(c);
    }

    /* Convert a cursor in a pokemon */
    private static Pokemon cursorToPokemon(Cursor c) {
        //if no element has been returned in request, return null
        if (c.getCount() == 0) return null;

        //else move to first element
        c.moveToFirst();
        //Create the pokemon
        Pokemon pokemon = new Pokemon();
        //set all infos that we get from the cursor
        pokemon.setId(c.getInt(NUM_COL_ID));
        pokemon.setPID(c.getString(NUM_COL_PID));
        pokemon.setName(c.getString(NUM_COL_NAME));
        pokemon.setImgSrc(c.getString(NUM_COL_IMG_SRC));
        pokemon.setType1(c.getString(NUM_COL_TYPE1));
        pokemon.setType2(c.getString(NUM_COL_TYPE2));
        pokemon.setLocX(c.getString(NUM_COL_LOCX));
        pokemon.setLocY(c.getString(NUM_COL_LOCY));
        pokemon.setDmgTaken(c.getString(NUM_COL_DMG_TAKEN));
        pokemon.setOwn(c.getString(NUM_COL_OWN));
        pokemon.setFavorite(c.getString(NUM_COL_FAVORITE));
        //close cursor
        c.close();

        return pokemon;
    }
}
