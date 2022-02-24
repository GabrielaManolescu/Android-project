package com.example.gestiunechirii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

private static final int DATABASE_VERSION=1;
private static final String DATABASE_NAME="houseS";
    private static final String TABLE_NAME="house";

    private static final String ID="id";
    private static final String DESCRIPTION="description";
    private static final String LOCATION="location";
    private SQLiteDatabase sqLiteDatabase;

    private static final String CREATE_TABLE="create table "+TABLE_NAME+"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+ DESCRIPTION+" TEXT NOT NULL,"+
            LOCATION+" TEXT NOT NULL);";
    public DatabaseHelperClass(Context context){//CONSTRUCTOR
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
        db.execSQL(CREATE_TABLE);}
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //add case
    public void addHouses(Houses houses){
        ContentValues contentValues= new ContentValues();
        contentValues.put(DatabaseHelperClass.DESCRIPTION, houses.getNameHouse());
        contentValues.put(DatabaseHelperClass.LOCATION, houses.getLocation());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
    }

    public List<Houses> getHousesList(){
        String sql= "select * from "+ TABLE_NAME;
        sqLiteDatabase=this.getReadableDatabase();
        List<Houses> hou= new ArrayList<>();

        Cursor cursor= sqLiteDatabase.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id= Integer.parseInt(cursor.getString(0));
                String description= cursor.getString(1);
                String location= cursor.getString(2);
                hou.add(new Houses(id, description, location));
            }while(cursor.moveToNext());
        }cursor.close();
        return hou;
    }
    public void updateHouse(Houses houses){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.DESCRIPTION,houses.getNameHouse());
        contentValues.put(DatabaseHelperClass.LOCATION,houses.getLocation());
        sqLiteDatabase= this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME, contentValues, ID + " = ?" , new String[]
                {String.valueOf(houses.getId())});
    }
    public void deleteHouse(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }
}
