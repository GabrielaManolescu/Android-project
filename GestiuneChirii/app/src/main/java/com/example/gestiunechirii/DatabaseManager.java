package com.example.gestiunechirii;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Apartments.class}, exportSchema = false, version = 1)
@TypeConverters({DateConverter.class})
public abstract class DatabaseManager extends RoomDatabase {
    public static final String CHIRII_DB = "Users";
    private static DatabaseManager databaseManager;
//de sters

    public static DatabaseManager getInstance(Context context){
        if (databaseManager == null) {
          synchronized (DatabaseManager.class) {
                if (databaseManager == null) {
                   databaseManager = Room.databaseBuilder(context, DatabaseManager.class, CHIRII_DB)
                        .fallbackToDestructiveMigration().build();
                }
            }

        }
        return databaseManager;
    }

    public abstract ApartamentDao getExpenseDao();//da accesul


}
