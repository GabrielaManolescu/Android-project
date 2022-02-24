package com.example.gestiunechirii;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    private static final SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    @TypeConverter
    public static Date fromString(String value){
        try{
            return formatter.parse(value);
        }catch (ParseException e){
            return null;
        }
    }
    @TypeConverter
    public static String fromDate(Date date){
        if(date==null){
            return null;
        }
        return formatter.format(date);
    }

}
