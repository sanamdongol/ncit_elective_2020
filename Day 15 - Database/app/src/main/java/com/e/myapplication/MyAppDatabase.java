package com.e.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Customer.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
}
