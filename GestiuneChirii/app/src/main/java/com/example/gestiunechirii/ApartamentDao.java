package com.example.gestiunechirii;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ApartamentDao {

    @Insert
    long insert(Apartments apartments);

    @Query("select * from apartment")
    List<Apartments> getAll();

    @Update
    int update(Apartments expense);

    @Delete
    int delete(Apartments expense);
}
