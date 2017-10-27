package com.example.android.revision;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 10/26/2017.
 */

public class DBSetting extends SQLiteOpenHelper {
    static int version=1;
    static String databasename="user";
    String tablename="emp";
    String firstcolumn="username";
    String secondcolumn="password";
    public DBSetting(Context context) {
        super(context, databasename, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String query="create table "+tablename+"("+firstcolumn+" text,"+secondcolumn+" text "+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   db.execSQL("drop table if exists " +tablename);
    }

    public int insertData(Bean bean)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(firstcolumn,bean.getUsername());
        contentValues.put(secondcolumn,bean.getPassword());
        int value= (int) sqLiteDatabase.insert(tablename,null,contentValues);
        return value;
    }

    public List<Bean> getAllRecords()
    {
        List<Bean> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String query="select * from "+tablename;
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
            do {
                Bean bean=new Bean();
                bean.setUsername(cursor.getString(0));
                bean.setPassword(cursor.getString(1));
                list.add(bean);
            }while (cursor.moveToNext());
        return list;
    }
}
