//package com.example.finaltodoapp.data;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.example.finaltodoapp.model.ETodo;
//import com.example.finaltodoapp.model.ToDoDAO;
//
//@Database(entities = {ETodo.class},version = 1, exportSchema = false)
//
//public abstract class TodoRoomDatabase extends RoomDatabase {
//    public abstract ToDoDAO mTodoDAO();
//
//    ///Creating singleton object
//    public static TodoRoomDatabase INSTANCE;  //prevent memory leaks
//    public static TodoRoomDatabase getDatabase(Context context){
//        if(INSTANCE == null){
//            synchronized (TodoRoomDatabase.class){
//                if(INSTANCE==null){
//                   INSTANCE = Room.databaseBuilder(context.getApplicationContext(),TodoRoomDatabase.class,"todo.db")
//                       .allowMainThreadQueries()
//                       .fallbackToDestructiveMigration()
//                       .build();
//                    }
//                }
//            }
//
//        return INSTANCE;
//    }
//
//}
//
//
//
//
