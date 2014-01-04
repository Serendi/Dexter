package com.example.dexter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * PROVIDE LINK TO THE TUTORIAL WHICH WAS USED
 * @author Francois-Xavier Lemire
 *
 * DexterSQLiteHelper class allows more efficient access
 * to the database.
 */
public class DexterSQLiteHelper extends SQLiteOpenHelper {
    private static final String TABLE_POKEMON = "table_pokemon";
    private static final String COL_ID = "ID";
    private static final String COL_PID = "PID";
    private static final String COL_NAME = "Name";
    private static final String COL_IMG_SRC = "ImgSrc";
    private static final String COL_TYPE1 = "Type1";
    private static final String COL_TYPE2 = "Type2";
    private static final String COL_LOCX = "LocationX";
    private static final String COL_LOCY = "LocationY";
    private static final String COL_DMG_TAKEN = "DamageTaken";
    private static final String COL_OWN = "Owned";
    private static final String COL_FAVORITE = "Favorite";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_POKEMON + " (" +
        COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    	COL_PID + " TEXT NOT NULL, " +
        COL_NAME + " TEXT NOT NULL, " +
        COL_IMG_SRC + " TEXT NOT NULL, " +
        COL_TYPE1 + " TEXT NOT NULL, " +
        COL_TYPE2 + " TEXT NOT NULL, " +
        COL_LOCX + " TEXT NOT NULL, " +
        COL_LOCY + " TEXT NOT NULL, " +
        COL_DMG_TAKEN + " TEXT NOT NULL, " +
        COL_OWN + " TEXT NOT NULL, " +
        COL_FAVORITE + " TEXT NOT NULL);";

    public DexterSQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table from the request written in CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        //delete table and recreate it, so when version changes, ids restart at 0
        db.execSQL("DROP TABLE " + TABLE_POKEMON + ";");
        onCreate(db);
    }
}
