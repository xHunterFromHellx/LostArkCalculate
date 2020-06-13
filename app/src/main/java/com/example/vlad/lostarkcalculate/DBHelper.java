package com.example.vlad.lostarkcalculate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "buildsDb";
    public static final String TABLE_BUILDS = "builds";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_CLASS = "class";
    public static final String KEY_BUILD = "builds";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_BUILDS + "(" + KEY_ID + " integer primary key," + KEY_NAME +
                 " text," + KEY_CLASS + " text, " +  KEY_BUILD + "text " + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_BUILDS);

        onCreate(db);
    }
}
