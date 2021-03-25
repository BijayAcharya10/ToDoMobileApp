package com.example.finaltodoapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finaltodoapp.model.ETodo;
import com.example.finaltodoapp.model.User;

import java.util.List;

public interface UserDAO {
    @Insert
    void insert(User user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Delete
    void deleteById(User user);

    @Query("SELECT * FROM user_table WHERE id=:id")
    User getUserById(String id);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User... user);

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();
}
