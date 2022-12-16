package com.example.filmy;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie")
public class MovieModel {
    @PrimaryKey()
    private int id;

    @ColumnInfo(name = "title")
    private String title;
}
