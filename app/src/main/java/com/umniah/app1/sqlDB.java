package com.umniah.app1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;


public class sqlDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "ensa";
    public static final String ID = "id";
    public static final String TITLE = "TITLE";
    public static final String SUBTITLE = "SUBTITLE";
    public static final String DATABASE_NAME = "ensa2.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " ( " + ID + "INTEGER PRIMARY KEY," + TITLE + " TEXT," + SUBTITLE + " TEXT )";

    public sqlDB(@Nullable  Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insert(String title , String subtitle)
    {
        Log.d("ensak","invoke insert");
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, title);
        values.put(SUBTITLE, subtitle);

        db.insert(TABLE_NAME,null,values);
    }

    public ArrayList<String> read()
    {
        Log.d("ensak","invoke read");
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);

        ArrayList<String> items = new ArrayList<String>();
        while(cursor.moveToNext())
        {
            String itemTitle = cursor.getString(cursor.getColumnIndexOrThrow(TITLE));
            items.add(itemTitle);

        }
        cursor.close();

        return items;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.d("ensak", "database craeted");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }
}
