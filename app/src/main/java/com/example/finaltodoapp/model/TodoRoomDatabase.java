package com.example.finaltodoapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.finaltodoapp.data.TodoDAO;
import com.example.finaltodoapp.data.UserDAO;

@Database(entities = {User.class,ETodo.class}, version = 2, exportSchema = false)
public abstract class TodoRoomDatabase extends RoomDatabase {
    public abstract TodoDAO mTodoDao();
    public abstract UserDAO mUserDao();

    public static TodoRoomDatabase INSTANCE;
    public static TodoRoomDatabase getDatabase(Context context){
        if(INSTANCE == null) {
            synchronized (TodoRoomDatabase.class){
                if(INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodoRoomDatabase.class,
                            "todoapp.db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
