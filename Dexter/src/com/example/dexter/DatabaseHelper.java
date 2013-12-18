package com.example.dexter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper 
{
	
	// Database version
	private static final int DATABASE_VERSION = 1;
	
	// DB name
	private static final String DATABASE_NAME = "pokedb";
	
	// DB instance
	private static DatabaseHelper instance;
	
    public DatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		
//		//testing to see if we enter here. set to 1000000 for 20s delay.
//        for(int i =0; i < 100000; i++) {
//        	System.out.println("a");
//        }
	}

    public static synchronized DatabaseHelper getHelper(Context context)
    {
        if (instance == null)
            instance = new DatabaseHelper(context);

        return instance;
    }

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO Auto-generated method stub
		//we will actually create the db here
		//not sure if we physically call this method or if it gets called automatically
		//each time we create an object, like other onCreate() methods.
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub
		
	}
}