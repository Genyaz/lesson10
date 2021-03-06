package com.example.lesson10.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: Genyaz
 * Date: 28.11.13
 * Time: 7:37
 * To change this template use File | Settings | File Templates.
 */
public class CitiesDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String _ID = "_id";
    public static final String DATABASE_NAME = "citiesdb";
    public static final String CITY_NAME = "city_name";

    public static final String CREATE_DATABASE = "CREATE TABLE " + DATABASE_NAME
            + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CITY_NAME + " TEXT);";

    public static final String DROP_DATABASE = "DROP TABLE IF EXISTS " + DATABASE_NAME;

    public CitiesDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion) {
            db.execSQL(DROP_DATABASE);
            onCreate(db);
        }
    }
}
