package com.sprint3.otters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by zach on 11/14/13.
 */

public class DatabaseModel extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "tasks";
    public static final String TASK_NAME = "name";
    public static final String TASK_DESCRIPTION = "description";
    public static final String TASK_SIZE = "size";
    public static final String TASK_PRIORITY = "priority";
    public static final String TASK_REOCCURING = "reoccuring";
    public static final String TASK_DATE  = "date";
    public static final String TASK_ID  = "id";

    private static final String DATABASE_NAME = "OttersDB";
    private static final int DATABASE_VERSION = 1;

    // DatabaseModel creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "("
            + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TASK_NAME + " TEXT NOT NULL, "
            + TASK_DESCRIPTION + " TEXT NOT NULL, "
            + TASK_SIZE + " TEXT NOT NULL, "
            + TASK_PRIORITY + " INTEGER NOT NULL, "
            + TASK_REOCCURING + " INTEGER NOT NULL, "
            + TASK_DATE + " TEXT NOT NULL, "
            + TASK_ID + " TEXT NOT NULL);";

    //Default Constructor
    public DatabaseModel(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //OnCreate Method - creates the DatabaseModel
    public void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);

    }
    @Override
    //OnUpgrade Method - upgrades DatabaseModel if applicable
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        Log.w(DatabaseModel.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

}
