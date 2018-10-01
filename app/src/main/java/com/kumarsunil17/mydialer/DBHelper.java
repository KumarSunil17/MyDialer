package com.kumarsunil17.mydialer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    Context c;

    public static String DATABASE = "database.db";
    public static String TABLE = "callog";
    public static String NUMBER = "number";
    public static String DATE = "date";

    public DBHelper(Context context) {
        super(context, DATABASE, null, 1);
        this.c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE+" ("+NUMBER+" text, "+DATE+" text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE+" ;");
    }
    public void insert(String num,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NUMBER,num);
        content.put(DATE,date);
        db.insert(TABLE,null,content);
    }

    public List<People> getData(){
        List<People> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from "+TABLE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        People p = null;

       // c.moveToFirst();
        while (c.moveToNext()) {
            p = new People();
            String num = c.getString(c.getColumnIndexOrThrow(NUMBER));
            String date = c.getString(c.getColumnIndexOrThrow(DATE));
            p.setNumber(num);
            p.setDate(date);
            stringBuffer.append(p);
            data.add(p);
        }
        return data;
    }
}
