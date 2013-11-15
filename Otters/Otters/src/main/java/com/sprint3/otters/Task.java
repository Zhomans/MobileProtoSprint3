package com.sprint3.otters;

/**
 * Created by zach on 11/14/13.
 */
public class Task {
    String name, description, size, date, id;
    Integer priority, reoccuring;
    //Constructor
    public Task (String name,String description,String size,Integer priority,Integer reoccuring,String date){
        this.name = name;
        this.description = description;
        this.size = size;
        this.priority = priority;
        this.reoccuring = reoccuring;
        this.date = date;
    }

    //Setting the ID retrieved from the server
    public void setId(String value){
        this.id = value;
    }
}
