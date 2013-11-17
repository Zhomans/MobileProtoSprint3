package com.sprint3.otters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by zach on 11/14/13.
 */
public class DBHandler {
    private DatabaseModel model;
    private SQLiteDatabase database;

    //Columns in the database
    private String[] allColumns = {
            DatabaseModel.TASK_NAME,
            DatabaseModel.TASK_DESCRIPTION,
            DatabaseModel.TASK_SIZE,
            DatabaseModel.TASK_PRIORITY,
            DatabaseModel.TASK_REOCCURING,
            DatabaseModel.TASK_DATE,
            DatabaseModel.TASK_ID,
    };

    //Public Constructor
    public DBHandler(Context context){
        model = new DatabaseModel(context);
    }

    //Opening the Database (Getting the writable Database)
    public void open(){
        database = model.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    //Update a post
    public void updateTask(Task task){
        deleteTaskById(task.id);
        addTask(task);
    }

    public ArrayList<String> getAllTaskIds(){
        Cursor cursor = database.query(DatabaseModel.TABLE_NAME, new String[]{DatabaseModel.TASK_ID}, null, null, null, null, DatabaseModel.TASK_DATE);
        ArrayList<String> ids = new ArrayList<String>();
        cursor.moveToFirst();
        String curID;
        while (!cursor.isAfterLast()){
            curID = cursor.getString(0);
            if (curID.length() > 16) {
                ids.add(curID);
            }
            cursor.moveToNext();
        }
        cursor.close();
        if (ids.size() < 1){
            ids.add("aaaaaaaaaaaa");
        }
        Log.i("ids", ids.toString());
        return ids;
    }

    //Adding a Post
    public void addTask(Task newTask){
        //Creating a value holder
        ContentValues values = new ContentValues();
        //Unpacking Post information to holder
        values.put(DatabaseModel.TASK_NAME, newTask.name);
        values.put(DatabaseModel.TASK_DESCRIPTION, newTask.description);
        values.put(DatabaseModel.TASK_SIZE, newTask.size);
        values.put(DatabaseModel.TASK_PRIORITY, newTask.priority);
        values.put(DatabaseModel.TASK_REOCCURING, newTask.reoccuring);
        values.put(DatabaseModel.TASK_DATE, newTask.date);
        values.put(DatabaseModel.TASK_ID, newTask.id);

        //Inserting into database
        this.database.insert(DatabaseModel.TABLE_NAME, null, values);
    }

    //Getting Tasks by Size in descending priority order
    public ArrayList<Task> getTasksBySize(String size){
        return sweepCursor(
                database.query(DatabaseModel.TABLE_NAME, allColumns, DatabaseModel.TASK_SIZE + " like '%" + size + "%'", null, null, null, DatabaseModel.TASK_PRIORITY + " DESC"));
    }

    //Delete Tasks by ID
    public void deleteTaskById(String id){
        database.delete(DatabaseModel.TABLE_NAME, DatabaseModel.TASK_ID + " like '%" + id + "%'", null);
    }

    //Get Tasks from Cursor
    public ArrayList<Task> sweepCursor (Cursor cursor) {
        ArrayList<Task> tasks = new ArrayList<Task>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tasks.add(cursorToPost(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return tasks;
    }

    //Get Tasks from Cursor
    public Task cursorToPost(Cursor cursor){
        Task task = new Task(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getInt(4),
                cursor.getString(5)
        );
        task.setId(cursor.getString(6));
        Log.i ("id", cursor.getString(6));
        return task;
    }

}
