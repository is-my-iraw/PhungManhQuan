package com.example.phungmanhquan.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String Name;
    @ColumnInfo(name = "email")
    public String Email;
    @ColumnInfo(name = "description")
    public String Description;
    @ColumnInfo(name = "gender")
    public String Gender;
}
