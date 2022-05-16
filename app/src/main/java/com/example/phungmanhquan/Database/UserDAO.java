package com.example.phungmanhquan.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void Insert(User user);

    @Update
    void Update(User user);

    @Delete
    void Delete(User user);

    @Query("select * from user")
    List<User> getUserAll();

    @Query("select * from user where id = :id")
    User getUser(int id);


    @Query("SELECT Total('id')  FROM user")
    Integer Total();
}
